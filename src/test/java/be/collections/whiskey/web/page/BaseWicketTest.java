package be.collections.whiskey.web.page;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.web.application.TestWhiskeyApplication;
import be.collections.whiskey.web.application.WhiskeyApplication;
import org.apache.wicket.Application;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WhiskeyWicketTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/23/12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional(propagation= Propagation.REQUIRED, rollbackFor={Exception.class})
public abstract class BaseWicketTest extends Assert {

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


}
