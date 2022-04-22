package edu.tjdz.blog.service.impl;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import edu.tjdz.blog.beans.bean.Comment;
import edu.tjdz.blog.dao.CommentMapper;
import edu.tjdz.blog.service.CommentService;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private  SensitiveWordBs sensitiveWordBs;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultVO commentCommit(Comment comment) {
        Integer articleId = comment.getArticleId();
        comment.setCommentContent(sensitiveWordBs.replace(comment.getCommentContent()));
        comment.setCreTime(new Date());
        Integer commentId = commentMapper.addComment(comment);
        List<Comment>  comments = commentMapper.listCommentByArticleId(articleId);
        return new  ResultVO(Code.SUCCESS,"",comments);
    }
}
