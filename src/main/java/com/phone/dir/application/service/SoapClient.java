package com.phone.dir.application.service;

import com.phone.dir.application.contact_registry_apis_soap.Contact;

import java.util.List;

public interface SoapClient {
    public List<Contact> getAllContactsByOrgName(String orgName);
}
