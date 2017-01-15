package mobi.smartj.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mobi.smartj.mapper.MessageMapper;
import mobi.smartj.mapper.NgSiteMapper;
import mobi.smartj.mapper.TeamMasterMapper;
import mobi.smartj.model.Message;
import mobi.smartj.model.NgSite;
import mobi.smartj.model.TeamMaster;

/**
 * アプリのチーム情報やメッセージ等の情報を返すRESTコントローラ。
 * アプリから最初に呼ばれる。
 * @author motoy3d
 */
@RestController
public class ConfigController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private TeamMasterMapper teamMasterMapper;
	@Autowired
	private NgSiteMapper ngSiteMapper;
	
	@GetMapping(value = "/config.json")
	public List<Map<String, Object>> find(String os, String osversion, String teamId, String appversion
			, String version) {
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("os={} osversion={} teamId={}", os, osversion, teamId);
		if (StringUtils.isBlank(osversion)) {
			osversion = version;		//古いアプリへの対応
		}
//TODO アプリバージョンによるメッセージ判定			
		if (StringUtils.isBlank(appversion)) {
			appversion = "1.0.0";
		}
		List<Message> messageList = messageMapper.select(os, appversion, teamId);
		if (messageList != null && !messageList.isEmpty()) {
			result.put("message", messageList.get(0).getMessage());
		}
		TeamMaster team = teamMasterMapper.selectOne(teamId);
		result.put("jcategory", team.getCategory());
		result.put("adType", team.getAdType());
		result.put("aclFlg", team.getAclFlg().toString());

		// TODO 他チーム情報表示機能はJ1のみ有効
		if ("J1".equals(team.getCategory())) {
			result.put("isOtherTeamNewsFeatureEnable", "true");
		} else {
			result.put("isOtherTeamNewsFeatureEnable", "false");
		}
		// 2ステージ制フラグ.  2017シーズンは１ステージ制
		result.put("is2stages", "false");
				
		// NGサイトリスト(リジェクト対策)
		List<NgSite> ngSiteList1 = ngSiteMapper.selectAll();
		String[] ngSiteList2 = new String[ngSiteList1.size()];
		int idx = 0;
		for(NgSite ngSite : ngSiteList1) {
			ngSiteList2[idx++] = ngSite.getDomain();
		}
		result.put("ngSiteList", ngSiteList2);
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		resultList.add(result);
		
		return resultList;
	}

}
