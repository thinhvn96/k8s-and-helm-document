package com.vnthinh.sam.order.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.context.ShutdownEndpoint;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
        This spring security configuration does the following

        1. Restrict access to the Shutdown endpoint to the ADMIN role.
        2. Allow access to all other actuator endpoints.
        3. Allow access to static resources.
        4. Allow access to the home page (/).
        5. All other requests need to be authenticated.
        5. Enable http basic authentication to make the configuration complete.
           You are free to use any other form of authentication.
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .requestMatchers(EndpointRequest.to(ShutdownEndpoint.class))
                        .hasRole("ADMIN")
                    .requestMatchers(EndpointRequest.toAnyEndpoint())
                        .permitAll()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                        .permitAll()
                    .antMatchers("/api/v1/sam/greeting", "/api/v1/sam/delay", "/api/v1/sam/check-profile")
                        .permitAll()
                    .antMatchers("/**")
                        .authenticated()
                .and()
                .httpBasic();
    }
}
