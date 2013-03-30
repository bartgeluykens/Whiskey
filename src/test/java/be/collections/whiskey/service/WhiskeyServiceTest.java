package be.collections.whiskey.service;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.dao.WhiskeyDAO;
import be.collections.whiskey.dao.WhiskeyTypeDAO;
import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import be.collections.whiskey.service.impl.WhiskeyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This are test for the whiskey Service
 *
 * @Autor Bart Geluykens
 * Omschrijving:
 * Aangemaakt op: 12/30/12
 */
public class WhiskeyServiceTest extends Assert {

  WhiskeyService whiskeyService;

  WhiskeyDAO whiskeyDAO;

  @Before
  public void setUp() {
    whiskeyService = new WhiskeyServiceImpl();

    whiskeyDAO = Mockito.mock(WhiskeyDAO.class);
    ((WhiskeyServiceImpl)whiskeyService).setWhiskeyDAO(whiskeyDAO);
  }

  @Test
  public void whenISearchAWhiskey() {
    SearchWhiskeyDto searchWhiskeyDto =  new SearchWhiskeyDto();
    searchWhiskeyDto.setWhiskeyName("Search This Whiskey");

    List<Whiskey> whiskeys = new ArrayList<Whiskey>();
    Whiskey whiskey = new Whiskey();
    whiskey.setName("Found");
    whiskeys.add(whiskey);
    Mockito.when(whiskeyDAO.search(searchWhiskeyDto)).thenReturn(whiskeys);

    List<Whiskey> foundWhiskeys = whiskeyService.search(searchWhiskeyDto);
    assertEquals(foundWhiskeys.size(),1);

    assertEquals(foundWhiskeys.get(0).getName(),"Found");
  }


}
