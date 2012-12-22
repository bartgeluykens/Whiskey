package be.collections.whiskey.web.application;

import be.collections.whiskey.web.page.DetailsPage;
import be.collections.whiskey.web.page.EditBrewery;
import be.collections.whiskey.web.page.EditWhiskey;
import be.collections.whiskey.web.page.HomePage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
public class WhiskeyApplication extends WebApplication {

  public WhiskeyApplication() {

  }

  @Override
  public Class getHomePage() {
    return HomePage.class;
  }

  @Override
  protected void init() {
    super.init();

    getComponentInstantiationListeners().add(new SpringComponentInjector(this));

    mountPage("/details.aspx", DetailsPage.class);
    mountPage("/editWhiskey.aspx", EditWhiskey.class);
    mountPage("/editBrewery.aspx", EditBrewery.class);
  }
}
