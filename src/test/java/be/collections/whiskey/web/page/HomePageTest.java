package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Test the home page
 *
 * @Autor Bart Geluykens
 *
 */
public class HomePageTest extends BaseWicketTest {

  private Whiskey getBasicWhiskeyObject() {
    Whiskey whiskey = new Whiskey();
    whiskey.setName("Great Test");
    whiskey.setRemarks("Great Remark");

    Brewery brewery = new Brewery();
    brewery.setName("Great Brewery");
    whiskey.setBrewery(brewery);

    WhiskeyType whiskeyType = new WhiskeyType();
    whiskeyType.setDescription("Great Malt");
    whiskey.setWhiskeyType(whiskeyType);

    return whiskey;
  }

  /**
   * Test the availablility of the home page
   */
  @Test
  public void whenIOpenTheHomePageIWantToSeeSideLinks () {
     wicketTester.startPage(HomePage.class, null);
     wicketTester.assertRenderedPage(HomePage.class);
     checkSideLinks();
    }

  /**
   * Test data table
   */
  @Test
  public void whenIOpenTheHOmePageIWantToSeeAListOfWhiskeys () {

    List< Whiskey > whiskeyList = new ArrayList<Whiskey>();

    whiskeyList.add(getBasicWhiskeyObject());

    Mockito.when(whiskeyService.findAll()).thenReturn(whiskeyList);
    wicketTester.startPage(HomePage.class, null);
    wicketTester.assertVisible("overview-panel:whiskey-table");
    wicketTester.assertModelValue("overview-panel:whiskey-table:1:whiskey", "Great Test");
    wicketTester.assertModelValue("overview-panel:whiskey-table:1:brewery", "Great Brewery");
    wicketTester.assertModelValue("overview-panel:whiskey-table:1:type", "Great Malt");
    wicketTester.assertModelValue("overview-panel:whiskey-table:1:remarks", "Great Remark");

  }

}
