package com.cos.crud.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 세션체크, 권한체크, 로그남기기(log4j), 파일업로드(ex. 파일 리사이즈 같은거)

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
		
			//다른거 추가 ()
		 		registry.addInterceptor(new AdminInterceptor())
				.addPathPatterns("/admin/**");	
		/*		registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/user/login");
		 * */
	}
}