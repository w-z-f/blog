package edu.tjdz.blog.service;

import edu.tjdz.blog.beans.bean.Comment;
import edu.tjdz.common.vo.ResultVO;

public interface CommentService {

     ResultVO commentCommit(Comment comment);

}
