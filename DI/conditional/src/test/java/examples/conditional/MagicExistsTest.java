package examples.conditional;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MagicConfig.class)
public class MagicExistsTest {

  @Autowired
  private ApplicationContext context;
  
  /*
   * This test will fail until you set a "magic" property.
   * You can set this property as an environment variable, a JVM system property, by adding a @BeforeClass
   * method and calling System.setProperty() or one of several other options.
   *
   * JVM에서 -D환경변수명=값 으로 설정할 수 있다.
   */
  @Test
  public void shouldNotBeNull() {
    assertTrue(context.containsBean("magicBean"));
  }
  
}
