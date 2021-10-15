package com.board.boardchat.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/service", "/resources/**", "/create").permitAll()
//                .antMatchers("/admin").hasAnyRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("USER")
//                .antMatchers("/member").hasAnyRole("MEMBER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/loginProcess")
                    .defaultSuccessUrl("/loginSuccess")
                    .failureUrl("/login?error=true")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/accessDenied_page");
    }
}
