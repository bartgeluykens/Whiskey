package be.collections.whiskey.web.page;

import be.collections.whiskey.model.WhiskeyType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Test for the edit whiskey page
 *
 * @Autor Bart Geluykens
 *
 */
public class EditWhiskeyPageTest extends BaseWicketTest {

  /**
   * Test edit whiskey
   */
  @Test
  public void whenIOpenTheEditWhiskeyPageIWantToSeeSideLinks () {

    wicketTester.startPage(EditWhiskey.class);
    wicketTester.assertRenderedPage(EditWhiskey.class);
    checkSideLinks();
  }

}
