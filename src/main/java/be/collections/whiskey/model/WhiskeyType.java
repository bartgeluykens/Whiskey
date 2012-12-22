package be.collections.whiskey.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/9/12
 */

@Entity
@Table(name = "type_whiskey")
public class WhiskeyType implements Serializable {

  @Id
  @Getter
  @Setter
  @Column(name="id")
  @SequenceGenerator(name = "sq_whiskey", sequenceName = "sq_whiskey", allocationSize = 1)
  Integer id;

  @Getter
  @Setter
  @Column(name="description")
  String description;

}
