package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Whiskey;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/15/12
 */
public class DetailsPage extends BasePage {

  public DetailsPage(final Whiskey whiskey) {

    super();

    add(new Label("title", whiskey.getName()));

    add(new Label("name",    whiskey.getName()));
    add(new Label("type",    whiskey.getWhiskeyType().getDescription()));
    add(new Label("brewery", whiskey.getBrewery().getName()));
    add(new Label("remarks", whiskey.getRemarks()));
    add(new Label("description", whiskey.getDescription()));

    add(new Link<Void>("edit") {
      @Override
      public void onClick() {
        setResponsePage(new EditWhiskey((whiskey)));
      }
    });

  }
}
