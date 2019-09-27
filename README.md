### Springboot 与 fastjson的整合
* 1 在pom.xml文件中忽略spring-boot-starter-json
* 2 在pom.xml文件中增加fastjson 1.2.60 版本最新版
* 3 配置json的转换代码如下：
```
    
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //自定义fastjson配置
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                SerializerFeature.IgnoreNonFieldGetter,        // 是否输出值为null的字段,默认为false,我们将它打开
                SerializerFeature.WriteNullListAsEmpty,     // 将Collection类型字段的字段空值输出为[]
                SerializerFeature.WriteNullNumberAsZero,    // 将数值类型字段的空值输出为0
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect    // 禁用循环引用
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(config);
        // 添加支持的MediaTypes;不添加时默认为*/*,也就是默认支持全部
        // 但是MappingJackson2HttpMessageConverter里面支持的MediaTypes为application/json
        // 参考它的做法, fastjson也只添加application/json的MediaType
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        converters.add(fastJsonHttpMessageConverter);

        // 添加 StringHttpMessageConverter，解决中文乱码问题
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(stringHttpMessageConverter);

    }
}
```
说明：
* SerializerFeature.IgnoreNonFieldGetter 忽略为空的字段在json中不返回到前台
* SerializerFeature.WriteNullListAsEmpty 当集合为空是返回到前台一个 []的数据
* SerializerFeature.WriteNullNumberAsZero 当数字类型的数据为空是返回到前台为0
* SerializerFeature.WriteDateUseDateFormat 日期格式化根据实体类中通过@JSONField(format = "yyyy-MM-dd HH:mm:ss") 格式化

效果：
```
    {
    "date": "2019-09-25 15:58:44",
    "id": 1,
    "string": "再看把你吃掉"
    }
```
### tkmybatis与springboot的整合

* 1 在pom中引入相应的jar
* 2 在实体类中引入主键生成规则  @Id  @KeySql(genId = SimpleGenId.class)
* 3 可以运行测试类中的方法可以执行自定义查询与能用的新增加功能
