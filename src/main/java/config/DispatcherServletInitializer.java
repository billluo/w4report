package config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
//@EnableAutoConfiguration
@ComponentScan({"domain","config"})
public class DispatcherServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {
			
			SpringSecurityInitializer.class,
			RestAuthenticationEntryPoint.class,
			SecurityConfiguration.class,
			DataAccessConfig.class,
			WebMvcConfig.class
			
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter()};
//						new DelegatingFilterProxy()};
	}
	
//	@Override
//	public void onStartup(ServletContext servletContext)
//			throws ServletException {
//		// TODO Auto-generated method stub
//		
//		servletContext.addFilter("springSecurityFilterChain", 
//				new DelegatingFilterProxy("springSecurityFilterChain"))
//				.addMappingForUrlPatterns(null, false, "/v1/cycledtlreporttest/**");
//		
//		servletContext.addFilter("h1",new HiddenHttpMethodFilter());
//		
//		super.onStartup(servletContext);
//	}
}
