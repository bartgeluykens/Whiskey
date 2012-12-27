package be.collections.whiskey;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Basic settings for all unit tests
 *
 * @Autor Bart Geluykens
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional(propagation= Propagation.REQUIRED, rollbackFor={Exception.class})
public abstract class BaseTest  extends Assert {

}
