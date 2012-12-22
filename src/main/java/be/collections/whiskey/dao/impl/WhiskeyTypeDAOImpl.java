package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.WhiskeyTypeDAO;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
@Repository
public class WhiskeyTypeDAOImpl extends GenericDAOImpl <WhiskeyType> implements WhiskeyTypeDAO {

  @Override
  public List<WhiskeyType> findAll() {

    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(WhiskeyType.class);
    return criteria.list();

  }
}
