package com.bytedance.royal_douyin.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bytedance.royal_douyin.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: yumo
 * @Description: video表数据对象
 * @DateTime: 2023/1/23 10:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("video")
public class VideoDO {

    @TableId
    private Integer id;

    @TableField("user_id")
    private Long userId;
    @TableField("play_url")
    private String playUrl;
    @TableField("cover_url")
    private String coverUrl;
    @TableField("favorite_count")
    private Integer favoriteCount;
    @TableField("comment_count")
    private Integer commentCount;
    @TableField("title")
    private String title;

    @TableField(
            value = "create_time",
            fill = FieldFill.INSERT
    )
    private LocalDateTime createTime;


    @TableField(
            value = "update_time",
            fill = FieldFill.INSERT_UPDATE
    )
    private LocalDateTime updateTime;
}
