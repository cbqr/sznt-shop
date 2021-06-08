package com.sznt.shop.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sznt.shop.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 *
 * @author S Mr.L
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class UserDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 用户签名
     */
    private String slogan;

    /**
     * 0表示女，1表示男
     */
    private Integer sex;

    /**
     * 积分
     */
    private Integer points;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 盐，用于个人敏感信息处理
     */
    private String secret;

}
