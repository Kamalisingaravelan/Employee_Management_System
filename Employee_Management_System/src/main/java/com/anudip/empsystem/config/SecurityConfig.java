package com.anudip.empsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	 @Bean
	    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	        UserDetails admin = User.builder()
	                .username("admin")
	                .password(passwordEncoder.encode("adminpass"))
	                .roles("ADMIN")
	                .build();

	        UserDetails user = User.builder()
	                .username("user")
	                .password(passwordEncoder.encode("userpass"))
	                .roles("USER")
	                .build();

	        return new InMemoryUserDetailsManager(admin, user);
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/api/departments/**").hasRole("ADMIN")
	                .requestMatchers("/api/employees/**").hasAnyRole("ADMIN","USER")
	                .anyRequest().authenticated()
	            )
	            .httpBasic();
	        return http.build();
	    }
}
