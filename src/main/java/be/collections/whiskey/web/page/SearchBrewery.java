package be.collections.whiskey.web.page;

import be.collections.whiskey.dto.SearchBreweryDto;
import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.service.BreweryService;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 4/1/13
 */
public class SearchBrewery extends BasePage {

  Form searchForm;

  /**
   * Bewery service
   */
  @SpringBean
  BreweryService breweryService;

  public SearchBrewery() {
    super();
    init(new SearchBreweryDto());
  }


  public SearchBrewery(SearchBreweryDto searchBreweryDto) {
    super();
    init(searchBreweryDto);
  }


  private void init(SearchBreweryDto searchBreweryDto) {
    searchForm = new Form("search-form");

    add(searchForm);
    final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    add(feedbackPanel);

    searchForm.setModel(new CompoundPropertyModel(searchBreweryDto));

    searchForm.add(new TextField<String>("brewery-name", new PropertyModel<String>(searchForm.getModel(),"breweryName")));
    searchForm.add(new TextField<String>("whiskey-name", new PropertyModel<String>(searchForm.getModel(),"whiskeyName")));

    Button resetButton = new Button("button-reset") {
           @Override
           public void onSubmit() {
             setResponsePage(new SearchWhiskey());
           }
       };
    searchForm.add(resetButton);

    Button searchButton = new Button("button-search") {
           @Override
           public void onSubmit() {
             try {
               SearchBreweryDto searchBrewery = (SearchBreweryDto)searchForm.getModelObject();

               if (!searchBrewery.hasCriteria()) {
                 feedbackPanel.error("No seach criteria");
               }  else {

                 setResponsePage(new SearchBrewery(searchBrewery));
               }

             } catch (RuntimeException ex) {
               feedbackPanel.error(ex.getMessage());
             }
           }

       };
    searchForm.add(searchButton);

    List<Brewery> breweryList = breweryService.search(searchBreweryDto);

    Label noDataFoundLabel = new Label("no-data-found-container", "no data found");
    noDataFoundLabel.setVisible(breweryList.size() == 0 && searchBreweryDto.hasCriteria());
    add(noDataFoundLabel);

    WebMarkupContainer resultContainer = new WebMarkupContainer("result-container");
    resultContainer.setVisible(breweryList.size() > 0);
    add(resultContainer);

    resultContainer.add(new DataView<Brewery>("brewery-table", new ListDataProvider(breweryList)) {
      private static final long serialVersionUID = 1L;

      @Override
      protected void populateItem(final Item<Brewery> item) {
        final Brewery brewery = item.getModelObject();

        item.add(new Label("name", brewery.getName()));
        item.add(new Label("location", brewery.getLocation()));

        item.add(new Link<Void>("brewery-edit") {
          @Override
          public void onClick() {
            setResponsePage(new EditBrewery(brewery));
          }
        });

      }

    });


  }


}
