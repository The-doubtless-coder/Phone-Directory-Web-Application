
package com.phone.dir.application.contact_registry_apis_soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the contact.registry.webservice.contact_registry_apis_soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ContactListResponse_QNAME = new QName("http://contact_registry_apis_soap.webservice.registry.contact/", "ContactListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: contact.registry.webservice.contact_registry_apis_soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ContactListResponse }
     * 
     */
    public ContactListResponse createContactListResponse() {
        return new ContactListResponse();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContactListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://contact_registry_apis_soap.webservice.registry.contact/", name = "ContactListResponse")
    public JAXBElement<ContactListResponse> createContactListResponse(ContactListResponse value) {
        return new JAXBElement<ContactListResponse>(_ContactListResponse_QNAME, ContactListResponse.class, null, value);
    }

}
