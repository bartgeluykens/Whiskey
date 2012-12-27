package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.model.WhiskeyType;
import be.collections.whiskey.service.BreweryService;
import be.collections.whiskey.service.WhiskeyService;
import be.collections.whiskey.service.WhiskeyTypeService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.List;

/**
 * Edit a whiskey
 *
 * @Autor bart Geluykens
 */
public class EditWhiskey extends BasePage {
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
   * Constructor for creating a new whiskey
   */
  public EditWhiskey() {
    this(new Whiskey());
  }
  /**
   * Constructor for editing an existing whiskey

   * @param whiskey whiskey to edit
   */
  public EditWhiskey(final Whiskey whiskey) {

    super();

    add(new Label("title", whiskey.getName()));

    Form whiskeyForm = new Form("whiskeyForm");

    whiskeyForm.setModel(new CompoundPropertyModel(whiskey));

    whiskeyForm.add(new TextField<String>("name").setRequired(true));
    whiskeyForm.add(new TextField<String>("remarks"));
    whiskeyForm.add(new TextArea<String>("description"));

    List<WhiskeyType> whiskeyTypeList = whiskeyTypeService.findAll();

    /**
     * Belangrijk is dat de getId uit de whiskeyTypeList overeen komt met de getId van de getWhiskeyType
     */

    whiskeyForm.add(new DropDownChoice("type"
      , new PropertyModel(whiskeyForm.getModel(), "whiskeyType")  // new Model(whiskey.getWhiskeyType())
      , whiskeyTypeList
      , new ChoiceRenderer("description", "id")
    ).setRequired(true));


    List<Brewery> breweryList = breweryService.findAll();
    whiskeyForm.add(new DropDownChoice("brewery"
      , new PropertyModel(whiskeyForm.getModel(), "brewery")
      , breweryList
      , new ChoiceRenderer("name", "id")
    ).setRequired(true));

     Button submitButton = new Button("submitButton") {
            @Override
            public void onSubmit() {
              whiskeyService.save((Whiskey) this.getForm().getModel().getObject());
              setResponsePage(new HomePage());
            }
        };
    whiskeyForm.add(submitButton);

    Button deleteButton = new Button("deleteButton") {
           @Override
           public void onSubmit() {
             whiskeyService.remove((Whiskey) this.getForm().getModel().getObject());
             setResponsePage(new HomePage());
           }
       };
    whiskeyForm.add(deleteButton);

    add(whiskeyForm);

  }

}
