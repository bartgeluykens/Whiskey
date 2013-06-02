package be.collections.whiskey.dao;

import be.collections.whiskey.BaseTest;
import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 3/30/13
 */

public class WhiskeyDaoTest extends BaseTest {

  @Autowired
  WhiskeyDAO whiskeyDAO;

  @Autowired
  BreweryDAO breweryDAO;

  @Autowired
  WhiskeyTypeDAO whiskeyTypeDAO;

  @Test
  public void whenSearchWithNoCriteriaWeHaveNoResults() {
    SearchWhiskeyDto searchWhiskeyDto =  new SearchWhiskeyDto();
    assertEquals(whiskeyDAO.search(searchWhiskeyDto).size(), 0);
  }

  @Test
  public void whenSearchWithName() {
    SearchWhiskeyDto searchWhiskeyDto =  new SearchWhiskeyDto();
    searchWhiskeyDto.setWhiskeyName("old");
    List<Whiskey> whiskeyListLowerCase = whiskeyDAO.search(searchWhiskeyDto);

    searchWhiskeyDto.setWhiskeyName("OLD");
    List<Whiskey> whiskeyListUpperCase = whiskeyDAO.search(searchWhiskeyDto);

    assert(whiskeyListLowerCase.size()>0);
    assertEquals(whiskeyListLowerCase.size(), whiskeyListUpperCase.size());

    for (int i = 0; i < whiskeyListUpperCase.size(); i++) {
      assertEquals(whiskeyListUpperCase.get(0).getName(), whiskeyListLowerCase.get(0).getName());
    }
  }

  @Test
  public void whenSearchByBreweryId() {

    List<Brewery> breweries = breweryDAO.findAll();

    SearchWhiskeyDto searchWhiskeyDto =  new SearchWhiskeyDto();
    Brewery brewery = new Brewery();
    brewery.setId(breweries.get(0).getId());
    searchWhiskeyDto.setBrewery(brewery);

    List<Whiskey> whiskeys = whiskeyDAO.search(searchWhiskeyDto);

    assertEquals(whiskeys.get(0).getBrewery().getName(), breweries.get(0).getName());
    assertEquals(whiskeys.get(0).getBrewery().getId(), breweries.get(0).getId());

  }

  @Test
  public void whenSearchByWhiskeyTypeId() {

    List<WhiskeyType> whiskeyTypes = whiskeyTypeDAO.findAll();

    SearchWhiskeyDto searchWhiskeyDto =  new SearchWhiskeyDto();
    WhiskeyType whiskeyType = new WhiskeyType();
    whiskeyType.setId(whiskeyTypes.get(0).getId());
    searchWhiskeyDto.setWhiskeyType(whiskeyType);

    List<Whiskey> whiskeys = whiskeyDAO.search(searchWhiskeyDto);

    assertEquals(whiskeys.get(0).getWhiskeyType().getDescription(), whiskeyTypes.get(0).getDescription());
    assertEquals(whiskeys.get(0).getWhiskeyType().getId(), whiskeyTypes.get(0).getId());

  }


  @Test
  public void whenSavingAWhiskey () {

    Brewery brewery = breweryDAO.get(1);
    WhiskeyType whiskeyType = whiskeyTypeDAO.get(1);

    Whiskey whiskey = new Whiskey();
    whiskey.setBrewery(brewery);
    whiskey.setDescription("My favorite whiskey");
    whiskey.setName("Barts super whiskey");
    whiskey.setRemarks("My remarks");
    whiskey.setWhiskeyType(whiskeyType);

    whiskeyDAO.save(whiskey);

  }



}
