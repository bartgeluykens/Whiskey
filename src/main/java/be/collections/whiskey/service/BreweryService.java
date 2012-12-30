package be.collections.whiskey.service;

import be.collections.whiskey.model.Brewery;

import java.util.List;

/**
 * Service layer for the Brewery Class
 *
 * @Autor bart
 */
public interface BreweryService {
  /**
   * List all breweries
   *
   * @return list of breweries
   */
  List<Brewery> findAll();
  /**
   * Find brewery by name
   *
   * @param name name of the brewery
   * @return
   */
  List<Brewery> findByName(String name);
  /**
   * Save a brewery
   *
   * @param brewery brewery to save
   * @return The saved brewery
   */
  public Brewery save(Brewery brewery);

  /**
   * Find a brewery by id
   *
   * @param id
   * @return a brewery
   */
  public Brewery findById(Integer id);
}
