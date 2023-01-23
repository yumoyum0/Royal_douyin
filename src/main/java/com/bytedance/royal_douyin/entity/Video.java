package com.bytedance.royal_douyin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yumo
 * @Description: video实体类
 * @DateTime: 2023/1/23 10:27
 **/
@NoArgsConstructor
@Data
public class Video {


    @JsonProperty("id")
    private Integer id;
    @JsonProperty("author")
    private User author;
    @JsonProperty("play_url")
    private String playUrl;
    @JsonProperty("cover_url")
    private String coverUrl;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("is_favorite")
    private Boolean isFavorite;
    @JsonProperty("title")
    private String title;
}
