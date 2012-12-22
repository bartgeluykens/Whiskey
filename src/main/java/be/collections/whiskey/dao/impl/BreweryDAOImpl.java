package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.model.Brewery;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
    return criteria.list();
  }

  @Override
  public List<Brewery> findByName(String name) {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Brewery.class);
    criteria.add(Restrictions.eq("name", name));
    return criteria.list();
  }
}
