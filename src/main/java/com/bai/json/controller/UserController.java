package com.bai.json.controller;

import com.bai.json.entity.UserEntity;
import com.bai.json.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    /****
     * 1. 引入TkMybatis的Maven依赖
     * 2. 实体类的相关配置,@Id,@Table
     * 3. Mapper继承tkMabatis的Mapper接口
     * 4. 启动类Application或自定义Mybatis配置类上使用@MapperScan注解扫描Mapper接口
     * 5. 在application.properties配置文件中,配置mapper.xml文件指定的位置[可选]
     * 6. 使用TkMybatis提供的sql执行方法
     *
     * PS :
     *     1. TkMybatis默认使用继承Mapper接口中传入的实体类对象去数据库寻找对应的表,因此如果表名与实体类名不满足对应规则时,会报错,这时使用@Table为实体类指定表。(这种对应规则为驼峰命名规则)
     *     2. 使用TkMybatis可以无xml文件实现数据库操作,只需要继承tkMybatis的Mapper接口即可。
     *     3. 如果有自定义特殊的需求,可以添加mapper.xml进行自定义sql书写,但路径必须与步骤4对应。
     *
     * 6. 如有需要,实现mapper.xml自定义sql语句
     */

    @Autowired
    private UserService userService;

    @PostMapping("/show")
    public List<UserEntity> getFastJson(@RequestBody UserEntity u) {

        return userService.selectByEntity(u);
    }

    /**
     * 自定义sql语句查询
     * @param u
     * @return
     */
    @PostMapping("/show/one")
    public Map<String,Object> getMapByUser(@RequestBody UserEntity u) {
        return userService.selectMapByUser(u);
    }
    /****
     * 自定义插入功能
     */

    @PostMapping("save/user")
    public int saveUserEntity(@RequestBody UserEntity uu){

        return userService.saveUserEntity(uu);
    }


}
