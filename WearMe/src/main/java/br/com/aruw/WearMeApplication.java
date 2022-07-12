package br.com.aruw;

import br.com.aruw.jwtutils.JwtAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class WearMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WearMeApplication.class, args);
	}

	@Configuration
	@EnableWebSecurity
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity httpSecurity) throws Exception{
			httpSecurity.csrf().disable()
					.addFilterAfter(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/token").permitAll()
					.anyRequest().authenticated();
		}
	}

}