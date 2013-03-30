package be.collections.whiskey.dao;

/**
 * Generic functions for data acces objects
 * @Autor Bart Geluykens
 */
@SuppressWarnings("PMD.UnusedModifier")
public interface GenericDAO<T> {
  /**
   * Save the object
   *
   * @param object object to save
   * @return  saved object
   */
	public T save(T object);
  /**
   * Remove the object from the memory
   *
   * @param object object to remove
   *
   */
	public void evict(T object);
  /**
   * Get object by id
   * @param id
   * @return retrieved object
   */
	public T get(Integer id);

  /**
   * Remove object from the database
   *
   * @param object Object to remove
   */
  public void remove (T object);


}
