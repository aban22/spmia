package com.thoughtmechanix.spmiaauthenticationserver.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//Can be JDBC	=> clients.jdbc
		clients.inMemory()
			.withClient("eagleeye")
			.secret(passwordEncoder.encode("thisissecret"))
			.authorizedGrantTypes("refresh_token", "password", "client_credentials")
			.scopes("webclient", "mobileclient");
	}
	
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints
//			.authenticationManager(authenticationManager)
//			.userDetailsService(userDetailsService);
//	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter()));
		endpoints
			.authenticationManager(authenticationManager)
			.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter())
			.tokenEnhancer(tokenEnhancerChain);
		super.configure(endpoints);
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC);
		return jwtAccessTokenConverter;
	}
}
