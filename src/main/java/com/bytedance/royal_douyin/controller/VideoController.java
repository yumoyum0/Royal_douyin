package com.bytedance.royal_douyin.controller;

import com.bytedance.royal_douyin.annotation.OperateLog;
import com.bytedance.royal_douyin.model.video.VideoFeedModel;
import com.bytedance.royal_douyin.service.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yumo
 * @Description: 视频Controller
 * @DateTime: 2023/1/23 10:37
 **/
@RestController
public class VideoController {

    @Resource
    private VideoService videoService;

    @GetMapping("/douyin/feed")
    @OperateLog("获取视频流")
    public VideoFeedModel feed(Long latestTime,String token){
        return videoService.feed(latestTime,token);
    }
}
