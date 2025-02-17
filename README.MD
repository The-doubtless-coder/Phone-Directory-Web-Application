📘 Phone Directory Web Application
A web-based Phone Directory built with JSPs and Servlets that consumes the CRUD APIs and SOAP API from the ContactsCatalog Backend project.

📌 Features
✅ Create Contacts using the ContactsCatalog API
✅ Get All Contacts and display them in a table
✅ Edit Contact Details
✅ Delete Contacts
✅ SOAP Integration: Query contacts using the organization name
✅ Consumes REST (JAX-RS) and SOAP (JAX-WS) APIs

🛠️ Tech Stack
Java (JDK 11/17)
JSP & Servlets (Frontend & Business Logic)
JAX-RS (REST API Client)
JAX-WS (SOAP Client)
Tomcat (or any servlet container)

🚀 Running the Project
🔧 Prerequisites
Java 11+
Apache Tomcat
A running ContactsCatalog Backend (Ensure the backend is running before starting this project)
💻 Setup & Run
Clone the repository

bash
Copy
Edit
git clone https://github.com/The-doubtless-coder/Phone-Directory-Web-Application.git
cd PhoneDirectory-WebApp
Configure API URLs

Open web.xml or config.properties and update the ContactsCatalog API endpoints:
properties
Copy
Edit
api.base.url=http://localhost:8080/Contact_Registry_Web_App_war/rest/api/v1/contacts
soap.service.url=http://localhost:8080/Contact_Registry_Web_App_war/ws/contacts?wsdl
Build & Deploy the WebApp

bash
Copy
Edit
mvn clean install
Run on Tomcat

Copy the PhoneDirectory-WebApp.war file to Tomcat’s webapps/ folder
Start Tomcat and open the app in your browser
Access the Application:

url
Copy
Edit
http://localhost:8081/PhoneDirectory-WebApp
🌐 Web Application Pages
Page	URL	Description
Home	/ContactList.jsp	Landing page
View Contacts	/list	List all contacts
Create Contact	/new	Form to create a new contact
Edit Contact	/edit	Edit contact details
Search by Org	/byorgname	SOAP API-based contact search
📡 API Integration
🟢 REST API (JAX-RS) Consumption
GET /rest/api/v1/contacts → Fetches all contacts
POST /rest/api/v1/contacts → Adds a new contact
PUT /rest/api/v1/contacts/{id} → Updates contact
DELETE /rest/api/contacts/{id} → Deletes contact
🟣 SOAP API (JAX-WS) Consumption
getContactsByOrganization(String orgName) → Fetches contacts for an organization
💡 How It Works
The web application interacts with the backend through rest calls and servlets.
JSP pages use JSTL and EL (${} syntax) to display dynamic content.
Form submissions are handled via HttpServlets that call the REST and SOAP APIs.
📄 License
MIT License (or your preferred license)