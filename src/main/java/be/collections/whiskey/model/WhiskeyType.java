package be.collections.whiskey.model;


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

  Integer id;
  String description;

  @Id
  @Column(name="id")
  @SequenceGenerator(name = "sq_whiskey", sequenceName = "sq_whiskey", allocationSize = 1)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name="description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
