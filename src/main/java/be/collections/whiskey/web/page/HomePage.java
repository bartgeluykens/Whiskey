package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.service.BreweryService;
import be.collections.whiskey.service.WhiskeyService;
import be.collections.whiskey.web.panel.WhiskeyOverviewPanel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.ComponentModel;
import org.apache.wicket.model.Model;
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
