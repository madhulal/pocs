package com.mozanta.store.manufactures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mozanta.store.common.repository.ManufacturesRepository;
import com.mozanta.store.common.repository.OrganizationRepository;
import com.mozanta.store.entity.Manufactures;

@Service("ManufacturesService")
public class ManufacturesServiceImpl implements ManufacturesService{
	
	@Autowired
	ManufacturesRepository manufacturesRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;


	@Override
	public void registerManufactures(Manufactures manufactures) {
		
		manufacturesRepository.save(manufactures);
		
		
	}

}
