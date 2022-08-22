package pers.as.pagedb.config.crossdomain;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: CrossConfig
 * @description: 跨域配置文件
 * @author: AS
 * @create: 2022-04-13 16:59
 */
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void  addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //使用凭证
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);

    }
}
