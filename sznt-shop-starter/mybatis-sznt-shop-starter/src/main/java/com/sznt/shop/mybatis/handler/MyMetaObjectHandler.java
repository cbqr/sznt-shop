package com.sznt.shop.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 元对象字段填充控制器，实现公共字段自动写入
 *
 * @author S Mr.L 
 * @since 2021-06-09
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 从元对象中获取 createTime 的 SetCreateTime() 方法
        boolean hasSetter = metaObject.hasSetter("createTime");
        // 从对象中获取 createTime 字段值
        Object val = getFieldValByName("createTime", metaObject);
        if (hasSetter && val == null) {
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        boolean hasSetter = metaObject.hasSetter("updateTime");
        Object val = getFieldValByName("updateTime", metaObject);
        if (hasSetter && val == null) {
            this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        }
    }
}