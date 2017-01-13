package mobi.smartj.model;

import lombok.Data;

@Data
public class Video {
	private String videoUrl;
	private String videoTitle;
	private String thumbnailUrl;
	private Integer viewCount;
	private Integer likeCount;
	private Integer dislikeCount;	
}
