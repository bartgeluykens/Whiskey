package be.collections.whiskey.service;

import be.collections.whiskey.model.Whiskey;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
public interface WhiskeyService {
   public List<Whiskey> findAll();
   public void save(Whiskey whiskey);
   public void remove(Whiskey whiskey);
}
