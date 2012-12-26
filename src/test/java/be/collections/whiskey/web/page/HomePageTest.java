package be.collections.whiskey.web.page;

import be.collections.whiskey.BaseTest;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.util.tester.TagTester;
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
public class HomePageTest extends BaseWicketTest {

  /**
   * Test the availablility of the home page
   */
  @Test
  public void testHomePageAvailable () {
     wicketTester.startPage(HomePage.class, null);
     wicketTester.assertRenderedPage(HomePage.class);
     checkSideLinks();
    }

  /**
   * Test data table
   */
  @Test
  public void testDataTable () {
    wicketTester.startPage(HomePage.class, null);
    TagTester tagTester = wicketTester.getTagByWicketId("whiskeyTable");
    assertNotNull("No datatable defined in the homepage", tagTester);

  }

}
