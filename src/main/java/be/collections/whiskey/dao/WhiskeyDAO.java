package be.collections.whiskey.dao;

import be.collections.whiskey.model.Whiskey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
@Repository
public interface WhiskeyDAO extends GenericDAO<Whiskey> {
  public List <Whiskey> findAll();
}
