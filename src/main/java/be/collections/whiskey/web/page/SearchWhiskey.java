package be.collections.whiskey.web.page;

import be.collections.whiskey.dto.SearchWhiskeyDto;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import be.collections.whiskey.service.BreweryService;
import be.collections.whiskey.service.WhiskeyService;
import be.collections.whiskey.service.WhiskeyTypeService;
import be.collections.whiskey.web.panel.WhiskeyOverviewPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Autor bart
 * Omschrijving:
 * Aangemaakt op: 3/30/13
 */
public class SearchWhiskey extends BasePage {
  /**
   * Whiskey type service
   */
  @SpringBean
  WhiskeyTypeService whiskeyTypeService;
  /**
   * Bewery service
   */
  @SpringBean
  BreweryService breweryService;
  /**
   * Whiskey service
   */
  @SpringBean
  WhiskeyService whiskeyService;
  /**
   * Searchform
   */
  Form searchForm;

  public SearchWhiskey() {
    super();
    init(new SearchWhiskeyDto());

  }

  public SearchWhiskey(SearchWhiskeyDto searchWhiskeyDto) {
    super();
    init(searchWhiskeyDto);

  }


  public void init(SearchWhiskeyDto searchWhiskeyDto) {

    searchForm = new Form("search-form");
    add(searchForm);
    final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
    add(feedbackPanel);

    searchForm.setModel(new CompoundPropertyModel(searchWhiskeyDto));

    searchForm.add(new TextField<String>("name", new PropertyModel<String>(searchForm.getModel(),"whiskeyName")));

    ArrayList<Integer> options = new ArrayList();
    for(WhiskeyType whiskeyType : whiskeyTypeService.findAll()) {
       options.add(whiskeyType.getId());
    }

    searchForm.add(new DropDownChoice("type"
      , new PropertyModel(searchForm.getModel(), "whiskeyType")  // new Model(whiskey.getWhiskeyType())
      , whiskeyTypeService.findAll()
      , new ChoiceRenderer("description", "id")
    ));

    searchForm.add(new DropDownChoice("brewery"
      , new PropertyModel(searchForm.getModel(), "brewery")
      , breweryService.findAll()
      , new ChoiceRenderer("name", "id")
    ));

    Button searchButton = new Button("button-search") {
           @Override
           public void onSubmit() {
             try {
               SearchWhiskeyDto searchWhiskeyDto = (SearchWhiskeyDto)searchForm.getModelObject();

               if (!searchWhiskeyDto.hasCriteria()) {
                 feedbackPanel.error("No seach criteria");
               }  else {

                 setResponsePage(new SearchWhiskey(searchWhiskeyDto));
               }

             } catch (RuntimeException ex) {
               feedbackPanel.error(ex.getMessage());
             }
           }
       };
    searchForm.add(searchButton);

    List<Whiskey> whiskeyList = whiskeyService.search(searchWhiskeyDto);

    Label noDataFoundLabel = new Label("no-data-found-container", "no data found");
    noDataFoundLabel.setVisible(whiskeyList.size() == 0);
    add(noDataFoundLabel);

    WhiskeyOverviewPanel whiskeyOverviewPanel = new WhiskeyOverviewPanel("overview-panel", whiskeyList);
    whiskeyOverviewPanel.setVisible(whiskeyList.size() > 0);
    add(whiskeyOverviewPanel);


  }
}
