package be.collections.whiskey.dao;

import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * Data acces object for whiskey type
 *
 * @Autor Bart Geluykens
 */
@Repository
public interface WhiskeyTypeDAO extends GenericDAO<WhiskeyType> {
  /**
   * Find al whiskey types
   *
   * @return  list of whiskey types
   */
 public List<WhiskeyType> findAll();
}
