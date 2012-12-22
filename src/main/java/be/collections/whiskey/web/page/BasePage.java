package be.collections.whiskey.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
public class BasePage extends WebPage {

  public BasePage() {

   add(new Link<Void>("add") {
      @Override
      public void onClick() {
        setResponsePage(new EditWhiskey());
      }
    });

    add(new Link<Void>("home") {
       @Override
       public void onClick() {
         setResponsePage(new HomePage());
       }
     });

    add(new Link<Void>("addBrewery") {
       @Override
       public void onClick() {
         setResponsePage(new EditBrewery());
       }
     });

  }
}
