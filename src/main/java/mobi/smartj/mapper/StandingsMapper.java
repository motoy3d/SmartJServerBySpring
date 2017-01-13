package mobi.smartj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mobi.smartj.model.Standings;

@Mapper
public interface StandingsMapper {
	List<Standings> selectForJ(
			@Param("season") String season
			,@Param("teamId") String teamId
			,@Param("sort") String sort
			);

	List<Standings> selectForLevain(
			@Param("season") String season
			,@Param("teamName") String teamName
			);

	List<Standings> selectForACL(
			@Param("season") String season
			,@Param("teamName") String teamName
			);
}
