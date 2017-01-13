package mobi.smartj.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mobi.smartj.model.Tweet;

/**
 * 一般ユーザのツイートの情報を返すRESTコントローラ。
 * @author motoy3d
 */
@RestController
public class SearchTweetsController extends AbstractTweetsController {
	
	/**
	 * 検索対象テーブル名を返す (searchTweets or playerTweets)
	 * @return
	 */
	public String getTarget() {
		return "searchTweets";
	}

	@GetMapping(value = "/searchTweets.json")
	public List<Tweet> find(String teamId, String count1, String maxId1, String sinceId1) {
		return super.find(teamId, count1, maxId1, sinceId1);
	}

}
