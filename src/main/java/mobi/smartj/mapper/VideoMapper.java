package mobi.smartj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mobi.smartj.model.Video;

@Mapper
public interface VideoMapper {
	List<Video> select(
			@Param("youtubeUrlBase1") String youtubeUrlBase1
			, @Param("youtubeUrlBase2") String youtubeUrlBase2
			, @Param("teamId") String teamId
			, @Param("gameDate") String gameDate);
}
