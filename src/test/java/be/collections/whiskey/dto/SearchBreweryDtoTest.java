package be.collections.whiskey.dto;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 4/1/13
 */
public class SearchBreweryDtoTest extends Assert {

  @Test
  public void whenSearchBreweryHasNoDetailsHasCriteriaIsFalse () {
    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();
    assertFalse(searchBreweryDto.hasCriteria());
  }

  @Test
  public void whenSearchBreweryHasBreweryNameHasCriteriaIsTrue () {
    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();
    searchBreweryDto.setBreweryName("name");
    assertTrue(searchBreweryDto.hasCriteria());
 }

  @Test
  public void whenSearchBreweryHasWhiskeyyNameHasCriteriaIsTrue () {
    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();
    searchBreweryDto.setWhiskeyName("name");
    assertTrue(searchBreweryDto.hasCriteria());
 }

}
