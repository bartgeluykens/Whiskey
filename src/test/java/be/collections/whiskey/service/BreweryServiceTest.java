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
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/22/12
 */
public class BreweryServiceTest extends BaseTest {

  String breweryName = "##MyTestBrewery##";

  @Autowired
  BreweryService breweryService;

  @Autowired
  BreweryDAO breweryDAO;

  @Before
  public void init () {
      Brewery brewery = new Brewery();

      brewery.setName(breweryName);
      brewery.setLocation("Brewery Island");

      breweryDAO.save(brewery);
  }

  @Test
  public void findAllBreweries() {
    List<Brewery> breweryList = breweryService.findAll();
    assert (breweryList.size() > 0) ;
  }




  @After
  public void after () {

     for (Brewery brewery : breweryService.findByName(breweryName)) {
       breweryDAO.remove(brewery);
     }
  }


}
