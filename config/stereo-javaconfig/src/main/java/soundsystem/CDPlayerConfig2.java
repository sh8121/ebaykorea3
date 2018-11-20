package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig2 {

  // Bean을 생성하는 메소드는 예를 들어 myDisc()는 2번째 호출될 경우에는 이미 생성된 MyDisc를 리턴한다.
  @Bean
  public CDPlayer cdPlayer() {
    System.out.println("cdPlayer() 호출");
    return new CDPlayer(myDisc());
  }

  @Bean
  public CompactDisc compactDisc() {
    System.out.println("compactDisc() 호출");
    return new SgtPeppers();
  }

  @Bean
  public CompactDisc myDisc() {
    System.out.println("----------------------------------------");
    System.out.println(getClass().getName());
    System.out.println("myDisc() 호출");
    System.out.println("----------------------------------------");
    return new MyDisc();
  }
}
