package be.collections.whiskey.service.impl;

import be.collections.whiskey.dao.WhiskeyDAO;
import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.service.WhiskeyService;
import org.springframework.beans.factory.annotation.Autowired;
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

  public Whiskey get(Integer id) {
      return whiskeyDAO.get(id);
  }
  /**
   * {@inheritDoc}
   */
  public List<Whiskey> search(SearchWhiskeyDto searchWhiskeyDto) {
    return whiskeyDAO.search(searchWhiskeyDto);
  }

  public void setWhiskeyDAO(WhiskeyDAO whiskeyDAO) {
    this.whiskeyDAO = whiskeyDAO;
  }
}
