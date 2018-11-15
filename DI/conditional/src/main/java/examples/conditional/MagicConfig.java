package examples.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicConfig {

  /*
  Spring 4.1에서는 @Conditional애노테이션이 등장. 조건이 참일 경우 빈을 생성한다. 그렇지 않으면 무시한다.
   */
  @Bean
  @Conditional(MagicExistsCondition.class)
  public MagicBean magicBean() {
    return new MagicBean();
  }
  
}