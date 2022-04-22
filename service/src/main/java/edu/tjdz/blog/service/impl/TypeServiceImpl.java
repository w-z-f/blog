package edu.tjdz.blog.service.impl;

import edu.tjdz.blog.beans.bean.Type;
import edu.tjdz.blog.dao.TypeMapper;
import edu.tjdz.blog.service.TypeService;
import edu.tjdz.common.vo.Code;
import edu.tjdz.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public ResultVO listType() {
        List<Type> types = typeMapper.listType();
        return new ResultVO(Code.SUCCESS,"",types);
    }

}
