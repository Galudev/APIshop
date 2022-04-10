# APIshop

For execute the API you need execute APIShop.jar file, or use Docker for get an image.

For use the API, you need charge the url "http://localhost:8080/api/shop/customers/". The API contains the attributes name, surname, email and birthdate for each customer, and have this capabilities:

* Create a new customer: Use POST and one value for each attribute, if you do not send a value for an attribute, this is create how empty value (for example 

{

    {"name": "Juan",
    "surname": "Vals",
    "email": "juanvals@gmail.com",
    "birthdate": "05-03-1997"}

}).

* Get a single customer: Use GET and add at the last of url the id for customer that you want get (for example "http://localhost:8080/api/shop/customers/1".
* Get all customers: Use GET to get a list of customers.
* Update a customer: Use PUT and one value for each attribute, included the id of the customer that you want update (for example 

{
    
    {"name": "Juan",
    "surname": "Vals",
    "email": "juanv@gmail.com",
    "birthdate": "05-03-1997",
    "id": 1}

}).


* Delete an existing customer: Use DELETE and add at the last of url the id for customer that you want delete (for example "http://localhost:8080/api/shop/customers/1".

## My problems while doing the project

At the first moment, when I had a basic API, I tried to run it, but a problen with Java appeared, I tried to solve this error installing new versions of java, changing the java version in all the project in IntelliJ IDEA... but nothing of this solved the problem. Finally, I downloaded a new SpringBoot project and replicated the first steps, at the same way, and when I runed it, there was no problem with Java this time. Is for this that a needed to create a new repository on Saturday 9th of april, but in the new repository I replicate the same steps than in the previous repository.

Another problem that I found it is build a image with Docker, an error that I can not solve it appear. This error say that Docker does not have access to the jar file, but the root of these file is correct and it is not in the .dockerignore.

## My experience

I used an API in a previous project in Android using Retrofit, but this is my first experience build an API and working with SpringBoot and IntelliJ IDEA, as well as applicating a SOLID concepts in a project.

I have used differents interfaces for different parts in the project. An for the Service, used to save, get and delete the data of the repository, and other for the Controller, that provide the cominucation with the HTTP request used by the final user of the API and the web. Besides, the communication between both classes is carried out through the interfaces.

Other experience new for me is the Unit Test. In this project, I have done test for a few capabilities, but I could not do it for update and delete, despite of I tried with different codes and comprovations.
