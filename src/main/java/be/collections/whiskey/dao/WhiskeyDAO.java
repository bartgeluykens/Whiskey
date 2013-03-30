package be.collections.whiskey.dao;

import be.collections.whiskey.dto.SearchWhiskeyDto;
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

  /**
   * Search for a whiskey
   *
   * @param searchWhiskeyDto Search Dto
   *
   * @return
   */
  public List<Whiskey> search(SearchWhiskeyDto searchWhiskeyDto);
}
