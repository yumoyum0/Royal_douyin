package com.bytedance.royal_douyin.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yumo
 * @Description: user表数据对象
 * @DateTime: 2023/1/23 11:02
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class UserDo {

    /**
     * 用户id
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 关注总数
     */
    @TableField("follow_count")
    private Long followCount;

    /**
     * 粉丝总数
     */
    @TableField("follower_count")
    private Long followerCount;

    public UserDo(String username, String password) {
        this.id = 0L;
        this.username = username;
        this.password = password;
    }
}
