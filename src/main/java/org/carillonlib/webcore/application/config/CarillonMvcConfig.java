/*
 * This file is part of the Carillon Lib Project.
 * More information can be found at http://github.com/carillonlib
 * 
 * This source code has been released to the public domain.
 * For more details, see the exact release terms in the
 * UNLICENSE file, or at http://unlicense.org
 */

package org.carillonlib.webcore.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class CarillonMvcConfig {
	@Bean
	public InternalResourceViewResolver configureInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
