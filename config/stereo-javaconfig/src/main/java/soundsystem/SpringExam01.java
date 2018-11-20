package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        CompactDisc compactDisc1 = context.getBean("compactDisc", CompactDisc.class);
        CompactDisc compactDisc2 = context.getBean("compactDisc", CompactDisc.class);
        if(compactDisc1 == compactDisc2){
            System.out.println("compactDisc1 == dompactDisc2");
        }

        CompactDisc myDisc = context.getBean("myDisc", CompactDisc.class);
        myDisc.play();

        CDPlayer cdPlayer = context.getBean("cdPlayer", CDPlayer.class);
        cdPlayer.play();
    }
}
