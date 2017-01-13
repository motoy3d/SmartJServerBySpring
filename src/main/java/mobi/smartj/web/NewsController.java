package mobi.smartj.web;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mobi.smartj.mapper.NewsEntryMapper;
import mobi.smartj.model.NewsEntry;

/**
 * DBに格納されているフィードエントリデータから検索してニュース情報を返すRESTコントローラ。
 * @author motoy3d
 */
@RestController
public class NewsController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final int DEFAULT_COUNT = 30;
	private static final int MAX_COUNT = 100;
	@Autowired
	private NewsEntryMapper newsMapper;
	
	/**
	 * DBに格納されているフィードエントリデータから検索し、JSONを返す。
	 * パラメータにmaxが存在する場合、maxより古いデータを返す。
	 * minが存在する場合、minより新しいデータを返す。
	 */
	@GetMapping(value = "/news.json")
	public List<NewsEntry> find(String teamId, String count, String min, String max) {
		int count1 = DEFAULT_COUNT;
		if(count != null && NumberUtils.isDigits(count)) {
			count1 = Integer.parseInt(count);
			if(MAX_COUNT < count1) {
				count1 = MAX_COUNT;
			}
		}
		int maxDatetime = NumberUtils.toInt(max);		//この日時より古いデータを取得
		int minDatetime = NumberUtils.toInt(min);	//この日時より新しいを取得
		String table = teamId + "Entry";
		String avoidTable = teamId + "AvoidFeed";
		List<NewsEntry> entryList = newsMapper.select(
				table, avoidTable, maxDatetime, minDatetime, count1);		
		return entryList;
	}
}
