package be.collections.whiskey.service;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.model.Brewery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Test the brewery service
 *
 * @Autor Bart Geluykens
 */
public class BreweryServiceTest extends BaseTest {
  /**
   * Dummy brewery name
   */
  String breweryName = "##MyTestBrewery##";
  /**
   * Brewery service
   */
  @Autowired
  BreweryService breweryService;
  /**
   * Brewery DAO
   */
  @Autowired
  BreweryDAO breweryDAO;
  /**
   * initialize brewery
   */
  @Before
  public void init () {
      Brewery brewery = new Brewery();

      brewery.setName(breweryName);
      brewery.setLocation("Brewery Island");

      breweryDAO.save(brewery);
  }
  /**
   * Does the find all breweries work?
   */
  @Test
  public void findAllBreweries() {
    List<Brewery> breweryList = breweryService.findAll();
    assert (breweryList.size() > 0) ;
  }
  /**
   * Remove brewery
   */
  @After
  public void after () {

     for (Brewery brewery : breweryService.findByName(breweryName)) {
       breweryDAO.remove(brewery);
     }
  }


}
