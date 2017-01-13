package mobi.smartj.web;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mobi.smartj.mapper.VideoMapper;
import mobi.smartj.model.Video;

/**
 * 動画の情報を返すRESTコントローラ。
 * @author motoy3d
 */
@RestController
public class VideoController {
//	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private VideoMapper videoMapper;
	
	@GetMapping(value = "/video.json")
	public List<Video> find(String teamId, String gameDate, String otherTeamId) {
		if (StringUtils.isNotBlank(otherTeamId)) {
			teamId = otherTeamId;
		}
//		String youtubeUrlBase = "https://www.youtube.com/watch?v=";
        String youtubeUrlBase1 = "http://www.youtube.com/embed/";
        String youtubeUrlBase2 = "?fs=1&autoplay=1";
        List<Video> videoList = videoMapper.select(
        		youtubeUrlBase1, youtubeUrlBase2, teamId, gameDate);
        return videoList;
	}

}
