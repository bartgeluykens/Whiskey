package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.BreweryDAO;
import be.collections.whiskey.dto.SearchBreweryDto;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class BreweryDAOImpl extends GenericDAOImpl <Brewery> implements BreweryDAO {
  /**
   * {@inheritDoc}
   */
  public List<Brewery> findAll() {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Brewery.class);
    return criteria.list();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public List<Brewery> findByName(String name) {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Brewery.class);
    criteria.add(Restrictions.eq("name", name));
    return criteria.list();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public Brewery findById(Integer id) {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Brewery.class);
    criteria.add(Restrictions.eq("id", id));
    return (Brewery)criteria.uniqueResult();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public List<Brewery> search(SearchBreweryDto searchBreweryDto) {

    if (!searchBreweryDto.hasCriteria()) {
      return new ArrayList<Brewery>();
    }

    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Brewery.class, "brew");
    if (searchBreweryDto.getBreweryName() != null) {
      criteria.add(Restrictions.ilike("name", searchBreweryDto.getBreweryName() + "%"));
    }

    if (searchBreweryDto.getWhiskeyName() != null) {

      DetachedCriteria whiskeyCriteria =  DetachedCriteria.forClass(Whiskey.class, "whis");
      whiskeyCriteria.add(Restrictions.ilike("whis.name", searchBreweryDto.getWhiskeyName() + '%'))
                     .add(Restrictions.eqProperty("whis.brewery.id", "brew.id"))
                     .setProjection(Projections.property("whis.brewery.id"));


      criteria.add(Subqueries.exists(whiskeyCriteria));
    }

    return criteria.list();
  }
}
