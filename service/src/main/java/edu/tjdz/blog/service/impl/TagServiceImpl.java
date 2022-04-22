package edu.tjdz.blog.service.impl;

import edu.tjdz.blog.beans.bean.Tag;
import edu.tjdz.blog.dao.TagMapper;
import edu.tjdz.blog.service.TagService;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public ResultVO listTag() {
        List<Tag> tags = tagMapper.listTag();
        return new ResultVO(Code.SUCCESS,"",tags);



    }
}
