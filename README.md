# CrimeAppAngularJaxRs
Full Stack Web App Angular and Jax-Rs

Tools Used:

WebStorm for Angular JS 

Eclipse for Java Restful WebServices 

Maven to build the project and Jersey2 library for Jax-RS dependencies.

MySql - Database


Scope of the System:

Database:
As of now I have only one table: 'Crime' with 4 columns namely id(PK,NN), crimeRegion, crimeType, suspectDetials.

Goal of the project is to build an End-End Web Application which can save and retrieve the data, I'm using a single table as of now called 'Crime' which lets the user to see currently reported crimes and also allow them to add a new crime. 

Front End:
I'm writing the UI in AngularJS and using $http of angular to make a Rest call to the backend webservice. As of now I'm deploying the UI code on WebStorm default port.

BackEnd:
I'm using Jersey 2 with Jax-Rs to write the Restful WebService and using jdbc to connect to MySql

As I'm deploying UI and Jax-Rs on different servers, I'm writing a CORS filter to allow cross domain resource sharing between angular and Jax-Rs.












