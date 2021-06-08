package com.sznt.shop.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 *
 * @author S Mr.L 
 * @since 2021-05-31
 */
@Data
public class BaseDO implements Serializable {

    private static final long serialVersionUID = 8731637083648092757L;

    /**
     * 记录主键，默认雪花算法
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 记录创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 记录更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}