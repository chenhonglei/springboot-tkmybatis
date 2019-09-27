package com.bai.json.controller;

import com.alibaba.fastjson.JSON;
import com.bai.json.entity.FastJsonEntity;
import com.bai.json.entity.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * json格式数据的测试使用fastjson格式化数据
 * @author CHL
 */
@RestController
@Log4j2
public class JsonController {
    @PostMapping("/show")
    public FastJsonEntity getFastJson(@RequestBody UserEntity u) {
        FastJsonEntity fje = new FastJsonEntity();
        fje.setString("再看把你吃掉");
        fje.setIgnore("ignore field" + u.getUserCode());
        fje.setDate(new Date());
        log.info(JSON.toJSONString(u));
        return fje;
    }

}
