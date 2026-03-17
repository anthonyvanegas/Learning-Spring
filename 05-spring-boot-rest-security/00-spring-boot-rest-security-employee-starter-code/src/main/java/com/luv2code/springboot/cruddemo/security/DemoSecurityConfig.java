package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

        // Add support for JDBC
        @Bean
        public UserDetailsManager userDetailsManager(DataSource dataSource) {
                JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

                userDetailsManager.setUsersByUsernameQuery(
                        "select user_id, pw, active from members where user_id=?"
                );

                userDetailsManager.setAuthoritiesByUsernameQuery(
                        "select user_id, role from roles where user_id=?"
                );

                return userDetailsManager;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

                // Use HTTP Basic authentication
                http.httpBasic(Customizer.withDefaults());

                // Disable Cross Site Request Forgery (CSRF)
                // In general, not required for stateless REST APIs that use POST, PUT, DELETE
                // and/or PATCH
                http.csrf(csrf -> csrf.disable());

                return http.build();
        }
        }