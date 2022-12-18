package com.crm.ticketSaleSystems.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/home/**").permitAll()
                //.antMatchers("ordersTable/**").permitAll()
                /*.antMatchers("/favicon.ico").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/blog/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/resources/**").permitAll()*/
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/orders/**").hasAnyRole("FINANCE", "ACCOUNTANT", "ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/reports/**").hasAnyRole("ADMIN", "ACCOUNTANT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/register")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/home").permitAll()
                .and().csrf().disable().cors();
    }

    @Bean
    public UserDetailsService configureGlobal() {
        UserDetails finance = User.builder()
                .username("finance")
                .password("{bcrypt}$2a$12$U.GjVaN0O1YszxN9O898nugaTdejW9z1Rv0JrMCofcv8lPI7L8dJW")
                .roles("FINANCE")
                .build();
        UserDetails accountant = User.builder()
                .username("accountant")
                .password("{bcrypt}$2a$12$U.GjVaN0O1YszxN9O898nugaTdejW9z1Rv0JrMCofcv8lPI7L8dJW")
                .roles("ACCOUNTANT")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$U.GjVaN0O1YszxN9O898nugaTdejW9z1Rv0JrMCofcv8lPI7L8dJW")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(finance, accountant, admin);
    }
}
