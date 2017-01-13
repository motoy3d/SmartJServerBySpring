package mobi.smartj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mobi.smartj.model.GameResult;

@Mapper
public interface ResultsMapper {
	List<GameResult> select(
			@Param("season") String season
			, @Param("table") String table);
}
