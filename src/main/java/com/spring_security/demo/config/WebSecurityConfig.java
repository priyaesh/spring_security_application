package com.spring_security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("register").permitAll()
                                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();

    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails priyaEsh
                = User.withUsername("priyaEsh")
                .password("{noop}admin@123")
                .roles("USER")
                .build();

        UserDetails Esh
                = User.withUsername("Esh")
                .password("admin@123")
                .roles("USER")
                .build();
        return  new InMemoryUserDetailsManager(priyaEsh,Esh);

    }
}
