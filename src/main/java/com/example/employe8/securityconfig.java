package com.example.employe8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityconfig {
    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().permitAll());
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        UserDetails u1 = User
                .withDefaultPasswordEncoder()
                .username("raj")
                .password("raj@123")
                .roles("admin")
                .build();
        UserDetails u2 = User
                .withDefaultPasswordEncoder()
                .username("taju")
                .password("taju@123")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(u1, u2);
    }
    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider obj=new DaoAuthenticationProvider(userDetailsService);
        obj.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return  obj;
    }
}
