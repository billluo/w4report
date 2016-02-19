package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
    private RestSavedRequestAwareAuthenticationSuccessHandler 
    				authenticationSuccessHandler;
 
	
	@Bean(name="myAuthenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// user credential in memory
		auth.inMemoryAuthentication()
			.withUser("testuser").password("123").roles("USER")
			.and()
			.withUser("admin").password("123").roles("USER","ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// define protection url
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/v1/cycledtlreporttest/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "v1/cycledtlreporttest/**").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/v1/cycledtlreporttest/**").hasRole("USER")
				.antMatchers(HttpMethod.PATCH, "/v1/cycledtlreporttest/**").hasRole("USER")
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				//to redirect to login page
//				.successHandler(authenticationSuccessHandler)
				.failureHandler(new SimpleUrlAuthenticationFailureHandler())
			.and()
			.logout()
			.and()
			.csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(restAuthenticationEntryPoint);
	}
	
	@Bean
    public RestSavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
        return new RestSavedRequestAwareAuthenticationSuccessHandler();
    }
    @Bean
    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }
}
