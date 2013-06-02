package be.collections.whiskey.web.model;

import be.collections.whiskey.service.GenericService;
import org.apache.wicket.model.LoadableDetachableModel;

public class LoadableWhiskeyModel<T>  extends LoadableDetachableModel  {

    private Integer id;
    private GenericService genericService;
    private Class<T> clazz;


    public LoadableWhiskeyModel(Integer id, GenericService genericService, Class<T> clazz) {
        this.id = id;
        this.genericService = genericService;
            this.clazz = clazz;
    }

    protected Object load() {
        if (id == null) {
            try {
               return clazz.newInstance();
            } catch (Exception ex) {
                throw new IllegalArgumentException(ex.getMessage());
            }
        }
        return genericService.get(id);
    }

}
