package be.collections.whiskey.service;

import be.collections.whiskey.model.Brewery;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
public interface BreweryService {
  List<Brewery> findAll();
  public Brewery save(Brewery brewery);
}
