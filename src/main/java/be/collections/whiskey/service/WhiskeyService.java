package be.collections.whiskey.service;

import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Whiskey;

import java.util.List;

/**
 * Whiskey Service layer
 *
 * @Autor bart
 */
@SuppressWarnings("PMD.UnusedModifier")
public interface WhiskeyService {
  /**
   * List all whiskeys
   *
   * @return list of whiskeys
   */
   public List<Whiskey> findAll();
  /**
   * Save a whiskey
   *
   * @param whiskey
   */
   public void save(Whiskey whiskey);
  /**
   * Remove a whiskey from the database
   *
   * @param whiskey
   */
   public void remove(Whiskey whiskey);
  /**
   * Whiskey Service
   */
   public List<Whiskey> search(SearchWhiskeyDto searchWhiskeyDto);
}
