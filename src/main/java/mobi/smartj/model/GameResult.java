package mobi.smartj.model;

import java.util.Date;

import lombok.Data;

@Data
public class GameResult {
	private String compe;
	private Date gameDate1;
	private String gameDate2;
	private String kickoffTime;
	private String stadium;
	private Boolean homeFlg;
	private String vsTeam;
	private String tv;
	private String result;
	private String score;
	private String detailUrl;
	private String ticketUrl;
	
}
