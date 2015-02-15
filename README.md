# Spring (MVC + Data) project (full java configured, without xml) 
This application shows, how to handle with spring mvc multiple buttons and checkboxes. 
Don't forget change your db properties (under src/main/resources) and add your JDBC Driver to POM  

Please, use script.sql under src/main/resources for populating some db data 

Entry point http://localhost:8080/spring-multibutton


Done:
- By page opening the table with data is filled from database
- Table contains checkboxes for every rows to provide multiple selection 
- By clicking button “refresh” the application should reload the data from DB
- By clicking button “delete” the application should delete all selected  data rows 
- By clicking button “edit” another page is opened to edit selected data
- If more than one row were selected user receives the message “please select just one row to be edited”
- If not any row is selected the edit page should be opened without button “Save” showing
- If exactly one row is selected the edit page should be opened without button “Add” showing
- Also in this application is used nice and responsive Bootstrap 3 template
 

##Technologies used

* Spring Framework 4.1.4.RELEASE
* Spring Security 4.0.0.RC1 
* Spring Data 1.7.2
* Hibernate 4.3.8.Final
* Junit 4.12, Mockito 1.10.19
* Hibernate Validator 5.1.3.Final
* Java 1.7
* Maven 
* Tomcat 7
* Servlet Api 3.0.1
* Slf4j 1.7.9
* Bootstrap 3.3.1
