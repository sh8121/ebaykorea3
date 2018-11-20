package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context
                = new ClassPathXmlApplicationContext("exam01.xml");

        // Spring은 기본적으로 객체를 싱글턴으로 관리한다.
        MyBean bean1 = (MyBean)context.getBean("bean1");
        bean1.setName("홍길동");

        MyBean bean2 = (MyBean)context.getBean("bean1");
        System.out.println(bean2.getName());

        // MyBean클래스 타입의 빈을 요청한다. 1개일 경우에만 오류가 발생하지 않는다.
        MyBean bean5 = context.getBean(MyBean.class);
        System.out.println(bean5.getName());

//        MyBean bean3 = (MyBean)context.getBean("bean2");
//        System.out.println(bean3.getName());

//      bean3 라는 id의 빈은 설정되어 있지 않기 때문에 Exception이 발생한다.
//        MyBean bean4 = (MyBean)context.getBean("bean3");
//        System.out.println(bean4.getName());
    }
}
