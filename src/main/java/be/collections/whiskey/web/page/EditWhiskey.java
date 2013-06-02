package be.collections.whiskey.web.page;

import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.service.BreweryService;
import be.collections.whiskey.service.GenericService;
import be.collections.whiskey.service.WhiskeyService;
import be.collections.whiskey.service.WhiskeyTypeService;
import be.collections.whiskey.web.model.LoadableWhiskeyModel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class EditWhiskey extends BasePage {
    @SpringBean
    WhiskeyTypeService whiskeyTypeService;

    @SpringBean
    BreweryService breweryService;

    @SpringBean
    WhiskeyService whiskeyService;

    Form whiskeyForm;
    FeedbackPanel feedbackPanel;

    public EditWhiskey() {
        this(new Whiskey());
    }

    public EditWhiskey(final Whiskey whiskey) {
        super();
        LoadableWhiskeyModel loadableModel = new LoadableWhiskeyModel(whiskey.getId(), (GenericService)whiskeyService, Whiskey.class);
        CompoundPropertyModel<Whiskey> model = new CompoundPropertyModel<Whiskey>(loadableModel);

        add(new Label("title", whiskey.getName()));

        whiskeyForm = new Form("whiskeyForm");
        feedbackPanel = new FeedbackPanel("feedback");
        whiskeyForm.add(feedbackPanel);

        whiskeyForm.setModel(model);

        whiskeyForm.add(new TextField<String>("name").setRequired(true));
        whiskeyForm.add(new TextField<String>("remarks"));
        whiskeyForm.add(new TextArea<String>("description"));
        whiskeyForm.add(new DropDownChoice("type"
                      , new PropertyModel(whiskeyForm.getModel(), "whiskeyType")
                      , whiskeyTypeService.findAll()
                      , new ChoiceRenderer("description", "id")
                     ).setRequired(true));
       whiskeyForm.add(new DropDownChoice("brewery"
                      , new PropertyModel(whiskeyForm.getModel(), "brewery")
                      , breweryService.findAll()
                      , new ChoiceRenderer("name", "id")
                     ).setRequired(true));
        whiskeyForm.add(new SaveButton("submitButton"));
        whiskeyForm.add(new DeleteButton("deleteButton"));

        add(whiskeyForm);
    }

    private class SaveButton extends Button {
        private SaveButton(String id) {
            super(id);
        }
        @Override
        public void onSubmit() {
            try {
                whiskeyService.save((Whiskey) whiskeyForm.getModelObject());
                setResponsePage(new HomePage());
            } catch (RuntimeException ex) {
                feedbackPanel.error(ex.getMessage());
            }

        }
    }

    private class DeleteButton extends Button {
        private DeleteButton(String id) {
            super(id);
        }
        @Override
        public void onSubmit() {
            try {
                whiskeyService.remove((Whiskey) whiskeyForm.getModelObject());
                setResponsePage(new HomePage());
            } catch (RuntimeException ex) {
                feedbackPanel.error(ex.getMessage());
            }

        }
    }


}
