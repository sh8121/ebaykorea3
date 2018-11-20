package soundsystem;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class Dice {
    private String name;
    private int face;

    public Dice(int face){
        System.out.println("Dice 생성자");
        this.face = face;
    }

    public int getNumber(){
        System.out.println("Dice.getNumber");
        return (int)(Math.random() * face) +1;
    }
}
