package org.mygroup.currencyCalculator.springSecurity.config;

import org.mygroup.currencyCalculator.springSecurity.jwt.jwtConfigurer;
import org.mygroup.currencyCalculator.springSecurity.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/***
 * Spring Securiy configuration file with controller endpoints and rules
 *
 * @author Samvel Ghazaryan
 * @version 1.0
 */

@EnableWebSecurity
@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String ADMIN_ENDPOINT = "/api/v1/admin/**";
    private static final String LOGIN_ENDPOINT = "/api/v1/auth/login";
    private static final String CURRENCY_ENDPOINT = "/api/v1/exchangecalc/**";
    private static final String USER_ENDPOINT = "/api/v1/users/**";

    @Autowired
    public securityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(USER_ENDPOINT).hasRole("USER")
                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                .antMatchers(CURRENCY_ENDPOINT).hasRole("ADMIN")
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new jwtConfigurer(this.jwtTokenProvider));
    }
}
