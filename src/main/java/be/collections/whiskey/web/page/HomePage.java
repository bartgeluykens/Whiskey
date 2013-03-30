package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.service.WhiskeyService;
import be.collections.whiskey.web.panel.WhiskeyOverviewPanel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;


/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 12/14/12
 */
public class HomePage extends BasePage {

  @SpringBean
  WhiskeyService whiskeyService;

  public HomePage() {

    super();

    List< Whiskey > whiskeyList = whiskeyService.findAll();

    add( new WhiskeyOverviewPanel("overview-panel", whiskeyList));



  }
}
