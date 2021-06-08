package com.sznt.shop.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sznt.shop.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收发货地址实体类
 *
 * @author S Mr.L
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("address")
public class AddressDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 是否默认收货地址：0->否；1->是
     */
    private Integer defaultStatus;

    /**
     * 收发货人姓名
     */
    private String receiveName;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 省/直辖市
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String region;

    /**
     * 详细地址
     */
    private String detailAddress;

}
