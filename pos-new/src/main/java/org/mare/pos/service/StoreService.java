package org.mare.pos.service;

import org.mare.pos.domain.Organization;
import org.mare.pos.domain.Store;
import org.mare.pos.form.StoreCreateForm;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
public interface StoreService {
    List<Store> getAll();

    Store create(StoreCreateForm form, Organization organization);
}
