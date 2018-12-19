package kr.co.sunnyvale.shop.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"))
                .requestMatchers(new AntPathRequestMatcher("/node_modules/**"))
                .requestMatchers(new AntPathRequestMatcher("/assets/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .permitAll().and()
                .authorizeRequests()
                    .antMatchers("/errors/**").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/members/login").permitAll()
                    .antMatchers("/members/joinform").permitAll()
                    .antMatchers("/members/join").permitAll()
                    .antMatchers("/members/**").hasRole("MEMBER")
                    .antMatchers("/api/**").hasRole("MEMBER")
                    .antMatchers("/categories/**").hasRole("MEMBER")
                    .anyRequest().fullyAuthenticated().and()
                .formLogin()
                    .loginPage("/members/login")
                    .usernameParameter("id").passwordParameter("password")
                    .loginProcessingUrl("/members/login")
                    .failureUrl("/members/login");
    }
}

