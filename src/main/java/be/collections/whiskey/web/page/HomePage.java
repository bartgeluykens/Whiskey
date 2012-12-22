package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.service.BreweryService;
import be.collections.whiskey.service.WhiskeyService;
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

    add(new DataView<Whiskey>("simple", new ListDataProvider(whiskeyList))
    {
        private static final long serialVersionUID = 1L;

      @Override
       protected void populateItem(final Item<Whiskey> item)
       {
           Whiskey whiskey = item.getModelObject();

           item.add(new Link<Void>("details") {
              @Override
               public void onClick() {
                 setResponsePage(new DetailsPage(item.getModelObject()));
              }
            });

           item.add(new Link<Void>("editDetails") {
              @Override
               public void onClick() {
                 setResponsePage(new EditWhiskey(item.getModelObject()));
              }
            });


         item.add(new Link<Void>("editBrewery") {
            @Override
             public void onClick() {
               setResponsePage(new EditBrewery(item.getModelObject().getBrewery()));
            }
          });



           item.add(new Label("whiskey", whiskey.getName()));
           item.add(new Label("brewery", whiskey.getBrewery().getName()));
           item.add(new Label("type"   , whiskey.getWhiskeyType().getDescription()));
           item.add(new Label("remarks", whiskey.getRemarks()));

           item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>() {
                private static final long serialVersionUID = 1L;

                  @Override
                  public String getObject() {
                    return (item.getIndex() % 2 == 1) ? "even" : "odd";
                  }
           }));



       }

    });

  }
}
