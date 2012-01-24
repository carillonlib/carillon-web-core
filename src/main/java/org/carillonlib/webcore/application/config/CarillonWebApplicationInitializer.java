package org.carillonlib.webcore.application.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CarillonWebApplicationInitializer implements WebApplicationInitializer {

	private Logger log = LoggerFactory.getLogger(getClass());
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.info(getClass().getSimpleName() + " beginning initialization for context: " + servletContext.getContextPath());
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		log.debug("Setting active spring profile: " + getActiveProfile());
		mvcContext.getEnvironment().setActiveProfiles(getActiveProfile());
		mvcContext.register(CarillonMvcConfig.class);
		mvcContext.scan("org.carillonlib");
		mvcContext.refresh();

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(mvcContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/app/*");
	}

	protected String getActiveProfile() {
		String activeProfile = System.getProperty("spring.activeProfile");
		if (activeProfile != null) {
			return activeProfile;
		}

		// default to development profile
		return CarillonSpringProfiles.DEVELOPMENT;
	}

}
