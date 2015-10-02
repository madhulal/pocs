package com.mozanta.store.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozanta.store.common.repository.OrganizationRepository;
import com.mozanta.store.entity.Organization;

@Service("OrganizationService")
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public void registerOrganization(Organization organization) {
	
		organizationRepository.save(organization);
		
	}

	@Override
	public void registerManufactures(Organization organization) {
		
		organizationRepository.save(organization);
		
	}
	
}
