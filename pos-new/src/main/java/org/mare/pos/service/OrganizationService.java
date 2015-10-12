package org.mare.pos.service;

import org.mare.pos.domain.ContactInfo;
import org.mare.pos.domain.Organization;
import org.mare.pos.form.OrganizationCreateForm;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
public interface OrganizationService {

    List<Organization> getAllOrganizations();
    Organization create(OrganizationCreateForm form, ContactInfo contactInfo);
}
