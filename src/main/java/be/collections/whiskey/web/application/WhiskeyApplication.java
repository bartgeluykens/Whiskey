package be.collections.whiskey.web.application;

import be.collections.whiskey.web.page.DetailsPage;
import be.collections.whiskey.web.page.EditBrewery;
import be.collections.whiskey.web.page.EditWhiskey;
import be.collections.whiskey.web.page.HomePage;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
public class WhiskeyApplication extends WebApplication {

  public WhiskeyApplication() {

  }
  private void configureAlternateHtmlLocation() {
 		IResourceSettings resourceSettings = getResourceSettings();
    resourceSettings.getResourceFinders().add(new WebApplicationPath(getServletContext(), ""));
    resourceSettings.getResourceFinders().add(new WebApplicationPath(getServletContext(), "WEB-INF/views/"));
 	}


  @Override
  public Class getHomePage() {
    return HomePage.class;
  }

  @Override
  protected void init() {
    super.init();
    configureAlternateHtmlLocation();

    getComponentInstantiationListeners().add(new SpringComponentInjector(this));

    mountPage("/details.aspx", DetailsPage.class);
    mountPage("/editWhiskey.aspx", EditWhiskey.class);
    mountPage("/editBrewery.aspx", EditBrewery.class);
  }
}
