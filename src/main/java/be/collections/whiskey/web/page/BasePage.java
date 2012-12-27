package be.collections.whiskey.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 *
 * Basic Page
 *
 * @Autor Bart Geluykens
 */
public class BasePage extends WebPage {

  public BasePage() {
    /**
     * Link for adding a whiskey
     */
   add(new Link<Void>("add") {
      @Override
      public void onClick() {
        setResponsePage(new EditWhiskey());
      }
    });
    /**
     * Link for the home-page
     */
    add(new Link<Void>("home") {
       @Override
       public void onClick() {
         setResponsePage(new HomePage());
       }
     });
    /**
     * Add brewery link
     */
    add(new Link<Void>("addBrewery") {
       @Override
       public void onClick() {
         setResponsePage(new EditBrewery());
       }
     });

  }
}
