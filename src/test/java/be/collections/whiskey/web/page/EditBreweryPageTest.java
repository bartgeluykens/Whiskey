package be.collections.whiskey.web.page;

import org.junit.Test;

/**
 * Test brewery page
 *
 * @Autor Bart Geluykens
 *
 */
public class EditBreweryPageTest extends BaseWicketTest {

  /**
   * Test the edit brewery page
   */
  @Test
  public void whenIOpenTheEditBreweryPageIWantToSeeMySideLinks () {
    wicketTester.startPage(EditBrewery.class);
    wicketTester.assertRenderedPage(EditBrewery.class);
    checkSideLinks();
  }

}
