package com.mozanta.store.organization;



import com.mozanta.store.entity.Organization;

public interface OrganizationService {
	
	void registerOrganization(final Organization organization);
	void registerManufactures(final Organization organization);

}
