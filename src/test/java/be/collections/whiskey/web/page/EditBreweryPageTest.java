package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Brewery;
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

  @Test
  public void whenIOpenANewBreweryIWantToSeeTheEditBreweryTag () {
    wicketTester.startPage(EditBrewery.class);
    wicketTester.assertLabel("title", "Add brewery");
  }


  @Test
  public void whenIOpenAnExistingBreweryIWantToSeeTheEditBreweryTag () {
    Brewery brewery = new Brewery();
    brewery.setId(1);
    wicketTester.startPage(new EditBrewery(brewery));
    wicketTester.assertLabel("title", "Edit brewery");
  }

}
