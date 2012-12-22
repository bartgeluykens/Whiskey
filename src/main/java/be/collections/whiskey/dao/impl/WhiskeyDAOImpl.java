package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.WhiskeyDAO;
import be.collections.whiskey.model.Whiskey;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
@Repository
public class WhiskeyDAOImpl extends GenericDAOImpl <Whiskey> implements WhiskeyDAO {

 public WhiskeyDAOImpl() {
		super();
	}

	public WhiskeyDAOImpl(Class<Whiskey> clazz) {
		super(clazz);
	}

  @Override
  public List<Whiskey> findAll() {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Whiskey.class);

    return criteria.list();
  }
}
