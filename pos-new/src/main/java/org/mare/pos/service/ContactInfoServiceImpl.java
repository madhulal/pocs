package org.mare.pos.service;

import org.mare.pos.domain.ContactInfo;
import org.mare.pos.form.ContactInfoForm;
import org.mare.pos.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Madhulal M G on 11/10/15.
 */
@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    protected ContactInfoRepository repository;

    @Autowired
    public ContactInfoServiceImpl(ContactInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ContactInfo create(ContactInfoForm contactInfo) {
        ContactInfo contactInfoEntity = new ContactInfo();
        contactInfoEntity.setAddress(contactInfo.getAddress());
        contactInfoEntity.setCity(contactInfo.getCity());
        contactInfoEntity.setState(contactInfo.getState());
        contactInfoEntity.setCountry(contactInfo.getCountry());
        contactInfoEntity.setPin(contactInfo.getPin());
        contactInfoEntity.setContactNumber(contactInfo.getContactNumber());
        contactInfoEntity.setMobileNumber(contactInfo.getMobileNumber());
        contactInfoEntity.setEmail(contactInfo.getEmail());
        contactInfoEntity.setWeb(contactInfo.getWeb());
        return repository.save(contactInfoEntity);
    }
}
