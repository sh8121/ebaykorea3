package soundsystem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// java config 클래스에는 @Configuration 이 클래스위에 있어야 한다.
@Configuration
public class CDPlayerConfig {

  // CompactDisc가 2개 일 경우 파라미터 이름은 메소드 이름(id)과 같아야 한다.
  // <bean id="cdPlayer" class="soundsystem.CDPlayer">
  //    <construct-arg ref="compactDisc"/>
  // </bean>
  @Bean
  public CDPlayer cdPlayer(CompactDisc compactDisc) {
    System.out.println("cdPlayer() 호출");
    return new CDPlayer(compactDisc);
  }

  // 메소드 이름이 id가 된다. 메소드 이름이 중복되면 id가 중복된다는 의미기때문에 안된다.
  // <bean id="compactDisc" class="soundsystem.SgtPeppers"/>
  // Bean 생성을 하는 메소드는 @Bean이 붙어야한다.
  @Bean
  public CompactDisc compactDisc() {
    System.out.println("compactDisc() 호출");
    return new SgtPeppers();
  }

  @Bean
  public CompactDisc myDisc() {
    System.out.println("myDisc() 호출");
    return new MyDisc();
  }
}
