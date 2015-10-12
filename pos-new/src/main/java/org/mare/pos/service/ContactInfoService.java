package org.mare.pos.service;

import org.mare.pos.domain.ContactInfo;
import org.mare.pos.form.ContactInfoForm;

/**
 * Created by Madhulal M G on 11/10/15.
 */
public interface ContactInfoService {
    ContactInfo create(ContactInfoForm contactInfo);
}
