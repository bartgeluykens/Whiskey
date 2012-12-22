package be.collections.whiskey.dao;

import be.collections.whiskey.model.Brewery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
@Repository
public interface BreweryDAO  extends GenericDAO<Brewery> {
  List<Brewery> findAll();
}
