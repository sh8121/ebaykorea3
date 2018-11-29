package examples.boot.springboard.config;

import examples.boot.springboard.security.LoginuserArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

//웹 설정파일은 WebMvcConfigurer 를 구현한다.
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginuserArgumentResolver());
    }
}

//public class WebConfig extends WebMvcConfigurerAdapter {
//
//}