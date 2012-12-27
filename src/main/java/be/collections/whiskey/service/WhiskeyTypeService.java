package be.collections.whiskey.service;

import be.collections.whiskey.model.WhiskeyType;

import java.util.List;

/**
 * Whiskey Type service
 *
 * @Autor Bart Geluykens
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
public interface WhiskeyTypeService {
  /**
   * List all Whiskey Types from the database
   *
   * @return all whiskey types
   */
  public List<WhiskeyType> findAll();
}
