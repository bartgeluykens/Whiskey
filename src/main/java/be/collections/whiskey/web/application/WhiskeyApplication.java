package be.collections.whiskey.web.application;

import be.collections.whiskey.web.page.*;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
/**
 * Wicket application
 *
 * @Autor Bart Geluykens
 */
public class WhiskeyApplication extends WebApplication {
  /**
   * Default constructor: do nothing
   */
  public WhiskeyApplication() {
  }
  /**
   * Normally one has to put the java classes and the html-pages in the same directory. This is a little trick
   * to keep them seperated
   */
  private void configureAlternativeHtmlLocation() {
 		IResourceSettings resourceSettings = getResourceSettings();
    resourceSettings.getResourceFinders().add(new WebApplicationPath(getServletContext(), ""));
    resourceSettings.getResourceFinders().add(new WebApplicationPath(getServletContext(), "WEB-INF/views/"));
 	}
  /**
   * Get the homepage
   *
   * @return the hompage
   */
  @Override
  public Class getHomePage() {
    return HomePage.class;
  }

  /**
   * initialisation parameters:
   *   Configure alternative html location
   *   Instatiate SpringComponentInjector
   *   Set the mountpages
   */
  @Override
  protected void init() {
    /**
     * start default behaviour
     */
    super.init();
    /**
     * Set alternative html location
     */
    configureAlternativeHtmlLocation();
    /**
     * Instantiate Spring component injector
     */
    getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    /**
     * Create readable page locations
     *
     * The .aspx extentions are an inside joke. I have a few friends who are certain of the fact that the only good way
     * to build web-applications is .Net. Don't want to confuse them by using extentions they are not familiar with :)
     */
    mountPage("/details.aspx", DetailsPage.class);
    mountPage("/editWhiskey.aspx", EditWhiskey.class);
    mountPage("/editBrewery.aspx", EditBrewery.class);
    mountPage("/searchWhiskey.aspx", SearchWhiskey.class);
  }
}
