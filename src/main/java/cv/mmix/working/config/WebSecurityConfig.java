package cv.mmix.working.config;

import cv.mmix.working.repos.UserRepo;
import cv.mmix.working.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private String[] allowUnauthorized = {"/rabota",
            "/rabota/login", "/rabota/registration", "/rabota/employer/registration",
            "/rabota/vacancies", "/rabota/vacancy/*",
            "/rabota/resumes", "/rabota/resumes/*",
            "/img/**"};

    private String[] allowAdminOnly = {"/rabota/userList"};

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(allowUnauthorized).permitAll()
//                    .antMatchers(allowAdminOnly).hasRole("ADMIN")
                    .anyRequest().authenticated()
//                .and()
//                    .rememberMe()
                .and()
                    .formLogin()
//                    .loginPage("/rabota/login")
                    .loginPage("/login")
//                    .usernameParameter("email")
                .defaultSuccessUrl("/rabota")
                .failureUrl("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select email, password, active from usr where email=?")
//                .authoritiesByUsernameQuery("select email, role from usr where email=?");

          auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());


//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select username, password, active from usr where username=?")
//                .authoritiesByUsernameQuery("select username, role from usr where email=?");

    }


//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("u")
//                .password("p")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

}
