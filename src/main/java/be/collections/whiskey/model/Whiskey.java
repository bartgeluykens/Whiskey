package be.collections.whiskey.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/9/12
 */
@Entity
@Table(name = "Whiskey")
public class Whiskey implements Serializable {

  Integer Id;
  String  name;
  Brewery brewery;
  WhiskeyType whiskeyType;
  String remarks;
  String description;


  @Id
  @Column(name ="id")
  @SequenceGenerator(name = "sq_whiskey", sequenceName = "sq_whiskey", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_whiskey")
  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  @Column(name="name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn(name="brewery_id")
  public Brewery getBrewery() {
    return brewery;
  }

  public void setBrewery(Brewery brewery) {
    this.brewery = brewery;
  }

  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn(name = "type_whiskey_id")
  public WhiskeyType getWhiskeyType() {
    return whiskeyType;
  }

  public void setWhiskeyType(WhiskeyType whiskeyType) {
    this.whiskeyType = whiskeyType;
  }

  @Column (name="remarks")
  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  @Column (name="description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
