package be.collections.whiskey.dao;

import be.collections.whiskey.model.Whiskey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Service class for whiskey
 *
 * @Autor Bart Geluykens
 */
@Repository
public interface WhiskeyDAO extends GenericDAO<Whiskey> {
  /**
   * List all whiskey's
   *
   * @return List with whiskeys
   */
  public List <Whiskey> findAll();
}
