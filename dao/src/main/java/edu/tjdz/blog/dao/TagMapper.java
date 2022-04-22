package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {

    List<Tag> listTag();

   Tag getTagByTag(String tag);

   Integer addTag(Tag tag);

   List<Tag> listTagByTagIds(String tags_id);
}
