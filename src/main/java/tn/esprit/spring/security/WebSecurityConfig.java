package tn.esprit.spring.security;
import javax.sql.DataSource;

/*
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import tn.esprit.spring.service.ParentService;
@Configuration
@EnableWebSecurity
 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	ParentService parentservice ;
	
	
	protected void configure(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception{
	auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select email as principal , password as credentials,true from users where email= ?")
		.authoritiesByUsernameQuery("select email as principal,role from users where email =? ")
		.rolePrefix("ROle");
	}
	public void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()  
			.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
					
						
					
	}

}
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception{
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select email as principal , password as credentials ,true from users where email= ?");
		}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/api/kindergarten/add","/authenticate", "/api/parent/add","/css/**").permitAll()
				// all other requests need to be authenticated
				.anyRequest()
				.authenticated()  
	
						.and()
				
							.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
					
						.and()
							.sessionManagement()
							.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}