package com.example.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/*@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configureGlobal");
		auth.inMemoryAuthentication().withUser("user").password("user").roles("ROLE");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("configure HttpSecurity ");
		http.authorizeRequests().antMatchers("/services").permitAll().antMatchers("/products").authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer config) {
		config.tokenServices(tokenServices());
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		return new JwtAccessTokenConverter();
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}
*/
	private static class OAuthRequestedMatcher implements RequestMatcher {
		public boolean matches(HttpServletRequest request) {
			String auth = request.getHeader("Authorization");
			// Determine if the client request contained an OAuth Authorization
			boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
			boolean haveAccessToken = request.getParameter("access_token") != null;
			return haveOauth2Token || haveAccessToken;
		}
	}
}
