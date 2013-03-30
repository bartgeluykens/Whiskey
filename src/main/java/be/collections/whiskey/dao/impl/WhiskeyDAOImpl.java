package be.collections.whiskey.dao.impl;

import be.collections.whiskey.dao.WhiskeyDAO;
import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Whiskey;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
@Repository
public class WhiskeyDAOImpl extends GenericDAOImpl <Whiskey> implements WhiskeyDAO {
  /**
   * {@inheritDoc}
   */
 public WhiskeyDAOImpl() {
		super();
	}
  /**
   * {@inheritDoc}
   */
	public WhiskeyDAOImpl(Class<Whiskey> clazz) {
		super(clazz);
	}
  /**
   * {@inheritDoc}
   */
  @Override
  public List<Whiskey> findAll() {
    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Whiskey.class);
    return criteria.list();
  }
  /**
   *
   */
  @Override
  public List<Whiskey> search(SearchWhiskeyDto searchWhiskeyDto) {

    if ( !searchWhiskeyDto.hasCriteria()) {
      return new ArrayList<Whiskey>();
    }

    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Whiskey.class);
    if (searchWhiskeyDto.getWhiskeyName() != null) {
      criteria.add(Restrictions.ilike("name", searchWhiskeyDto.getWhiskeyName() + "%"));
    }

    if ( searchWhiskeyDto.getBrewery() != null && searchWhiskeyDto.getBrewery().getId() != null) {
      criteria.createCriteria("brewery")
        .add(Restrictions.eq("id",searchWhiskeyDto.getBrewery().getId()));
    }

    if ( searchWhiskeyDto.getWhiskeyType() != null && searchWhiskeyDto.getWhiskeyType().getId() != null) {
      criteria.createCriteria("whiskeyType")
        .add(Restrictions.eq("id",searchWhiskeyDto.getWhiskeyType().getId()));
    }

    return criteria.list();

  }

}
