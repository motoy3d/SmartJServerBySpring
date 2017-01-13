package mobi.smartj.model;

import lombok.Data;

@Data
public class Tweet {
	private String tweetId;
	private String userName;
	private String userScreenName;
	private String userProfileImageUrl;
	private String tweet;
	private Integer retweetedCount;
	private Long createdAt;
}
