package mobi.smartj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mobi.smartj.model.Tweet;

@Mapper
public interface TweetsMapper {
	List<Tweet> select(
			@Param("table") String table
			,@Param("count") Integer count
			,@Param("maxId") Integer maxId
			,@Param("sinceId") Integer sinceId);
}
