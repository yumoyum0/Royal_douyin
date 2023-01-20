package com.bytedance.royal_douyin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:00
 **/
@NoArgsConstructor
@Data
public class User {

    /**
     * 用户id
     */
    @JsonProperty("id")
    private Long id;

    /**
     * 用户名
     */
    @JsonProperty("name")
    private String name;

    /**
     * 关注总数
     */
    @JsonProperty("follow_count")
    private Long followCount;

    /**
     * 粉丝总数
     */
    @JsonProperty("follower_count")
    private Long followerCount;

    /**
     * true-已关注，false-未关注
     */
    @JsonProperty("is_follow")
    private Boolean isFollow;
}
