package com.barclays.authorization.Authservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
                .formLogin().disable()
                .csrf().disable()
//                .addFilterBefore(UsernamePasswordAuthenticationFilter.class)
                .headers().frameOptions().disable()
            .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/uaa/register").permitAll()
                .antMatchers("/uaa/activate").permitAll()
                .antMatchers("/uaa/authenticate").permitAll()
                .antMatchers("/uaa/account/reset-password/init").permitAll()
                .antMatchers("/uaa/account/reset-password/finish").permitAll()
                .antMatchers("/uaa/profile-info").permitAll();
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("reader")
//                .password("reader")
//                .and()
//                .withUser("writer")
//                .password("writer")
//                .authorities("ROLE_READ","ROLE_WRITE");
//    }
}
