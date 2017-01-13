package mobi.smartj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mobi.smartj.model.Message;

@Mapper
public interface MessageMapper {
	List<Message> select(@Param("os") String os, @Param("appVersion") String appVersion
			, @Param("teamId") String teamId);
}
