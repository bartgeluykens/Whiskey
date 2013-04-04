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
   add(new Link<Void>("add-whiskey") {
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
     * search link
     */
    add(new Link<Void>("search-whiskey") {
       @Override
       public void onClick() {
         setResponsePage(new SearchWhiskey());
       }
     });
    /**
     * Add brewery link
     */
    add(new Link<Void>("add-brewery") {
       @Override
       public void onClick() {
         setResponsePage(new EditBrewery());
       }
     });
    /**
     * Add Search brewery link
     */
    add(new Link<Void>("search-brewery") {
       @Override
       public void onClick() {
         setResponsePage(new SearchBrewery());
       }
     });

  }
}
