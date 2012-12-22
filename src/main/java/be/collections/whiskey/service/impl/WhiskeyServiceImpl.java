package be.collections.whiskey.service.impl;

import be.collections.whiskey.dao.WhiskeyDAO;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.service.WhiskeyService;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
// @ Service
@Transactional
public class WhiskeyServiceImpl implements WhiskeyService{

  @Autowired
  WhiskeyDAO whiskeyDAO;

  public List<Whiskey> findAll() {
     return whiskeyDAO.findAll();
  }

  @Override
  public void save(Whiskey whiskey) {
    whiskeyDAO.save(whiskey);
  }

  @Override
  public void remove(Whiskey whiskey) {
    whiskeyDAO.remove(whiskey);
  }
}
