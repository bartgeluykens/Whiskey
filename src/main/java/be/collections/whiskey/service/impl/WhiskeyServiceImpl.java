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
 * {@inheritDoc}
 */
@Transactional
public class WhiskeyServiceImpl implements WhiskeyService{
  /**
   * Whiskey data objects
   */
  @Autowired
  WhiskeyDAO whiskeyDAO;
  /**
   * {@inheritDoc}
   */
  public List<Whiskey> findAll() {
     return whiskeyDAO.findAll();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public void save(Whiskey whiskey) {
    whiskeyDAO.save(whiskey);
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public void remove(Whiskey whiskey) {
    whiskeyDAO.remove(whiskey);
  }
}
