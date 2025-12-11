package io.nightops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userDetail = User
                .builder()
                .username("nightops")
                .password("{noop}drop123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetail);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> 
                configurer
                        .requestMatchers("/config/**").hasRole("ADMIN")
                        .requestMatchers("/files/upload").hasRole("ADMIN")
                        .requestMatchers("/files/passive/**").hasRole("ADMIN")
                        .requestMatchers("/files/delete/**").hasRole("ADMIN")
                        .requestMatchers("/home").hasRole("ADMIN")
                        .requestMatchers("/style.css","/files/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"))
                .logout(logout -> logout.permitAll());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
    
}
