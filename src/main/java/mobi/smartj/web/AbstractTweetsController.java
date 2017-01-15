package mobi.smartj.web;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import mobi.smartj.mapper.TweetsMapper;
import mobi.smartj.model.Tweet;

/**
 * ツイートの情報を返すRESTコントローラ。
 * @author motoy3d
 */
public abstract class AbstractTweetsController {
//	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final int DEFAULT_COUNT = 50;
	@Autowired
	private TweetsMapper tweetsMapper;
	
	/**
	 * 検索対象テーブル名を返す (SearchTweets or PlayerTweets)
	 * @return
	 */
	public abstract String getTarget();

	protected List<Tweet> find(String teamId, String count1, String maxId1, String sinceId1) {
		int count = DEFAULT_COUNT;
		if(count1 != null && NumberUtils.isDigits(count1)) {
			count = Integer.parseInt(count1);
			if(200 <= count) {
				count = DEFAULT_COUNT;
			}
		}
		String table = teamId + getTarget();
        List<Tweet> tweetsList = tweetsMapper.select(
        		table, count, NumberUtils.toInt(maxId1), NumberUtils.toInt(sinceId1));
        return tweetsList;
	}
}
