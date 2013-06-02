package be.collections.whiskey.web.model;

import be.collections.whiskey.model.Whiskey;
import be.collections.whiskey.service.GenericService;
import junit.framework.Assert;
import org.junit.Test;

public class LoadableWhiskeyModelTest extends Assert {

    @Test
    public void whenIdIsNullThenReturnEmptyObject() {
        DummyService genericService = new DummyService();
        LoadableWhiskeyModel<Whiskey> loadableWhiskeyModel = new LoadableWhiskeyModel<Whiskey>(null, genericService, Whiskey.class);
        Whiskey whiskey = (Whiskey)loadableWhiskeyModel.getObject();
        assertNotNull(whiskey);
        assertNull(whiskey.getId());
    }

    @Test
    public void whenIdIsNotNullThenReturnObject() {
        DummyService genericService = new DummyService();
        LoadableWhiskeyModel<Whiskey> loadableWhiskeyModel = new LoadableWhiskeyModel<Whiskey>(1, genericService, Whiskey.class);
        Whiskey whiskey = (Whiskey)loadableWhiskeyModel.getObject();
        assertNotNull(whiskey);
        assertEquals(new Integer(1),whiskey.getId());
    }


    private class DummyService implements GenericService<Whiskey> {

        @Override
        public Whiskey get(Integer id) {
              Whiskey whiskey = new Whiskey();
              whiskey.setId(id);
              return whiskey;
        }
    }
}
