package org.mare.pos.service;

import org.mare.pos.domain.ContactInfo;
import org.mare.pos.domain.Organization;
import org.mare.pos.form.OrganizationCreateForm;
import org.mare.pos.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    private final OrganizationRepository repository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Organization> getAllOrganizations() {
        return repository.findAll();
    }

    @Override
    public Organization create(OrganizationCreateForm form, ContactInfo contactInfo) {
        final Organization organization= new Organization();
        organization.setName(form.getName());
        organization.setNotes(form.getNotes());
        organization.setContactInfo(contactInfo);
        return repository.save(organization);
    }
}
