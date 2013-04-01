package be.collections.whiskey.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 4/1/13
 */
public class SearchBreweryDto {

  @Getter
  @Setter
  String breweryName;

  @Getter
  @Setter
  String whiskeyName;

  public boolean hasCriteria() {
    return breweryName != null || whiskeyName != null;
  }

}
