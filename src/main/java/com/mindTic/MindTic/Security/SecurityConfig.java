package com.mindTic.MindTic.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig  extends WebSecurityConfigurerAdapter{

        @Autowired
        UserDetailsService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(userDetailsService);
        }

        @Bean
         public PasswordEncoder getPassowrdEncoder(){
         return NoOpPasswordEncoder.getInstance();
         }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("api/login").permitAll()

                    .antMatchers("/login.html").permitAll()
                    .antMatchers("/movimientos.html").permitAll()
                    .antMatchers("/empleados.html").permitAll()
                    .antMatchers("/empresas.html").permitAll()
                    .antMatchers("/movimientos.html").permitAll()
                    .antMatchers("/blank.html").permitAll()
                     .antMatchers("/nuevaempresa.html").hasRole("ADMIN")
                     .antMatchers("/nuevoempleado.html").hasRole("ADMIN")
                    .antMatchers("/nuevomovimiento.html").permitAll();




                   /* .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/usuario/front/**").hasRole("ADMIN")
                    .antMatchers("/user").hasAnyRole("ADMIN","USER")
                    .antMatchers("/").permitAll()
                    .antMatchers("/login*").permitAll()
                    .antMatchers("/oauth/**").permitAll()
            ;*/


        }

    }
