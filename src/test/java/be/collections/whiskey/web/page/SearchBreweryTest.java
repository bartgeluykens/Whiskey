package be.collections.whiskey.web.page;

import be.collections.whiskey.dto.SearchBreweryDto;
import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 4/1/13
 */
public class SearchBreweryTest extends BaseWicketTest {

  @Test
  public void whenIOpenTheSearchBreweryWindowIWantToSeeSidelinks() {
    wicketTester.startPage(SearchBrewery.class, null);
    wicketTester.assertRenderedPage(SearchBrewery.class);
    checkSideLinks();
    wicketTester.assertInvisible("no-data-found-container");
    wicketTester.assertInvisible("result-container");
  }

  @Test
   public void whenNoSearchCriteriaGiveError() {
     wicketTester.startPage(SearchWhiskey.class, null);
     wicketTester.assertRenderedPage(SearchWhiskey.class);

     FormTester formTester = wicketTester.newFormTester("search-form");
     formTester.submit("button-search");

     wicketTester.assertFeedback("feedback", "No seach criteria");
   }

  @Test
  public void whenSearchCriteriaNoResult() {

    ArrayList<Brewery> breweries = new ArrayList<Brewery>();
    Mockito.when(breweryService.search(Matchers.any(SearchBreweryDto.class))).thenReturn(breweries);

    wicketTester.startPage(SearchBrewery.class, null);
    wicketTester.assertRenderedPage(SearchBrewery.class);

    FormTester formTester = wicketTester.newFormTester("search-form");
    formTester.setValue("brewery-name","Test");
    formTester.submit("button-search");

    wicketTester.assertVisible("no-data-found-container");
    wicketTester.assertInvisible("result-container");
  }

  @Test
  public void whenSearchCriteriaHasResults() {

    ArrayList<Brewery> breweries = new ArrayList<Brewery>();
    Brewery brewery = new Brewery();
    brewery.setName("Name");
    brewery.setLocation("Location");
    breweries.add(brewery);
    Mockito.when(breweryService.search(Matchers.any(SearchBreweryDto.class))).thenReturn(breweries);

    wicketTester.startPage(SearchBrewery.class, null);
    wicketTester.assertRenderedPage(SearchBrewery.class);

    FormTester formTester = wicketTester.newFormTester("search-form");
    formTester.setValue("brewery-name","Test");
    formTester.submit("button-search");

    wicketTester.assertInvisible("no-data-found-container");
    wicketTester.assertVisible("result-container");

    wicketTester.assertModelValue("result-container:brewery-table:1:name", "Name");
    wicketTester.assertModelValue("result-container:brewery-table:1:location", "Location");

  }

  @Test
  public void whenEditBreweryIsClicked() {

    ArrayList<Brewery> breweries = new ArrayList<Brewery>();
    Brewery brewery = new Brewery();
    brewery.setName("Name");
    brewery.setLocation("Location");
    breweries.add(brewery);
    Mockito.when(breweryService.search(Matchers.any(SearchBreweryDto.class))).thenReturn(breweries);

    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();
    searchBreweryDto.setBreweryName("Test");

    wicketTester.startPage(new SearchBrewery(searchBreweryDto));

    wicketTester.assertVisible("result-container");
    wicketTester.clickLink("result-container:brewery-table:1:brewery-edit");
    wicketTester.assertRenderedPage(EditBrewery.class);

  }



}
