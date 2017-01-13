package mobi.smartj.model;

import lombok.Data;

@Data
public class NewsEntry {
	private Integer entryId;
	private String entryUrl;
	private String entryTitle;
	private String content;
	private String imageUrl;
	private Integer imageWidth ;
	private Integer imageHeight ;
	private String siteName;
	private String publishedDate;
	private Integer publishedDateNum;
}
