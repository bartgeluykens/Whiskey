package be.collections.whiskey.web.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/26/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional(propagation= Propagation.REQUIRED, rollbackFor={Exception.class})
public class EditWhiskeyPageTest extends BaseWicketTest {

  @Test
  public void testEditWhiskeyPage () {
    wicketTester.startPage(EditWhiskey.class);
    wicketTester.assertRenderedPage(EditWhiskey.class);
    checkSideLinks();
  }

}
