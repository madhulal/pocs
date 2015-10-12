package org.mare.pos.facade;

import org.mare.pos.domain.Organization;
import org.mare.pos.domain.Store;
import org.mare.pos.form.StoreCreateForm;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
public interface StoreFacade {
    List<Store> getAllStores();

    Store create(StoreCreateForm form, Organization organization);
}
