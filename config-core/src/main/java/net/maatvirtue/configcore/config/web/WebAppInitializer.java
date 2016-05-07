package net.maatvirtue.configcore.config.web;

import net.maatvirtue.configcore.constants.Constants;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;

public class WebAppInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup(ServletContext container)
	{
		setupSpringApplicationContext(container);
		addCxfServlet(container);
	}

	private void addCxfServlet(ServletContext container)
	{
		String servletUrlMapping = "/" + Constants.WEB_SERVICE_MAJOR_VERSION + "/*";

		container.addServlet("CXF Servlet", new CXFServlet()).addMapping(servletUrlMapping);
	}

	private void setupSpringApplicationContext(ServletContext container)
	{
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.scan(Constants.SPRING_CONFIG_PACKAGE);

		container.addListener(new ContextLoaderListener(applicationContext));
	}
}
