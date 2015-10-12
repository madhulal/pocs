package org.mare.pos.facade;

import org.mare.pos.domain.Organization;
import org.mare.pos.form.OrganizationCreateForm;
import org.mare.pos.service.ContactInfoService;
import org.mare.pos.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
@Service
public class OrganizationFacadeImpl implements OrganizationFacade{

    protected OrganizationService service;

    protected ContactInfoService contactInfoservice;

    @Autowired
    public OrganizationFacadeImpl(OrganizationService service, ContactInfoService contactInfoService) {
        this.service = service;
        this.contactInfoservice=contactInfoService;
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return service.getAllOrganizations();
    }

    @Override
    public Organization create(OrganizationCreateForm form) {
        return service.create(form, contactInfoservice.create(form.getContactInfo()));
    }
}
