package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        CDPlayer player1 = context.getBean(CDPlayer.class);
        player1.play();
        CDPlayer2 player2 = context.getBean(CDPlayer2.class);
        player2.play();
//        if(player1 == player2){
//            System.out.println("player1 == player2");
//        }

    }
}
