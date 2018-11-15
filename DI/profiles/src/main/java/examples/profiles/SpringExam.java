package examples.profiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam {
    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles( "dev" );
        context.register(DataSourceConfig.class);
        context.refresh();
    }
}
