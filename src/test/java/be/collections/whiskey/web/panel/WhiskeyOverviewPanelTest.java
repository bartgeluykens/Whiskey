package be.collections.whiskey.web.panel;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import be.collections.whiskey.web.page.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 3/30/13
 */
public class WhiskeyOverviewPanelTest extends BaseWicketTest {

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
   * Test data table
   */
  @Test
  public void whenIOpenTheHOmePageIWantToSeeAListOfWhiskeys () {

    List< Whiskey > whiskeyList = new ArrayList<Whiskey>();

    whiskeyList.add(getBasicWhiskeyObject());

    WhiskeyOverviewPanel whiskeyOverviewPanel = new WhiskeyOverviewPanel("test-panel", whiskeyList);
    wicketTester.startComponentInPage(whiskeyOverviewPanel);

    wicketTester.assertVisible("test-panel:whiskey-table");
    wicketTester.assertModelValue("test-panel:whiskey-table:1:whiskey", "Great Test");
    wicketTester.assertModelValue("test-panel:whiskey-table:1:brewery", "Great Brewery");
    wicketTester.assertModelValue("test-panel:whiskey-table:1:type", "Great Malt");
    wicketTester.assertModelValue("test-panel:whiskey-table:1:remarks", "Great Remark");
  }

  @Test
  public void whenIClickOnEditWhiskeyIWantToOpenTheEditWhiskeyPage () {

    List< Whiskey > whiskeyList = new ArrayList<Whiskey>();

    whiskeyList.add(getBasicWhiskeyObject());

    WhiskeyOverviewPanel whiskeyOverviewPanel = new WhiskeyOverviewPanel("test-panel", whiskeyList);
    wicketTester.startComponentInPage(whiskeyOverviewPanel);

    wicketTester.clickLink("test-panel:whiskey-table:1:whiskey-edit");
    wicketTester.assertRenderedPage(EditWhiskey.class);
  }

  @Test
  public void whenIClickOnEditWhiskeyIWantToOpenTheViewWhiskeyPage () {

    List< Whiskey > whiskeyList = new ArrayList<Whiskey>();

    whiskeyList.add(getBasicWhiskeyObject());

    WhiskeyOverviewPanel whiskeyOverviewPanel = new WhiskeyOverviewPanel("test-panel", whiskeyList);
    wicketTester.startComponentInPage(whiskeyOverviewPanel);

    wicketTester.clickLink("test-panel:whiskey-table:1:whiskey-details");
    wicketTester.assertRenderedPage(DetailsPage.class);
  }

  @Test
  public void whenIClickOnEditBreweryIWantToOpenTheEditBreweryPage () {

    List< Whiskey > whiskeyList = new ArrayList<Whiskey>();

    whiskeyList.add(getBasicWhiskeyObject());

    WhiskeyOverviewPanel whiskeyOverviewPanel = new WhiskeyOverviewPanel("test-panel", whiskeyList);
    wicketTester.startComponentInPage(whiskeyOverviewPanel);

    wicketTester.clickLink("test-panel:whiskey-table:1:brewery-edit");
    wicketTester.assertRenderedPage(EditBrewery.class);
  }



}
