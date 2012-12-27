package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Brewery;
import be.collections.whiskey.service.BreweryService;
import be.collections.whiskey.service.WhiskeyTypeService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Edit Brewery page
 *
 * @Autor Bart Geluykens
 */
public class EditBrewery extends BasePage {
  /**
   * Brewery service
   */
  @SpringBean
  BreweryService breweryService;
  /**
   * Default constructor for adding a brewery
   */
  public EditBrewery() {
    this(new Brewery());

  }
  /**
   * Constructor for editing a brewery
   *
   * @param brewery the brewery to edit
   */
  public EditBrewery(Brewery brewery) {
    super();

    Form breweryForm = new Form("breweryForm");

    breweryForm.setModel(new CompoundPropertyModel(brewery));

    breweryForm.add(new TextField<String>("name").setRequired(true));
    breweryForm.add(new TextField<String>("location"));


    Button submitButton = new Button("submitButton") {
           @Override
           public void onSubmit() {
             breweryService.save((Brewery) this.getForm().getModel().getObject());
             setResponsePage(HomePage.class);
           }
       };
    breweryForm.add(submitButton);

    add(breweryForm);
  }
}
