package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Uri;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UriMapper {

    List<Uri> listUriByRoleId(int role_id);

}
