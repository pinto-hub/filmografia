package springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Clase que recoge las configuraciones de la aplicacion
 * @author Jepin
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	/**
	 * Metodo que retorna la clase con las configuraciones para el uso de JPA 
	 */
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] { PersistenceJPAConfig.class };
	}

	@Override
	/**
	 * Metodo que retorna la clase con las configuraciones para el servlet
	 */
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	/**
	 * Metodo que retorna como va a ser el uso de las rutas
	 */
	protected String[] getServletMappings() {
		
		return new String[] { "/" };
	}

}
