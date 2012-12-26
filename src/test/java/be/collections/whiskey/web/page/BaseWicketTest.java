package be.collections.whiskey.web.page;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.web.application.TestWhiskeyApplication;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WhiskeyWicketTester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/23/12
 */

public abstract class BaseWicketTest extends BaseTest {

  protected ApplicationContext applicationContext;

  /**
   * Should be WhiskeyTester, but added jira bug WICKET-4943 to solve an issue
   */
  protected WhiskeyWicketTester wicketTester;

  public ApplicationContext getApplicationContext() {

   if (applicationContext == null)    {
     this.applicationContext =  new ClassPathXmlApplicationContext(new String[]{"classpath:/applicationContext.xml"});
   }

    return this.applicationContext;
   }

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
