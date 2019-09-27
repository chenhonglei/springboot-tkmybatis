package com.bai.json.entity;

import com.bai.json.mybatis.SimpleGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "oc_user")
public class UserEntity implements Serializable {
    @Id
    @KeySql(genId = SimpleGenId.class)
    private Long id;
    private String userCode;
    private String employName;
    private String roleCode;
    private String roleName;
}
