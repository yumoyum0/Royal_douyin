package com.bytedance.royal_douyin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.royal_douyin.dataobject.VideoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: yumo
 * @Description: 视频mapper
 * @DateTime: 2023/1/23 10:42
 **/
@Mapper
public interface VideoMapper extends BaseMapper<VideoDO> {
}
