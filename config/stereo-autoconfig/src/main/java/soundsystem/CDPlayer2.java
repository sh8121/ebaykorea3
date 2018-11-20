package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CDPlayer2 implements MediaPlayer {
  // CompactDisc를 자동으로 주입받는다.
//  @Autowired
//  @Qualifier("myDisc") // CompactDisc를 구현하는 클래스가 2개 이상일 경우
  @Resource(name = "myDisc")
  private CompactDisc cd;

  public CDPlayer2(){
    System.out.println("CDPlayer2()");
  }

  public void play() {
    cd.play();
  }
}
