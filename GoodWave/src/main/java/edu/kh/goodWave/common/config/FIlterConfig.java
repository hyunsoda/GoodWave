package edu.kh.goodWave.common.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.kh.goodWave.common.filter.LoginFilter;

@Configuration
public class FIlterConfig {
	
	@Bean
	public FilterRegistrationBean<LoginFilter> loginFilter(){
		
		
		FilterRegistrationBean<LoginFilter> filter = new FilterRegistrationBean<>();
		
		filter.setFilter(new LoginFilter());
		
		String[] filterURL = {"/myPage/*", "/mypage/*"};
		
		
		filter.setUrlPatterns(Arrays.asList(filterURL));
		
		filter.setName("loginFilter");
		
		filter.setOrder(1);
		
		
		
		return filter;
				
	}
}
