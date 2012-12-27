package be.collections.whiskey.web.page;

import org.apache.wicket.util.tester.TagTester;
import org.junit.Test;

/**
 *
 * Test the home page
 *
 * @Autor Bart Geluykens
 *
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
