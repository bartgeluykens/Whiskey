package be.collections.whiskey.web.page;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.web.application.TestWhiskeyApplication;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WhiskeyWicketTester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Base wicket test
 *
 * @Autor Bart Geluykens
 *
 */
public abstract class BaseWicketTest extends BaseTest {
  /**
   * Application context
   */
  protected ApplicationContext applicationContext;
  /**
   * Should be WhiskeyTester, but added jira bug WICKET-4943 to solve an issue
   */
  protected WhiskeyWicketTester wicketTester;
  /**
   * Getter for the application context (if no application context found, than create one
   * @return
   */
  public ApplicationContext getApplicationContext() {

    if (applicationContext == null)    {
      this.applicationContext =  new ClassPathXmlApplicationContext(new String[]{"classpath:/applicationContext.xml"});
    }

    return this.applicationContext;
  }
  /**
   * Default constructor
   */
   public BaseWicketTest() {
     WebApplication whiskeyApplication = new TestWhiskeyApplication(this.getApplicationContext());
     wicketTester = new WhiskeyWicketTester(whiskeyApplication);
   }

   public void checkSideLinks () {
     wicketTester.assertComponent("add", Link.class);
     wicketTester.assertComponent("addBrewery", Link.class);
     wicketTester.assertComponent("home", Link.class);
   }

}
