package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = org.springframework.security.core.userdetails.User.withUsername("admin")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .build();
        UserDetails user = org.springframework.security.core.userdetails.User.withUsername("user")
                .password(encoder.encode("123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests() // Sử dụng authorizeRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/create/**").authenticated()
                .requestMatchers("/blog/create1").authenticated()
                .and()
                .formLogin(formLogin -> formLogin
//                        .loginPage("/login") nhập
                        .permitAll())
                .build();
    }

}
