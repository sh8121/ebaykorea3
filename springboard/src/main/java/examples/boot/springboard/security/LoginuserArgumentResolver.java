package examples.boot.springboard.security;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginuserArgumentResolver
    implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        AuthUser authUser =
                methodParameter
                   .getParameterAnnotation(AuthUser.class);
        if(authUser != null
                && methodParameter.getParameterType()
                    ==  LoginUser.class){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Authentication authentication =
                SecurityContextHolder.getContext()
                        .getAuthentication();
        if(authentication == null) return null;
        LoginUser loginUser =
                (LoginUser)authentication.getPrincipal();
        return loginUser;
    }
}
