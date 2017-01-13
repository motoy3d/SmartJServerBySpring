package mobi.smartj.model;

import lombok.Data;

@Data
public class Standings {
	private String league;
	private Integer seq;
	private Integer rank;
	private String teamId;
	private String teamName;
	private String team;
	private Integer point;
	private Integer games;
	private Integer win;
	private Integer draw;
	private Integer lose;
	private Integer gotGoal;
	private Integer lostGoal;
	private Integer diff;	
}
