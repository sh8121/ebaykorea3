package examples.boot.springboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//웹 설정파일은 WebMvcConfigurer 를 구현한다.
@Configuration
public class WebConfig implements WebMvcConfigurer {
}

//public class WebConfig extends WebMvcConfigurerAdapter {
//
//}