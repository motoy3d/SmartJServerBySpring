package mobi.smartj.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mobi.smartj.mapper.ResultsMapper;
import mobi.smartj.model.GameResult;

/**
 * 試合日程／結果の情報を返すRESTコントローラ。
 * @author motoy3d
 */
@RestController
public class ResultsController {
//	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ResultsMapper resultsMapper;
	
	@GetMapping(value = "/results.json")
	public List<GameResult> find(String season, String teamId, String otherTeamId) {
		if (StringUtils.isNotBlank(otherTeamId)) {
			teamId = otherTeamId;
		}
		String table = teamId + "Results";
		List<GameResult> resultsList = resultsMapper.select(season, table);
		return resultsList;
	}
}
