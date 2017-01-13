package mobi.smartj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mobi.smartj.model.NewsEntry;

@Mapper
public interface NewsEntryMapper {
	List<NewsEntry> select(
			@Param("table") String table
			,@Param("avoidTable") String avoidTable
			,@Param("maxDatetime") int maxDatetime
			,@Param("minDatetime") Integer minDatetime
			,@Param("count") Integer count
			);
}
