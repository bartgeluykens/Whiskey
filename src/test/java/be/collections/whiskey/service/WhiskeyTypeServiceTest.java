package be.collections.whiskey.service;


import be.collections.whiskey.BaseTest;
import be.collections.whiskey.model.WhiskeyType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/22/12
 */

public class WhiskeyTypeServiceTest extends BaseTest {

  @Autowired
  WhiskeyTypeService whiskeyTypeService;

  /**
   * Test if it is possible too retrieve whiskey types (There should be 8 different whiskeytypes avalable
   */
  @Test
  public void testIfMoreThanOneWhiskeyFound () {
    List<WhiskeyType> whiskeyTypeList = whiskeyTypeService.findAll();
    assert(whiskeyTypeList.size() > 1);
  }

}
