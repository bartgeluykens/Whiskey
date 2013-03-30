package be.collections.whiskey.dao;

import be.collections.whiskey.model.Brewery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Data access object for the Brewery
 * @Autor bart geluykens
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
@Repository
@SuppressWarnings("PMD.UnusedModifier")
public interface BreweryDAO  extends GenericDAO<Brewery> {
  /**
   * find all breweries
   *
   * @return List of breweries
   */
  List<Brewery> findAll();

  /**
   * Find breweries by name
   *
   * @param name
   * @return  List of breweries wit this name
   */
  List<Brewery> findByName (String name);

  /**
   * find brewery by id
   *
   * @param id
   * @return brewery
   */
  Brewery findById(Integer id);
}
