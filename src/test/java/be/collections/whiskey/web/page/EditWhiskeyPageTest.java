package be.collections.whiskey.web.page;

import org.junit.Test;

/**
 *
 * Test for the edit whiskey page
 *
 * @Autor Bart Geluykens
 *
 */
public class EditWhiskeyPageTest extends BaseWicketTest {

  /**
   * Test edit whiskey
   */
  @Test
  public void whenIOpenTheEditWhiskeyPageIWantToSeeSideLinks () {
    wicketTester.startPage(EditWhiskey.class);
    wicketTester.assertRenderedPage(EditWhiskey.class);
    checkSideLinks();
  }

}
