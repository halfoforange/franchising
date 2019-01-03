package com.s0rInb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.s0rInb.entity.enums.UserRole;
import com.s0rInb.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*        http.authorizeRequests().antMatchers("/api/customer/**").hasAuthority(UserRole.CUSTOMER.name());
        http.authorizeRequests().antMatchers("/api/admin/**").hasAuthority(UserRole.ADMIN.name());
        http.authorizeRequests().antMatchers("/api/user/registration").permitAll();*/
        http.authorizeRequests()
                .antMatchers("/index.html", "/", "/**.js", "/**.js.map").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic().and().csrf().disable();
/*        http.formLogin().loginPage("/").usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/api/authentication")
                .permitAll();*/
        http.authorizeRequests().anyRequest().permitAll();
    }

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
