package be.collections.whiskey.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/9/12
 */
@Entity
@Table (name = "brewery")
public class Brewery implements Serializable {

  Integer id;
  String name;
  String location;

  @Id
  @Column (name="id", unique = true, nullable = false)
  @SequenceGenerator(name = "sq_brewery", sequenceName = "sq_brewery", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_brewery")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column (name="name", nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column (name="location", nullable = false)
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
