package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CDPlayerConfig {

    @Bean("twiceDisc")
    public CompactDisc twiceDisc(){
        return new TwiceDisc();
    }

}
