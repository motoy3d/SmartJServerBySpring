package mobi.smartj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mobi.smartj.model.NgSite;

@Mapper
public interface NgSiteMapper {
	List<NgSite> selectAll();
}
