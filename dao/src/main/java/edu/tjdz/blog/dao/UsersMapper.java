package edu.tjdz.blog.dao;

import edu.tjdz.blog.beans.bean.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    Users getUserByUsername(String username);

    Users getUserByUserId(int user_id);

    Users getUserByPhoneNum(String phone);

    int updateAvatarUri(String avatarUri,int userId);
}
