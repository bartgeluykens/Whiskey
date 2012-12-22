package be.collections.whiskey.service.impl;

import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
@Transactional
public class BreweryServiceImpl implements BreweryService {

  @Autowired
  BreweryDAO breweryDAO;

  @Override
  public List<Brewery> findAll() {
    return breweryDAO.findAll();
  }

  @Override
  public List<Brewery> findByName(String name) {
    return breweryDAO.findByName(name);
  }

  @Override
  public Brewery save(Brewery brewery) {
    return breweryDAO.save(brewery);  //To change body of implemented methods use File | Settings | File Templates.
  }
}
