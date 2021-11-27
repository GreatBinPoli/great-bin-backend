package co.edu.poli.greatbin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuracion de seguridad por Usuario
 * 
 * @author Cristian Sanchez
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable() // Cross-Site Request Forgery (falsificación de petición en sitios cruzados)
				.authorizeRequests().antMatchers("/api/v1/users/all").hasAnyRole("ADMIN").antMatchers("/api/v1/users")
				.permitAll().antMatchers("/api/v1/users/uno").hasAnyRole("ADMIN", "USER")
				.antMatchers("/api/v1/users/email").hasAnyRole("ADMIN", "USER").antMatchers("/api/v1/users/update")
				.hasAnyRole("ADMIN", "USER").antMatchers("/api/v1/users/delete").hasAnyRole("ADMIN")
				.antMatchers("/api/v1/users/bag").hasAnyRole("ADMIN", "USER")
				.antMatchers("/api/v1/users/bags").hasAnyRole("ADMIN", "USER")
				.anyRequest().authenticated().and()
				.formLogin()// authentication method
				.and().httpBasic() // authentication method (allow test postman POST,DELETE,PUT)
				.and().logout();// http://localhost:8080/login?logout
	}
	/*
	 * @Bean public PasswordEncoder noPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
