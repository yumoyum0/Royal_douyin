package com.bytedance.royal_douyin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.royal_douyin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:37
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUserById(@Param("userId") Long userId);
}
