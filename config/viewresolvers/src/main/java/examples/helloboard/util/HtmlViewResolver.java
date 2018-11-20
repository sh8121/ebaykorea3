package examples.helloboard.util;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;


public class HtmlViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        System.out.println("s : " + s);
        System.out.println("locale : " + locale.getCountry());
        return new HtmlView();
    }
}
