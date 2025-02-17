package com.phone.dir.application.service.Impl;

import com.phone.dir.application.contact_registry_apis_soap.Contact;
import com.phone.dir.application.contact_registry_apis_soap.ContactListResponse;
import com.phone.dir.application.contact_registry_apis_soap.ContactsWebService;
import com.phone.dir.application.contact_registry_apis_soap.ContactsWebServiceService;
import com.phone.dir.application.service.SoapClient;

import java.util.List;

public class SoapClientImpl implements SoapClient {

    private final ContactsWebServiceService contactsWebService = new ContactsWebServiceService();

    @Override
    public List<Contact> getAllContactsByOrgName(String orgName) {

        ContactsWebService contactsWebServicePort = contactsWebService.getContactsWebServicePort();
        ContactListResponse contactsByOrganizationName = contactsWebServicePort.getContactsByOrganizationName(orgName);
        if(contactsByOrganizationName.isIsSuccessful() && contactsByOrganizationName.getMessage()
                .equalsIgnoreCase("Transaction completed successfully")) {
            return contactsByOrganizationName.getContact();
        }else return null;
    }
}
