package examples.helloboard.config;

import examples.helloboard.util.HtmlViewResolver;
import examples.helloboard.util.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "examples.helloboard.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하게 합니다.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    
//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }

//    @Bean
//    public HtmlViewResolver htmlViewResolver(){
//	    return new HtmlViewResolver();
//    }
//
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager contentNegotiationManager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(contentNegotiationManager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        resolvers.add(new HtmlViewResolver());
        resolvers.add(new JsonViewResolver()); // http://localhost:8080/boards.json

        resolver.setViewResolvers(resolvers);

        return resolver;
    }
//
//    /*
//    curl -i -X GET \
//   -H "Accept:application/json" \
// 'http://localhost:8080/boards'
//     */
    @Bean
    public ContentNegotiationManager contentNegotiationManager(){
        ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
        contentNegotiationManager.setFavorPathExtension(true);
        contentNegotiationManager.setIgnoreAcceptHeader(true);
        contentNegotiationManager.setUseJaf(false);
        contentNegotiationManager.setDefaultContentType(MediaType.TEXT_HTML);
        // 확장자에 따라서 사용자가 요청한 타입을 결정한다.
        contentNegotiationManager.addMediaType("html", MediaType.TEXT_HTML);
        contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
        return contentNegotiationManager.getObject();
    }
}
