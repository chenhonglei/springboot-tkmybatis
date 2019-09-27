package com.bai.json.service.impl;

import com.bai.json.dao.UserDao;
import com.bai.json.entity.UserEntity;
import com.bai.json.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> selectByEntity(UserEntity u) {
        if(Objects.isNull(u)) {
            u = new UserEntity();
        }
        Example example = new Example(UserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(u);
        return userDao.selectByExample(example);
    }

    /**
     * 自定义sql语句查询
     * @param u
     * @return
     */
    @Override
    public Map<String, Object> selectMapByUser(UserEntity u) {
        return userDao.selectMapByUser(u);
    }

    /**
     * 自定义插入功能
     * @param uu
     * @return
     */
    @Override
    public int saveUserEntity(UserEntity uu) {
        return userDao.insert(uu);
    }
}
