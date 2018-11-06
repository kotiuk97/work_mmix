package cv.mmix.working.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login","/rabota/vacancy", "/rabota/registration", "/rabota/login", "/rabota/employer/registration").permitAll()
                    .anyRequest().authenticated()
//                .and()
//                    .rememberMe()
                .and()
                    .formLogin()
//                    .loginPage("/rabota/login")
                    .loginPage("/login")
//                    .usernameParameter("email")
                .defaultSuccessUrl("/rabota")
                .failureUrl("/rabota/registration")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select email, password, active from usr where email=?")
                .authoritiesByUsernameQuery("select email, role from usr where email=?");
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
