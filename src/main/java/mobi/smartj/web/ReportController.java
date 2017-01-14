package mobi.smartj.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ユーザーからの報告受付コントローラ。
 * @author motoy3d
 */
@RestController
public class ReportController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * ユーザーからの報告受付
	 */
	@GetMapping(value = "/report.json")
	public String find(String userId, String url, String type) {
		logger.info("ユーザーからの報告.  userId=" + userId + ", url=" + url + ", type=" + type);
		return "ok";
	}
}
