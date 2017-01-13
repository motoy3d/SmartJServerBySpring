package mobi.smartj.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * アプリ起動時に表示するメッセージのJSONを返すコントローラ。
 * レッズ用。
 * 他チームは↓
 * @see ConfigController
 * @author motoy3d
 */
@RestController
public class MessageController {
//	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = "/message.json")
	public List<Map<String, Object>> find(String os, String teamId, String version) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("message", "古いバージョンのアプリをお使いです。最新版への更新をお願いしますm(_ _)m");
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		resultList.add(result);
		return resultList;
	}
}
