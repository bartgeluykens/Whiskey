package be.collections.whiskey.web.page;

import org.junit.Test;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/26/12
 */
public class EditBreweryPageTest extends BaseWicketTest {

  @Test
  public void testEditBrewery () {
    wicketTester.startPage(EditBrewery.class);
    wicketTester.assertRenderedPage(EditBrewery.class);
    checkSideLinks();
  }

}
