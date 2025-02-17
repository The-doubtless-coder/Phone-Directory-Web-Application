package com.phone.dir.application.service;

import com.phone.dir.application.dto.ContactDTO;
import com.phone.dir.application.dto.StatusDTO;
import com.phone.dir.application.model.Contact;
import java.util.List;

public interface RestClient {
    public List<Contact> getAllContacts();
    public Contact getContactById(int id);
    public StatusDTO addContact(ContactDTO contact);
    public StatusDTO updateContact(int id, ContactDTO contact);
    public StatusDTO deleteContact(int id);
    public List<Contact> searchContactByPhoneHash(String phoneHash);
    public List<Contact> searchContactByMaskedNameMaskedPhone(String maskedName, String maskedPhone);
}
