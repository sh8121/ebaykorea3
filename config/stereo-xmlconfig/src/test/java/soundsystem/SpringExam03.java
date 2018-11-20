package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam03 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context
                = new ClassPathXmlApplicationContext("diceplayer.xml");
        Game game = context.getBean(Game.class);
        game.play();
    }
}
