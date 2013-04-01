package be.collections.whiskey.dao;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.dto.SearchBreweryDto;
import be.collections.whiskey.model.Brewery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 4/1/13
 */
public class BreweryDaoTest extends BaseTest {

  @Autowired
  BreweryDAO breweryDAO;

  @Test
  public void whenSearchBreweryHasWhiskey () {
    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();
    searchBreweryDto.setWhiskeyName("old");

    List<Brewery> breweries = breweryDAO.search(searchBreweryDto);

    Assert.assertTrue(breweries.size() > 0);

  }

  @Test
  public void whenSearchForBrewery () {
    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();
    searchBreweryDto.setBreweryName("CAMPA");

    List<Brewery> breweries = breweryDAO.search(searchBreweryDto);

    Assert.assertTrue(breweries.size() > 0);

  }


  @Test
  public void whenSearchNoOptionsNoResults () {
    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();

    List<Brewery> breweries = breweryDAO.search(searchBreweryDto);

    Assert.assertEquals(breweries.size(), 0);

  }


}
