package be.collections.whiskey.web.page;

import be.collections.whiskey.service.BreweryService;
import be.collections.whiskey.service.WhiskeyService;
import be.collections.whiskey.service.WhiskeyTypeService;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.context.support.StaticWebApplicationContext;


/**
 * Base wicket test
 *
 * @Autor Bart Geluykens
 *
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class BaseWicketTest extends Assert {
  /**
   * Application context
   */
  protected StaticWebApplicationContext applicationContext = new StaticWebApplicationContext();
  /**
   * Wicket tester
   */
  protected WicketTester wicketTester;
  /**
   * BreweryService
   */
  @Mock
  protected BreweryService breweryService;
  /**
   * WhiskeyService
   */
  @Mock
  protected WhiskeyService whiskeyService;
  /**
   * BreweryService
   */
  @Mock
  protected WhiskeyTypeService whiskeyTypeService;
  /**
   * Default constructor
   */
  @Before
   public void setUp() {
     wicketTester = new WicketTester();

    applicationContext.getBeanFactory().registerSingleton("breweryService", breweryService);
    applicationContext.getBeanFactory().registerSingleton("whiskeyService", whiskeyService);
    applicationContext.getBeanFactory().registerSingleton("whiskeyTypeService", whiskeyTypeService);

    wicketTester.getApplication().getComponentInstantiationListeners().add(new SpringComponentInjector(wicketTester.getApplication(), applicationContext));

   }

   public void checkSideLinks () {
     wicketTester.assertComponent("add-brewery", Link.class);
     wicketTester.assertComponent("add-whiskey", Link.class);
     wicketTester.assertComponent("search-whiskey", Link.class);
     wicketTester.assertComponent("search-brewery", Link.class);
     wicketTester.assertComponent("home", Link.class);
   }

}
