package com.mozanta.store.vendors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozanta.store.common.repository.VendorsRepository;
import com.mozanta.store.entity.Vendors;
@Service("VendorsService")
public class VendorsServiceImpl implements VendorsService{
	
	@Autowired
	VendorsRepository vendorsRepository;

	@Override
	public void registerVendors(Vendors vendors) {
		vendorsRepository.save(vendors);
		
	}

}
