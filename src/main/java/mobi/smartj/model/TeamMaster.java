package mobi.smartj.model;

import lombok.Data;

@Data
public class TeamMaster {
	private String teamId;
	private String teamName;
	private String teamName2;
	private String teamName3;
	private String teamName4;
	private String category;
	private Boolean aclFlg;
	private String searchTweetsKeyword;
	private int playerTweetsListId;
	private int adType;
}
