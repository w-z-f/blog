package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

   List<Integer> listTypeIdByType(String type);

   Type getTypeByTypeId(Integer type_id);

   List<Type> listType();

   Type getTypeByType(String type);

   Integer addType(Type type);




}
