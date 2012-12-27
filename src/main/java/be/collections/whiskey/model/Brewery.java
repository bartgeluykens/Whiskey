package be.collections.whiskey.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Brewery Model
 *
 * @Autor bart
 */
@Entity
@Table (name = "brewery")
public class Brewery implements Serializable {

  @Id
  @Getter
  @Setter
  @Column (name="id", unique = true, nullable = false)
  @SequenceGenerator(name = "sq_brewery", sequenceName = "sq_brewery", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_brewery")
  Integer id;

  @Getter
  @Setter
  @Column (name="name", nullable = false)
  String name;

  @Getter
  @Setter
  @Column (name="location", nullable = false)
  String location;
}
