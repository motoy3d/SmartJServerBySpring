package mobi.smartj.mapper;

import org.apache.ibatis.annotations.Mapper;

import mobi.smartj.model.TeamMaster;

@Mapper
public interface TeamMasterMapper {
	TeamMaster selectOne(String teamId);
}
