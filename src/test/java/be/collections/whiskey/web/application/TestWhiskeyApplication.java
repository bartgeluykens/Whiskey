package be.collections.whiskey.web.application;

import be.collections.whiskey.web.page.HomePage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.ApplicationContext;

/**
 * Whiskey Application for testing purposes
 *
 * @Autor Bart Geluykens
 *
 */
public class TestWhiskeyApplication extends WhiskeyApplication {
  /**
   * Application context
   */
  ApplicationContext applicationContext;
  /**
   * Constructor
   *
   * @param applicationContext the application context
   */
  public TestWhiskeyApplication(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }
  /**
   * initialise component instantition listeners (for spring)
   */
  @Override
   protected void init() {
    getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext,true));
   }

  /**
   * The home page
   *
   * @return Home page class
   */
  @Override
  public Class getHomePage() {
    return HomePage.class;    //To change body of overridden methods use File | Settings | File Templates.
  }
}
