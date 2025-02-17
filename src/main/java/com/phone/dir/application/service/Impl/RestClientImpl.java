package com.phone.dir.application.service.Impl;

import com.phone.dir.application.dto.ContactDTO;
import com.phone.dir.application.dto.StatusDTO;
import com.phone.dir.application.model.Contact;
import com.phone.dir.application.service.RestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestClientImpl implements RestClient {
    private final String BASE_URL = "https://api.phone.com/";
    private final String GET_DELETE_CONTACT_BY_ID = BASE_URL + "contacts/{id}";
    private final String GET_CONTACT_BY_ORG_NAME = BASE_URL + "contacts/{orgId}";
    private final String GET_ALL_POST_UPDATE_CONTACT = BASE_URL + "contacts";
    private final String GET_CONTACT_BY_PHONE_HASH = BASE_URL + "contacts/{id}";
    private final String GET_CONTACT_BY_MASKED_NAME_MASKED_PHONE = BASE_URL + "contacts/{phoneNumber}";

    private final Client client = ClientBuilder.newClient();

    @Override
    public List<Contact> getAllContacts() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/Contact_Registry_Web_App_war/rest/api/v1/contacts")
                .request(MediaType.APPLICATION_JSON)
                 .get();
        if (response.getStatus() == 200) {
            return Arrays.asList(response.readEntity(Contact[].class));
        } else {
            System.out.println("Failed with HTTP status: " + response.getStatus());
//            throw new Exception("msg");
            return new ArrayList<Contact>();
        }
    }

    @Override
    public Contact getContactById(int id) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/Contact_Registry_Web_App_war/rest/api/v1/contacts/" + id).
                request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
            return response.readEntity(Contact.class);
        }
        return new Contact();
    }

    @Override
    public StatusDTO addContact(ContactDTO contact) {
        System.out.println("posting this contact " + contact);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Contact_Registry_Web_App_war/rest/api/v1/contacts");
        String newJsonData = String.format(
                "{" +
                        "\"fullName\": \"%s\"," +
                        "\"phoneNumber\": \"%s\"," +
                        "\"email\": \"%s\"," +
                        "\"idNumber\": \"%s\"," +
                        "\"dob\": \"%s\"," +
                        "\"gender\": \"%s\"," +
                        "\"organization\": \"%s\"" +
                        "}",
                contact.getFullName(), contact.getPhoneNumber(),
                contact.getEmail(), contact.getIdNumber(), contact.getDob(),
                contact.getGender(), contact.getOrganization()
        );
        System.out.println(newJsonData);
        try(Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(newJsonData, MediaType.APPLICATION_JSON));){
            return response.readEntity(StatusDTO.class);
        }
    }

    @Override
    public StatusDTO updateContact(int id,ContactDTO contact) {
        System.out.println("contact update " + contact);
        Client client = ClientBuilder.newClient();
         WebTarget target = client.target("http://localhost:8080/Contact_Registry_Web_App_war/rest/api/v1/contacts/" + id);
        String updatedJsonData = String.format(
                "{" +
                        "\"fullName\": \"%s\"," +
                        "\"phoneNumber\": \"%s\"," +
                        "\"email\": \"%s\"," +
                        "\"idNumber\": \"%s\"," +
                        "\"dob\": \"%s\"," +
                        "\"gender\": \"%s\"," +
                        "\"organization\": \"%s\"" +
                        "}",
                contact.getFullName(), contact.getPhoneNumber(),
                contact.getEmail(), contact.getIdNumber(), contact.getDob(),
                contact.getGender(), contact.getOrganization()
        );
        Response response = target.request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(updatedJsonData, MediaType.APPLICATION_JSON));
        if(response.getStatus() == 200) {
            return response.readEntity(StatusDTO.class);
        }else {
            return response.readEntity(StatusDTO.class);
        }
    }

    @Override
    public StatusDTO deleteContact(int id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Contact_Registry_Web_App_war/rest/api/v1/contacts/" + id);
        try(Response response = target.request().delete();) {
            if(response.getStatus() == 200) {
                return response.readEntity(StatusDTO.class);
            }else return response.readEntity(StatusDTO.class);
        }
    }

    @Override
    public List<Contact> searchContactByPhoneHash(String phoneHash) {
        // Create a JAX-RS Client
        Client client = ClientBuilder.newClient();
        // Define the base URL and add query parameters
        WebTarget target = client.target("https://jsonplaceholder.typicode.com/posts")
                        .queryParam("phoneHash", phoneHash);
        // Make the GET request with query parameters
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        // Process the response
        if (response.getStatus() == 200) {
            Contact[] jsonResponse = response.readEntity(Contact[].class);
            System.out.println("Response: " + jsonResponse);
        } else {
            System.out.println("Failed with HTTP status: " + response.getStatus());
        }
        // Close the client
        client.close();
        return null;
    }

    @Override
    public List<Contact> searchContactByMaskedNameMaskedPhone(String maskedName, String maskedPhone) {
        // Create a JAX-RS Client
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://jsonplaceholder.typicode.com/posts")
                .queryParam("maskedName", maskedName)
                .queryParam("maskedPhone", maskedPhone);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        // Process the response
        if (response.getStatus() == 200) {
            Contact[] jsonResponse = response.readEntity(Contact[].class);
            System.out.println("Response: " + jsonResponse);
        } else {
            System.out.println("Failed with HTTP status: " + response.getStatus());
        }
        // Close the client
        client.close();
        return null;
    }
}
