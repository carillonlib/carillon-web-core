/*
 * This file is part of the Carillon Lib Project.
 * More information can be found at http://github.com/carillonlib
 * 
 * This source code has been released to the public domain.
 * For more details, see the exact release terms in the
 * UNLICENSE file, or at http://unlicense.org
 */

package org.carillonlib.webcore.application.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CarillonWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(CarillonMvcConfig.class);
		mvcContext.scan("org.carillonlib");
		mvcContext.refresh();

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(mvcContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/app/*");
	}

}
