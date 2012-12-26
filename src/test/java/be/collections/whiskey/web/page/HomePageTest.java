package be.collections.whiskey.web.page;

import be.collections.whiskey.BaseTest;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/23/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional(propagation= Propagation.REQUIRED, rollbackFor={Exception.class})

public class HomePageTest extends BaseWicketTest {

  @Test
  public void testHomePageAvailable () {
  //  wicketTester.setFollowRedirects(false);
         wicketTester.startPage(HomePage.class, null);
     wicketTester.assertRenderedPage(HomePage.class);
     wicketTester.assertComponent("add", Link.class);

    }

}
