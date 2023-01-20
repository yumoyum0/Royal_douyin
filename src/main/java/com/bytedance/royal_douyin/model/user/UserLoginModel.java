package com.bytedance.royal_douyin.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 16:55
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginModel {
    /**
     * 用户id
     */
    @JsonProperty("user_id")
    private Long userId;
    /**
     * 用户鉴权token
     */
    @JsonProperty("token")
    private String token;
}
