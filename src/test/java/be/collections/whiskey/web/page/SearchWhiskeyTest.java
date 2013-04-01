package be.collections.whiskey.web.page;

import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 3/30/13
 */
public class SearchWhiskeyTest extends BaseWicketTest {

  @Test
  public void whenIOpenTheSearchWhiskeyPageIWantToSeeTheSideLinks() {
    wicketTester.startPage(SearchWhiskey.class, null);
    wicketTester.assertRenderedPage(SearchWhiskey.class);
    checkSideLinks();
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

    ArrayList<Whiskey> whiskeys = new ArrayList<Whiskey>();
    Mockito.when(whiskeyService.search(Matchers.any(SearchWhiskeyDto.class))).thenReturn(whiskeys);

    wicketTester.startPage(SearchWhiskey.class, null);
    wicketTester.assertRenderedPage(SearchWhiskey.class);

    FormTester formTester = wicketTester.newFormTester("search-form");
    formTester.setValue("name","Test");
    formTester.submit("button-search");

    wicketTester.assertVisible("no-data-found-container");
  }


  @Test
  public void whenSearchCriteriaResult() {

    ArrayList<Whiskey> whiskeys = new ArrayList<Whiskey>();
    Whiskey whiskey = new Whiskey();
    whiskey.setName("My whiskey");
    whiskey.setBrewery(new Brewery());
    whiskey.setWhiskeyType(new WhiskeyType());
    whiskeys.add(whiskey);
    Mockito.when(whiskeyService.search(Matchers.any(SearchWhiskeyDto.class))).thenReturn(whiskeys);

    wicketTester.startPage(SearchWhiskey.class, null);
    wicketTester.assertRenderedPage(SearchWhiskey.class);

    FormTester formTester = wicketTester.newFormTester("search-form");
    formTester.setValue("name","Test");
    formTester.submit("button-search");

    wicketTester.assertInvisible("no-data-found-container");
    wicketTester.assertVisible("overview-panel");
  }


  @Test
  public void whenClickOnResetThenNoSearchData() {

    wicketTester.startPage(SearchWhiskey.class, null);

    FormTester formTester = wicketTester.newFormTester("search-form");
    formTester.setValue("name","Test");
    formTester .submit("button-reset");

    formTester = wicketTester.newFormTester("search-form");

    Assert.assertEquals(formTester.getTextComponentValue("name"),"");

  }





}
