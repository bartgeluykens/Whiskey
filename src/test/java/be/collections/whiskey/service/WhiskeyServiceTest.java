package be.collections.whiskey.service;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.dao.WhiskeyTypeDAO;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * This are test for the whiskey Service
 *
 * @Autor Bart Geluykens
 * Omschrijving:
 * Aangemaakt op: 12/30/12
 */
public class WhiskeyServiceTest extends BaseTest {

  @Autowired
  WhiskeyService whiskeyService;

  @Autowired
  WhiskeyTypeDAO whiskeyTypeDAO;

  @Autowired
  BreweryService breweryService;

  @Autowired
  BreweryDAO breweryDAO;

  /**
   * Look if we can add a whiskey
   */
  @Test
  public void testAddingAWhiskey () {

    Brewery brewery = breweryService.findById(1);
    WhiskeyType whiskeyType = whiskeyTypeDAO.findById(1);

    Whiskey whiskey = new Whiskey();
    whiskey.setBrewery(brewery);
    whiskey.setDescription("My favorite whiskey");
    whiskey.setName("Barts super whiskey");
    whiskey.setRemarks("My remarks");
    whiskey.setWhiskeyType(whiskeyType);

    whiskeyService.save(whiskey);

  }
}
