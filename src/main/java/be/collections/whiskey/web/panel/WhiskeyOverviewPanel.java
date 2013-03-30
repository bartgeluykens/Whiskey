package be.collections.whiskey.web.panel;

import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.web.page.DetailsPage;
import be.collections.whiskey.web.page.EditBrewery;
import be.collections.whiskey.web.page.EditWhiskey;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 3/30/13
 */
public class WhiskeyOverviewPanel extends Panel {

  public WhiskeyOverviewPanel(final String id, List<Whiskey> whiskeyList) {

    super(id);

    add(new DataView<Whiskey>("whiskey-table", new ListDataProvider(whiskeyList))
    {
        private static final long serialVersionUID = 1L;

      @Override
       protected void populateItem(final Item<Whiskey> item)
       {
           Whiskey whiskey = item.getModelObject();

           item.add(new Link<Void>("whiskey-details") {
              @Override
               public void onClick() {
                 setResponsePage(new DetailsPage(item.getModelObject()));
              }
            });

           item.add(new Link<Void>("whiskey-edit") {
              @Override
               public void onClick() {
                 setResponsePage(new EditWhiskey(item.getModelObject()));
              }
            });


         item.add(new Link<Void>("brewery-edit") {
            @Override
             public void onClick() {
               setResponsePage(new EditBrewery(item.getModelObject().getBrewery()));
            }
          });

         item.add(new Label("whiskey", whiskey.getName()));
         item.add(new Label("brewery", whiskey.getBrewery().getName()));
         item.add(new Label("type"   , whiskey.getWhiskeyType().getDescription()));
         item.add(new Label("remarks", whiskey.getRemarks()));

       }

    });
  }
}
