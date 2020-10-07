package com.blog.aulia.security

import com.blog.aulia.security.handler.RefererRedirectionAuthenticationSuccessHandler
import com.blog.aulia.security.service.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@EnableWebSecurity
open class WebSecurityConfiguration(private val customUserDetailsService: CustomUserDetailsService,
                                    private val passwordEncoder: PasswordEncoder,
                                    private val refererRedirectionAuthenticationSuccessHandler: RefererRedirectionAuthenticationSuccessHandler
): WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers("/").permitAll()
            // spdeepak
            .antMatchers("/admin/*").authenticated()
            // .antMatchers("/admin/*").hasRole("ADMIN")
            .and()
            .formLogin()
            .defaultSuccessUrl("/admin/dashboard")
            .and()
            .exceptionHandling().accessDeniedPage("/access-denied")
            .and()
            .logout().logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
            .and().csrf()
            .and().exceptionHandling().accessDeniedPage("/access-denied")

				// .and()
        // http.csrf().disable()
        // http.authorizeRequests()
                // .antMatchers("/admin/*").authenticated()
				// .anyRequest().permitAll()
				// .and()
				// .formLogin().permitAll()        
                // .antMatchers("/admin/*").authenticated()
				// .anyRequest().permitAll()
				// .and()
                // .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").failureUrl("/login?error").permitAll()
				// .and()
                // .exceptionHandling().accessDeniedPage("/error")
                // .successHandler("/admin")
                // // .defaultSuccessUrl("/admin")
				// .and()
                // .logout().logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                // .and().csrf()
                // .and().exceptionHandling().accessDeniedPage("/access-denied")

            // .antMatchers("/admin/*").authenticated()
            // .anyRequest().permitAll()
            // .and()
            // .httpBasic()
            // .and()
            // .exceptionHandling().accessDeniedPage("/error")
            // .and()
            // .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").failureUrl("/login?error")
            // .successHandler(refererRedirectionAuthenticationSuccessHandler)
            // .defaultSuccessUrl("/admin")
            // .and()
            // .logout().logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
            // .and().csrf()
            // .and().exceptionHandling().accessDeniedPage("/access-denied")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder)
    }
}