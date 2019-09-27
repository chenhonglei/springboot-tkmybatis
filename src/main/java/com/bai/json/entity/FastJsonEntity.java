package com.bai.json.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * json格式实体
 */
@Data
public class FastJsonEntity extends BaseEntity {
    private Integer id;
    @JSONField(name = "description")
    private String string;
    /**
     * 格式化日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 转换为json时不包括该属性
     */
    @JSONField(serialize = false)
    private String ignore;
    @JSONField(name = "niHao")
    private String nihao = "";
    private UserEntity u;

}
