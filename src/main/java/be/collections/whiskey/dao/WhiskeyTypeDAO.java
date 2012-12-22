package be.collections.whiskey.dao;

import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/16/12
 */
@Repository
public interface WhiskeyTypeDAO extends GenericDAO<WhiskeyType> {
 public List<WhiskeyType> findAll();
}
