package be.collections.whiskey.web.application;

import be.collections.whiskey.web.page.DetailsPage;
import be.collections.whiskey.web.page.EditBrewery;
import be.collections.whiskey.web.page.EditWhiskey;
import be.collections.whiskey.web.page.HomePage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/23/12
 */
public class TestWhiskeyApplication extends WhiskeyApplication {

  ApplicationContext applicationContext;

  public TestWhiskeyApplication(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }


  @Override
   protected void init() {
    getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext,true));

   }

  @Override
  public Class getHomePage() {
    return HomePage.class;    //To change body of overridden methods use File | Settings | File Templates.
  }
}
