package com.bytedance.royal_douyin.model.video;

import com.bytedance.royal_douyin.entity.User;
import com.bytedance.royal_douyin.entity.Video;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: yumo
 * @Description: 视频流Model
 * @DateTime: 2023/1/23 10:38
 **/
@NoArgsConstructor
@Data
public class VideoFeedModel {

    @JsonProperty("video_ist")
    private List<Video> videoList;
    @JsonProperty("next_time")
    private Long nextTime;
}
