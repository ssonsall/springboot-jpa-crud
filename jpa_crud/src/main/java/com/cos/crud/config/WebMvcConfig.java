package com.cos.crud.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	//.addPathPatterns("/**");
	//.excludePathPatterns("/user/*")
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionInterceptor())
				.addPathPatterns("/board/**")
				.excludePathPatterns("/board/list")
				.excludePathPatterns("/board/detail/**");
		
		/*		다른거 추가 ()
		 * 		registry.addInterceptor(new AdminInterceptor())
				.addPathPatterns("/admin/**");	
				registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/user/login");
		 * */
	}
}