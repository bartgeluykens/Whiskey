package be.collections.whiskey.dto;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.WhiskeyType;
import lombok.Getter;
import lombok.Setter;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 3/30/13
 */
public class SearchWhiskeyDto {

  @Getter
  @Setter
  String whiskeyName;

  @Getter
  @Setter
  Brewery brewery;

  @Getter
  @Setter
  WhiskeyType whiskeyType;

  public boolean hasCriteria() {
    return ( ( whiskeyName != null )
           || ( (brewery != null) && (brewery.getId() != null))
           || ((whiskeyType != null) && (whiskeyType.getId() != null)));
  }
}
