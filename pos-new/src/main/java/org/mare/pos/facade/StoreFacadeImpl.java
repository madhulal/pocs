package org.mare.pos.facade;

import org.mare.pos.domain.Organization;
import org.mare.pos.domain.Store;
import org.mare.pos.form.StoreCreateForm;
import org.mare.pos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
@Service
public class StoreFacadeImpl implements StoreFacade {

    private StoreService service;

    @Autowired
    public StoreFacadeImpl(StoreService service) {
        this.service = service;
    }

    @Override
    public List<Store> getAllStores() {
        return service.getAll();
    }

    @Override
    public Store create(StoreCreateForm form, Organization organization) {
        return service.create(form, organization);
    }
}
