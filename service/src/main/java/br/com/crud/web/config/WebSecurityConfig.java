package br.com.crud.web.config;


import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected final AccessDeniedHandler accessDeniedHandler;

    public WebSecurityConfig(AccessDeniedHandler accessDeniedHandler) {
    	this.accessDeniedHandler = accessDeniedHandler;
    }
    
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated()
			.and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
            .and()
            .addFilterBefore(new SimpleCorsFilter(), ChannelProcessingFilter.class)
            .addFilterBefore(JWTLoginFilter(), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

    @Bean
    public Filter JWTLoginFilter() throws Exception {
        return new JWTLoginFilter("/login", authenticationManager());
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		User.UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users
					.username("admin")
					.password("123456")
					.roles("ADMIN")
					.build())
			.withUser(users
					.username("comum")
					.password("123456")
					.roles("COMUM")
					.build());
	}
}