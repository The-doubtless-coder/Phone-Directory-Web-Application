package com.phone.dir.application.controller;


import com.phone.dir.application.dto.ContactDTO;
import com.phone.dir.application.dto.StatusDTO;
import com.phone.dir.application.model.Contact;
//import com.phone.dir.application.service.Impl.RestClientImpl;
import com.phone.dir.application.service.Impl.RestClientImpl;
import com.phone.dir.application.service.Impl.SoapClientImpl;
import com.phone.dir.application.service.RestClient;
import com.phone.dir.application.service.SoapClient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author kishan
 */
public class ContactControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RestClient restClient  =new RestClientImpl();
    private final SoapClient soapClient  =new SoapClientImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
//                case "/":
//                    listContacts(request, response);
//                    break;
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertContact(request, response);
                    break;
                case "/delete":
                    deleteContact(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/byorgname":
                    listContactsByOrgName(request, response);
                    break;
                case "/listbyorg":
                    showOrgNameForm(request, response);
                    break;
                case "/update":
                    try {
                        updateContact(request, response);
                    } catch (Exception e) {
                        request.setAttribute("errorMessage", e.getMessage());
                        RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
                        dispatcher.forward(request, response);
                    }
                break;
                default:
                    listContacts(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listContacts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Contact> contactList = restClient.getAllContacts();
        request.setAttribute("listContact", contactList);
        System.out.println("List is " + contactList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ContactList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ContactForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showOrgNameForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrgNameForm.jsp");
        request.setAttribute("value", "orgName");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact existingContact = restClient.getContactById(id);
        System.out.println("contact is " + existingContact);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ContactForm.jsp");
        request.setAttribute("contact", existingContact);
        dispatcher.forward(request, response);

    }

    private void insertContact(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String fullNames = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String idNumber = request.getParameter("idNumber");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String organization = request.getParameter("organization");

        ContactDTO newContact = new ContactDTO();
        newContact.setFullName(fullNames);
        newContact.setPhoneNumber(phoneNumber);
        newContact.setEmail(email);
        newContact.setIdNumber(idNumber);
        newContact.setDob(dob);
        newContact.setGender(gender);
        newContact.setOrganization(organization);

        StatusDTO statusDTO = restClient.addContact(newContact);
        System.out.println("status at insert " + statusDTO);
        if (statusDTO.getStatusCode() != 200) {
            request.setAttribute("errorMessage", statusDTO.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
        }else response.sendRedirect("list");
    }

    private void updateContact(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullNames = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String idNumber = request.getParameter("idNumber");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String organization = request.getParameter("organization");

        ContactDTO contact = new ContactDTO();
        contact.setFullName(fullNames);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        contact.setIdNumber(idNumber);
        contact.setDob(dob);
        contact.setGender(gender);
        contact.setOrganization(organization);
        StatusDTO statusDTO = restClient.updateContact(id, contact);
        System.out.println("update status is " + statusDTO);
        if(statusDTO.getStatusCode() !=200) {
            throw new Exception(statusDTO.getMessage());
        }
        response.sendRedirect("list");
    }

    private void deleteContact(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        StatusDTO statusDTO = restClient.deleteContact(id);
        if(statusDTO.getStatusCode() !=200) {
            request.setAttribute("errorMessage", statusDTO.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
        }
        response.sendRedirect("list");
    }

    private void listContactsByOrgName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String orgName = request.getParameter("orgName");
        List<com.phone.dir.application.contact_registry_apis_soap.Contact> allContactsByOrgName = soapClient.getAllContactsByOrgName(orgName);
        if(allContactsByOrgName != null) {
            request.setAttribute("listContact", allContactsByOrgName);
            System.out.println("List by org name is " + allContactsByOrgName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListByOrgName.jsp");
            dispatcher.forward(request, response);
        }else {
            request.setAttribute("errorMessage", "No contacts found for given organization");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
        }

    }

}

