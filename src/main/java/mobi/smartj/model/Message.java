package mobi.smartj.model;

import java.util.Date;

import lombok.Data;

@Data
public class Message {
	private String teamId;
	private int messageId;
	private String message;
	private String os;
	private Date startDate;
	private Date endDate;
	private String minVer;
	private String maxVer;
	
}
