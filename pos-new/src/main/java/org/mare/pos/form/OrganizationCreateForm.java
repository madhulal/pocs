package org.mare.pos.form;

/**
 * Created by Madhulal M G on 10/10/15.
 */

import org.hibernate.validator.constraints.NotEmpty;

public class OrganizationCreateForm {

    @NotEmpty
    private String name = "";

    private String notes = "";

    private ContactInfoForm contactInfo = new ContactInfoForm();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ContactInfoForm getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoForm contactInfo) {
        this.contactInfo = contactInfo;
    }
}
