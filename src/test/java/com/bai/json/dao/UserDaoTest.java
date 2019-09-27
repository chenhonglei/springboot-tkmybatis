package com.bai.json.dao;

import com.bai.json.entity.UserEntity;
import com.bai.json.mybatis.SimpleGenId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void addUserTest() {
        UserEntity ue  = new UserEntity();
        ue.setUserCode("comego");
        ue.setEmployName("来去");
        ue.setRoleCode("0000");
        ue.setRoleName("来去管理");
        //使用tkmybatis的插入功能（ID为String自动生成）
        //当ID为String类型时在实体类中使用 @KeySql(genId = UUIdGenId.class)
        System.out.println(userDao.insert(ue));
    }



    @Test
    public void addUserListTest() {
        List<UserEntity> uList = new ArrayList<>();

        for(int i = 0;i<10000;i++){
            UserEntity ue  = new UserEntity();
            ue.setUserCode("comego" + i);
            ue.setEmployName("来去" + i );
            ue.setRoleCode("0000_test");
            ue.setRoleName("来去管理" + i);
            uList.add(ue);

        }

        //使用tkmybatis的批量插入功能（ID为Long自动生成）
        //id为Long类型时在实体类中使用 @KeySql(genId = SimpleGenId.class)
        userDao.insertList(uList);
    }


    /**
     * 自定义插入方法
     */

    @Test
    public void addOneUser() {
        Long l = new SimpleGenId().genId("a","b");

        UserEntity ue  = new UserEntity();
        //自定义的方法必须自动手工设置ID值
        ue.setId(l);
        ue.setUserCode("comego");
        ue.setEmployName("来去");
        ue.setRoleCode("0000_test");
        ue.setRoleName("来去管理");
        //返回插入的条数
        System.out.println(userDao.saveUserEntity(ue));
    }

}
