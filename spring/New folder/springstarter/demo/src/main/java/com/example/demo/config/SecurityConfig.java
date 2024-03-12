package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("{spring.security.username}")
    private String user;
    @Value("{spring.security.password}")
    private String password;

    // @Override
    // public void configure(HttpSecurity http) throws Exception {
    //     http.authorizeRequests()
    //             .antMatchers("/api/**").permitAll() // Permit access to public endpoints without authentication
    //             .antMatchers("/api/private/**").authenticated() // Require authentication for private endpoints
    //             .anyRequest().authenticated() // Require authentication for all other endpoints
    //             .and()
    //             .httpBasic(); // Enable form-based authentication
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.inMemoryAuthentication()
    //             .withUser(user)
    //             .password(passwordEncoder().encode(password))
    //             .roles("USER");
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/api/**").permitAll();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // In-memory user for testing
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername(user).password(passwordEncoder().encode(password)).roles("USER").build());
        return manager;
    }
}
