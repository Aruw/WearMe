package br.com.aruw.security;

import br.com.aruw.jwtutils.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@Profile("!https")
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // http builder configurations for authorize requests and form login (see below)

        /*
        http.csrf().disable()
                .addFilterAfter(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated();
        */

        http.csrf().disable().authorizeRequests().anyRequest().permitAll();

        /*
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/anonymous*").anonymous()
        .antMatchers("/login*").permitAll()
        .anyRequest().authenticated();
         */
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}