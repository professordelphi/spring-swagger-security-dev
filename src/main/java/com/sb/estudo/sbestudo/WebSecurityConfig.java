package com.sb.estudo.sbestudo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().and().httpBasic() 
				.and().csrf().disable();
	}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception
{
auth.inMemoryAuthentication().withUser("dev").password("123").roles("ADMIN");
}	


		@Override
	public void configure(WebSecurity web) throws Exception
	{
	web.ignoring().antMatchers("/**"); //web.ignoring().antMatchers("/materialize/**","/style/**")
	}


	}

/*
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.sb.estudo.sbestudo")  
@EnableWebSecurity  
public class WebSecurityConfig  {


	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().and().httpBasic() //
				.and().csrf().disable();
	}

	@Configuration
	public class WebConfiguration implements WebMvcConfigurer {

		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*")
					.allowCredentials(true);
		}
	}
*/
/*	
	 
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity
	                .authorizeRequests().antMatchers("/").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .formLogin().loginPage("/login").permitAll()
	                .and()
	                .logout().logoutUrl("/logout").permitAll();

	        httpSecurity.csrf().disable();
	        httpSecurity.headers().frameOptions().disable();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	                .inMemoryAuthentication()
	                .withUser("admin").password("{noop}admin").roles("ADMIN")
	                .and().withUser("user").password("{noop}user").roles("USER");
	    }
	
	
	@Bean  
    public UserDetailsService userDetailsService() {  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
        manager.createUser(User.withDefaultPasswordEncoder().username("javatpoint").  
        password("java123").roles("USER").build());  
        return manager;  
    }  
      
    protected void configure(HttpSecurity http) throws Exception {  
                  
        http  
        .antMatcher("/")                                 
        .authorizeRequests()  
            .anyRequest().hasRole("ADMIN")  
            .and()  
        .httpBasic();  
    }  
	
*/
	

