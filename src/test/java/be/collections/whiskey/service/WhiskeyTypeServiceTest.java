package be.collections.whiskey.service;


import be.collections.whiskey.BaseTest;
import be.collections.whiskey.model.WhiskeyType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Whiskey Type service test
 *
 * @Autor Bart Geluykens
 */

public class WhiskeyTypeServiceTest extends BaseTest {
  /**
   * Whiskey Type service
   */
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
