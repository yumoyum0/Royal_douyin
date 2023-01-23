package com.bytedance.royal_douyin.service;

import com.bytedance.royal_douyin.model.video.VideoFeedModel;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/23 10:42
 **/
public interface VideoService {
    VideoFeedModel feed(Long latestTime, String token);
}
