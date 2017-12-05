package com.barclays.authorization.Authservice;

import com.barclays.authorization.Authservice.entities.Role;
import com.barclays.authorization.Authservice.entities.User;
import com.barclays.authorization.Authservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
		if (userRepository.count() == 0) {
			userRepository.save(new User("user","user", Arrays.asList(new Role("CLIENT"),new Role("ACTUATOR"))));
			userRepository.save(new User("newUser","newUser", Arrays.asList(new Role("CLIENT"),new Role("ACTUATOR"))));
		}
		builder.userDetailsService(s -> new CustomUserDetails(userRepository.findUserByUsername(s)));
	}
}
