package be.collections.whiskey.service.impl;

import be.collections.whiskey.dao.WhiskeyTypeDAO;
import be.collections.whiskey.model.WhiskeyType;
import be.collections.whiskey.service.WhiskeyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * {@inheritDoc}
 */
@Transactional
public class WhiskeyTypeServiceImpl implements WhiskeyTypeService {
  /**
   * Whiskey type data object
   */
  @Autowired
  WhiskeyTypeDAO whiskeyTypeDAO;

  /**
   * {@inheritDoc}
   */
  public List<WhiskeyType> findAll() {
    return whiskeyTypeDAO.findAll();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public WhiskeyType findById(Integer id) {
    return whiskeyTypeDAO.findById(id);
  }

  public void setWhiskeyTypeDAO(WhiskeyTypeDAO whiskeyTypeDAO) {
    this.whiskeyTypeDAO = whiskeyTypeDAO;
  }
}



