package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.model.Brewery;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
@Repository
public class BreweryDAOImpl extends GenericDAOImpl <Brewery> implements BreweryDAO {

  public List<Brewery> findAll() {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Brewery.class);
    return criteria.list();  //To change body of implemented methods use File | Settings | File Templates.
  }
}
