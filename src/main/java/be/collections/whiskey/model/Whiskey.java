package be.collections.whiskey.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Whiskey Model
 *
 * @Autor bart
 */
@Entity
@Table(name = "Whiskey")
public class Whiskey implements Serializable {

  @Id
  @Getter
  @Setter
  @Column(name ="id")
  @SequenceGenerator(name = "sq_whiskey", sequenceName = "sq_whiskey", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_whiskey")
  Integer Id;

  @Getter
  @Setter
  @Column(name="name")
  String  name;

  @Getter
  @Setter
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn(name="brewery_id")
  Brewery brewery;

  @Getter
  @Setter
  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn(name = "type_whiskey_id")
  WhiskeyType whiskeyType;

  @Getter
  @Setter
  @Column (name="remarks")
  String remarks;

  @Getter
  @Setter
  @Column (name="description")
  String description;
}
