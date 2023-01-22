package com.bytedance.royal_douyin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:00
 **/
@NoArgsConstructor
@Data
@TableName("user")
public class User {

    /**
     * 用户id
     */
    @JsonProperty("id")
    @TableId()
    private Long id;

    /**
     * 用户名
     */
    @JsonProperty("name")
    @TableField("username")
    private String username;

    @JsonIgnore
    @TableField("password")
    private String password;
    /**
     * 关注总数
     */
    @JsonProperty("follow_count")
    @TableField("follow_count")
    private Long followCount;

    /**
     * 粉丝总数
     */
    @JsonProperty("follower_count")
    @TableField("follower_count")
    private Long followerCount;

    /**
     * true-已关注，false-未关注
     */
    @JsonProperty("is_follow")
    @TableField("is_follow")
    private Boolean isFollow;


    public User(String username, String password) {
        this.id = 0L;
        this.username = username;
        this.password = password;
    }
}