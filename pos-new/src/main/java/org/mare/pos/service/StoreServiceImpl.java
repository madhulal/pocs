package org.mare.pos.service;

import org.mare.pos.domain.Organization;
import org.mare.pos.domain.Store;
import org.mare.pos.form.StoreCreateForm;
import org.mare.pos.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
@Service
public class StoreServiceImpl implements StoreService {

    protected StoreRepository repository;

    @Autowired
    public StoreServiceImpl(StoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Store> getAll() {
        return repository.findAll();
    }

    @Override
    public Store create(StoreCreateForm form, Organization organization) {
        final Store store= new Store();
        store.setName(form.getName());
        store.setNotes(form.getNotes());
        store.setOrganization(organization);
        return repository.save(store);
    }
}
