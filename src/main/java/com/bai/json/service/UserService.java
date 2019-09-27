package com.bai.json.service;

import com.bai.json.entity.UserEntity;

import java.util.List;
import java.util.Map;


public interface UserService {
    List<UserEntity> selectByEntity(UserEntity u);
    Map<String, Object> selectMapByUser(UserEntity u);
    int saveUserEntity(UserEntity uu);
}

