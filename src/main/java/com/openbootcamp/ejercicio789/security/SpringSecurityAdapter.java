package com.openbootcamp.ejercicio789.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityAdapter extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
					.antMatchers("/laptop/all").permitAll()
					.antMatchers("/laptop/*").hasRole("ADMIN")
					.anyRequest().authenticated().and().formLogin().and().httpBasic();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("pass1")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("pass2")).roles("USER", "ADMIN");
    }
}
