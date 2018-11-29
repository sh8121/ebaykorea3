package examples.boot.springboard;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest {
    @Test
    public void encoding() throws Exception{
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories
                        .createDelegatingPasswordEncoder();
        String encode =
                passwordEncoder.encode("1234");
        System.out.println(encode);

        String encodeStr = "{bcrypt}$2a$10$RCC2ueLLrrBTfGWaXd/AIuvN5WVpr9sScNjWddMNfaNAOjdVwj3Ve";
        boolean matches = passwordEncoder.matches("1234", encodeStr);
        System.out.println(matches);
    }
}
