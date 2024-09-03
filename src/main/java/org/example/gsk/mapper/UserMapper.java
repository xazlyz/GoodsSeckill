package org.example.gsk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.gsk.entity.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
