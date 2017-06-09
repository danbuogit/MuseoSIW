package com.dbaab.museo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dbaab.museo.model.Role;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        /* @formatter:off */
        
        String authoritiesByUsernameQuery =
                "SELECT username,r.role " +
                "FROM (SELECT * FROM users JOIN users_roles ON id=users_id) AS ur JOIN user_role AS r " +
                  "ON ur.roles_id=r.id " +
                "WHERE username=?";
        
        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("SELECT username,password,1 FROM users WHERE username=?")
                .authoritiesByUsernameQuery(authoritiesByUsernameQuery);
        
        /* @formatter:on */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        /* @formatter:off */
        
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/home/**").permitAll()
                .antMatchers("/admins/**").hasAuthority(Role.ADMIN.toString())
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .successForwardUrl("/hello")
                .and()
            .logout()
                .permitAll();
        
        /* @formatter:on */
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/resources/**", "/css/**", "/js/**", "/fonts/**");
    }
}