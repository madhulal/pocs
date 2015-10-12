package org.mare.pos.facade;

import org.mare.pos.domain.Organization;
import org.mare.pos.form.OrganizationCreateForm;

import java.util.List;

/**
 * Created by Madhulal M G on 11/10/15.
 */
public interface OrganizationFacade {
    List<Organization> getAllOrganizations();

    Organization create(OrganizationCreateForm form);
}
