package com.conceptandcoding.learningspringboot.OAuth;

import com.conceptandcoding.learningspringboot.OAuth.Util.OAuthTokenValidatorUtil;
import com.conceptandcoding.learningspringboot.OAuth.filter.CustomOAuth2SuccessHandler;
import com.conceptandcoding.learningspringboot.OAuth.filter.OAuthValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfigForOAuth {

   // @Autowired
    private OAuthTokenValidatorUtil tokenValidatorUtil;

   // @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   CustomOAuth2SuccessHandler successHandler) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .oauth2Login(oauth -> oauth
                        .successHandler(successHandler))
                .addFilterBefore(new OAuthValidationFilter(tokenValidatorUtil), UsernamePasswordAuthenticationFilter.class); // Custom JWT filter

        return http.build();
    }
}