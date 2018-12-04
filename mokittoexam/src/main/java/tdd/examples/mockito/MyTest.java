package tdd.examples.mockito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
    @Before
    public void init(){
        System.out.println("초기화 하는 코드.");
    }

    @After
    public void destroy(){
        System.out.println("마무리 코드");
    }

    @Test
    public void 이름이_null로_전달될때() throws Exception{
        System.out.println("test1");
    }

    @Test
    public void test2() throws Exception{
        System.out.println("test2");
    }
}
