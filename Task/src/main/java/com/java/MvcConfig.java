package com.java;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	}
        private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
		"classpath:/resources/", "classpath:/Templates/",
		"classpath:/static/", "classpath:/public/" };

}
