package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.WhiskeyTypeDAO;
import be.collections.whiskey.model.WhiskeyType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class WhiskeyTypeDAOImpl extends GenericDAOImpl <WhiskeyType> implements WhiskeyTypeDAO {
  /**
   * {@inheritDoc}
   */
  @Override
  public List<WhiskeyType> findAll() {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WhiskeyType.class);
    return criteria.list();
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public WhiskeyType findById(Integer id) {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WhiskeyType.class);
    criteria.add(Restrictions.eq("id",id));
    return (WhiskeyType)criteria.uniqueResult();

  }
}
