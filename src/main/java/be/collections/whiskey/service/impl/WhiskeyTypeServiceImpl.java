package be.collections.whiskey.service.impl;

import be.collections.whiskey.dao.WhiskeyTypeDAO;
import be.collections.whiskey.model.WhiskeyType;
import be.collections.whiskey.service.WhiskeyTypeService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
@Transactional
public class WhiskeyTypeServiceImpl implements WhiskeyTypeService {

  @Autowired
  WhiskeyTypeDAO whiskeyTypeDAO;

  public List<WhiskeyType> findAll() {
    return whiskeyTypeDAO.findAll();
  }



}



