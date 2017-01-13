package mobi.smartj.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mobi.smartj.common.TeamUtils;
import mobi.smartj.mapper.StandingsMapper;
import mobi.smartj.model.Standings;

/**
 * J、ルヴァン、ACLの順位表のJSONを返すコントローラ。
 * @author motoy3d
 */
@RestController
public class StandingsController {
//	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private StandingsMapper standingsMapper;
	
	@GetMapping(value = "/standings.json")
	public List<Standings> find(String season, String teamId, String compe, String sort) {
		if("gotGoal".equals(sort)) {
			sort = "got_goal DESC, seq";
		} else if("lostGoal".equals(sort)) {
			sort = "lost_goal, seq";
		} else if("win".equals(sort)) {
			sort = "win DESC, seq";
		} else if("lost".equals(sort)) {
			sort = "lose, seq";
		} else if("draw".equals(sort)) {
			sort = "draw DESC, seq";
		} else if("diff".equals(sort)) {
			sort = "diff DESC, seq";
		} else {
			sort = "seq";
		}
		
		compe = StringUtils.defaultIfEmpty(compe, "J");
		List<Standings> standingsList = null;
		if ("J".equals(compe)) {
			standingsList = standingsMapper.selectForJ(season, teamId, sort);
		} else if ("Nabisco".equals(compe) || "Levain".equals(compe)) {	//ルヴァン
			String teamName = TeamUtils.getTeamName(teamId);
			standingsList = standingsMapper.selectForLevain(season, teamName);
		} else if ("ACL".equals(compe)) {
			String teamName = TeamUtils.getTeamName(teamId);
			//TODO ACL順位表用のチーム名要確認
			if (teamId.equals("reds")) {
				teamName = "浦和";
			}
			if (teamId.equals("gamba")) {
				teamName = "Ｇ大阪";
			}
			if (teamId.equals("sanfrecce")) {
				teamName = "広島";
			}
			if (teamId.equals("fctokyo")) {
				teamName = "Ｆ東京";
			}
			standingsList = standingsMapper.selectForACL(season, teamName);
		}
		// 長いチーム名だと順位表画面で切れてしまうので短い名前にセットする
		for (Standings team : standingsList) {
			String officialTeamName = team.getTeamName();
			team.setTeamName(TeamUtils.getShortTeamName(officialTeamName));
		}
		return standingsList;
	}
}
