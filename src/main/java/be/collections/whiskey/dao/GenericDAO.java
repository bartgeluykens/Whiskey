package be.collections.whiskey.dao;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
public interface GenericDAO<T> {

	public T save(T object);

	public void evict(T object);

	public T get(Long id);

  public void remove (T object);


}
