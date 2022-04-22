package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {


   Role getRoleByRoleId(int role_id);
}
