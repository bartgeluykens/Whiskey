package be.collections.whiskey.service;

import be.collections.whiskey.dto.SearchBreweryDto;
import be.collections.whiskey.model.Brewery;

import java.util.List;

/**
 * Service layer for the Brewery Class
 *
 * @Autor bart
 */
@SuppressWarnings("PMD.UnusedModifier")
public interface BreweryService extends GenericService<Brewery> {
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
   * Search a List of Breweries
   *
   * @param searchBreweryDto
   * @return
   */
  public List<Brewery> search(SearchBreweryDto searchBreweryDto);

}
