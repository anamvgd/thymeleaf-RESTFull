package com.exercise.taller1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

//	@Autowired
//	private MyCustomUserDetailsService userDetailsService;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}
//
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(encoder());
//		return authProvider;
//	}
//
//	@Bean
//	public PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder(11);
//	}

	/*
	 * antMatchers tiene las rutas que se autentican Primero los servicios como
	 * login, porque es lo primero que se ve Al login le permita al login sin tener
	 * autenticacion luego si se pide para el resto de pages
	 * 
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/api/**").permitAll().and()
				.authorizeRequests().antMatchers("/login**").permitAll().antMatchers("/triggertype/**")
				.hasRole("administrador").antMatchers("/autotransition/**", "/userselect/**", "/trigger/**")
				.hasAnyRole("operador").anyRequest().authenticated().and().httpBasic().and().formLogin().loginPage("/login").permitAll()
				.and().logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
				.permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

		// formLogin().loginPage("/login").permitAll().and().

		// httpSecurity.authorizeRequests().antMatchers("/**").authenticated().anyRequest().permitAll().and().formLogin();

		/*
		 * httpSecurity.authorizeRequests().antMatchers("/**").authenticated().
		 * anyRequest().permitAll().and()
		 * .httpBasic().and().logout().invalidateHttpSession(true).clearAuthentication(
		 * true) .logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
		 * .permitAll().and().exceptionHandling().accessDeniedHandler(
		 * accessDeniedHandler);
		 */
	}
}