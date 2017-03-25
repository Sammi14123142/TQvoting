# TalentQuestVotingApp

The goal of this application is to save calculation and ranking process during a talent show I organized at student hall with 71 participants and 193 audiences.

MySQL v5.6.34 will be used for the database and Tomcat v8.5 as the web application container.

## Features:
1. EclipseLink (JPA)

Persistence.xml specifies database configurations
Entity: Applicant
Persistence.createEntityManagerFactory creates an instance of EntityManagerFactory.
EntityManagerFactory creates an instance of EntityManager 
EntityManagerFactory creates EntityManager. The EntityManager APIs perform queries and CRUD operations on entities. Java Query Language (JQL) is used.

2. JSF

Facelets tags work together with JSF Core and JSF HTML tag libraries.
Templating files, BasicTemplate.xhtml and header.xhtml are located inside WEB-INF/templates which is not publicly accessible. 
Composition pages are located in WebContent.
The web.xml web descriptor specifies the Faces servlet and its servlet mappings.

3. Ajax Validation

Scores of each applicant consist of three parts, 
Techniques in Performance (45 marks)
Expressivity and Personality/Teamwork (35 marks)
Stage Presence (20 marks)
Immediate validation is executed while entering scores.

4. RichFaces

* Client side validation using <rich:validator /> etc.
* rich:panel is used to display performers information.

5. Unit test

JUnit is used. Each unit test is meant to test a method in a class.
