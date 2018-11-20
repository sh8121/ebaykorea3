package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CDPlayerConfig4 {

  @Bean
  @Scope("prototype")
  public CompactDisc compactDisc() {
    System.out.println("compactDisc() 호출");
    return new SgtPeppers();
  }

}
