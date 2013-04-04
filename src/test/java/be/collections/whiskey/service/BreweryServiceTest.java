package be.collections.whiskey.service;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.dto.SearchBreweryDto;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.service.impl.BreweryServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Test the brewery service
 *
 * @Autor Bart Geluykens
 */
public class BreweryServiceTest extends Assert {
  /**
   * Dummy brewery name
   */
  String breweryName = "##MyTestBrewery##";
  /**
   * Brewery service
   */
  BreweryService breweryService;
  /**
   * Brewery DAO
   */
  BreweryDAO breweryDAO;
  /**
   * initialize brewery
   */
  @Before
  public void init () {
      breweryService = new BreweryServiceImpl();

      breweryDAO = Mockito.mock(BreweryDAO.class);
      ((BreweryServiceImpl)breweryService).setBreweryDAO(breweryDAO);


  }
  /**
   * Does the find all breweries work?
   */
  @Test
  public void whenIDoFindAllIWantToGetAListOfBreweries() {

    List<Brewery> breweries = new ArrayList<Brewery>();
    Brewery brewery = new Brewery();
    brewery.setName(breweryName);
    brewery.setLocation("Brewery Island");
    breweries.add(brewery);

    Mockito.when(breweryDAO.findAll()).thenReturn(breweries);

    List<Brewery> breweryList = breweryService.findAll();
    assertEquals(breweryList.size() , 1);
    assertEquals(breweryList.get(0).getName(), breweryName);
    assertEquals(breweryList.get(0).getLocation(),"Brewery Island");
  }

  @Test
  public void whenISearchByNameIWantToGetAListOfBreweries() {

    List<Brewery> breweries = new ArrayList<Brewery>();
    Brewery brewery = new Brewery();
    brewery.setName(breweryName);
    brewery.setLocation("Brewery Island");
    breweries.add(brewery);

    Mockito.when(breweryDAO.findByName(breweryName)).thenReturn(breweries);

    List<Brewery> breweryList = breweryService.findByName(breweryName);
    assertEquals(breweryList.size() , 1);
    assertEquals(breweryList.get(0).getName(), breweryName);
    assertEquals(breweryList.get(0).getLocation(),"Brewery Island");
  }


  @Test
  public void whenISearchByIdIWantToGetABrewery() {

    Brewery brewery = new Brewery();
    brewery.setName(breweryName);
    brewery.setLocation("Brewery Island");

    Mockito.when(breweryDAO.findById(1)).thenReturn(brewery);

    Brewery resultBrewery = breweryService.findById(1);
    assertEquals(resultBrewery.getName(), breweryName);
    assertEquals(resultBrewery.getLocation(),"Brewery Island");
  }

  @Test
  public void whenISearchBySeachCriteriaIWantToGetAListOfBreweries() {
    SearchBreweryDto searchBreweryDto = new SearchBreweryDto();

    List<Brewery> breweries = new ArrayList<Brewery>();
    breweries.add(new Brewery());

    Mockito.when(breweryDAO.search(searchBreweryDto)).thenReturn(breweries);

    List<Brewery> breweryResult = breweryService.search(searchBreweryDto);
    assertEquals(breweryResult.size(), 1);
  }

}
