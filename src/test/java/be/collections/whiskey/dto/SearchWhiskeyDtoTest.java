package be.collections.whiskey.dto;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.WhiskeyType;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 3/30/13
 */
public class SearchWhiskeyDtoTest extends Assert {

  @Test
  public void whenNoSearchCriteria() {
    SearchWhiskeyDto searchWhiskeyDto = new SearchWhiskeyDto();
    assertEquals(searchWhiskeyDto.hasCriteria(), false);
  }

  @Test
  public void whenBreweryIsFilledIn() {
    SearchWhiskeyDto searchWhiskeyDto = new SearchWhiskeyDto();

    Brewery brewery = new Brewery();
    brewery.setId(1);
    searchWhiskeyDto.setBrewery(brewery);
    assertEquals(searchWhiskeyDto.hasCriteria(), true);
  }

  @Test
  public void whenNameIsFilledIn() {
    SearchWhiskeyDto searchWhiskeyDto = new SearchWhiskeyDto();
    searchWhiskeyDto.setWhiskeyName("a Name");
    assertEquals(searchWhiskeyDto.hasCriteria(), true);
  }

  @Test
  public void whenWhiskeyTypeIsFilledIn() {
    SearchWhiskeyDto searchWhiskeyDto = new SearchWhiskeyDto();
    WhiskeyType whiskeyType = new WhiskeyType();
    whiskeyType.setId(1);
    searchWhiskeyDto.setWhiskeyType(whiskeyType);
    assertEquals(searchWhiskeyDto.hasCriteria(), true);
  }


}
