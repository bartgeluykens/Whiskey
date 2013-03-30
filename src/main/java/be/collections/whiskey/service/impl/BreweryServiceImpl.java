package be.collections.whiskey.service.impl;

import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for the Brewery Class
 *
 * @Autor bart
 */
@Transactional
public class BreweryServiceImpl implements BreweryService {
  /**
   * Brewery DAO
   */
  @Autowired
  BreweryDAO breweryDAO;
  /**
   * {@inheritDoc}
   */
  @Override
  public List<Brewery> findAll() {
    return breweryDAO.findAll();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public List<Brewery> findByName(String name) {
    return breweryDAO.findByName(name);
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public Brewery save(Brewery brewery) {
    return breweryDAO.save(brewery);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Brewery findById(Integer id) {
    /**
     * This should work, but for an unkown reason it doesn't. Have to find this out why
     *
     * return breweryDAO.get(id);
     */
    return breweryDAO.findById(id);
  }

  public void setBreweryDAO(BreweryDAO breweryDAO) {
    this.breweryDAO = breweryDAO;
  }
}
