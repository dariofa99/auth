package gov.and.ee.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import gov.and.ee.auth.jwt.JwtEntryPoint;
import gov.and.ee.auth.jwt.JwtTokenFilter;
import gov.and.ee.auth.services.UserDetailsImpl;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class MainSecurity extends WebSecurityConfigurerAdapter{
	
		@Autowired
		UserDetailsImpl userDetailsService;

	    @Autowired
	    JwtEntryPoint jwtEntryPoint;
	
	    @Bean
	    public JwtTokenFilter jwtTokenFilter(){
	        return new JwtTokenFilter();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected AuthenticationManager authenticationManager() throws Exception {
	        return super.authenticationManager();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.cors().and().csrf().disable()
	                .authorizeRequests()	                
	                .antMatchers("/auth/**").permitAll()	              
	                .antMatchers("/USER-SERVICE/user/**").hasAnyRole("ROOT")
	                .anyRequest().authenticated()
	                .and()
	                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
	                .and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
}
