package com.bai.json.dao;

import com.bai.json.entity.UserEntity;
import com.bai.json.mybatis.CustomMapper;
import org.apache.ibatis.annotations.Options;

import java.util.Map;

/**
 * 用户实体 -- 数据库持久化层
 */
public interface UserDao extends CustomMapper<UserEntity> {

    /***
     * 自定义查询对象
     */
     Map<String, Object> selectMapByUser(UserEntity u);

    /**
     * 保存对象
     * @param uu
     * @return
     */
    int saveUserEntity(UserEntity uu);
}
