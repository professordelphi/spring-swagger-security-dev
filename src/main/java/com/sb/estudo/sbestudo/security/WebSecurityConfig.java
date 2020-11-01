package com.sb.estudo.sbestudo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };


    @Override
    protected void configure(HttpSecurity http) throws Exception {
     /* 
      * http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN");
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
      *   
      *  
      */
                // ... here goes your custom security configuration
  /*      http.
         authorizeRequests().
                antMatchers(AUTH_WHITELIST).permitAll().  // whitelist Swagger UI resources
                // ... here goes your custom security configuration
                antMatchers("/**").authenticated();  // require authentication for any endpoint that's not whitelisted
    */   
        
        http
        .authorizeRequests().antMatchers("/").permitAll()
        .antMatchers(AUTH_WHITELIST).permitAll()
        .anyRequest().authenticated()
   // .and()
    //   .formLogin().loginPage("/cad").permitAll();
  .and().formLogin().permitAll();
    //    .and()
     //   .logout().logoutUrl("/logout").permitAll();

        System.out.println(http.toString());
      //  System.out.print(http.build());
    	
//http.csrf().disable();
//http.headers().frameOptions().disable();
    }

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception
{
//auth.inMemoryAuthentication().withUser("dev").password("123").roles("USER","ADMIN");
//log.info(auth.build().toString());
//log.info(auth.toString());

//auth
// enable in memory based authentication with a user named
// "user" and "admin"
//.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
  //              .withUser("admin").password("password").roles("USER", "ADMIN");

auth.inMemoryAuthentication()
.withUser("user").password("{noop}password").roles("USER")
.and()
.withUser("admin").password("{noop}password").roles("ADMIN");

}	


		@Override
	public void configure(WebSecurity web) throws Exception
	{
//	web.ignoring().antMatchers("/**"); //web.ignoring().antMatchers("/materialize/**","/style/**")
	web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.*", "/webjars/**");
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
	

