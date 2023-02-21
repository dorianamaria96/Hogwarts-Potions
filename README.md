# Hogwarts Potion - Spring Boot Backend Application

We've been helping the wizards at Hogwarts in the first sprint (Check out my Hogwarts-Houses repo). It is time to spare parchments and digitize all the paperwork about persisting data by building a database. Also, the Student on Potions class could use some help, so let's see if we can lend a hand!

## What are we going to cover in this project?
- **Spring data**
- **Spring data queries**
- **Spring database connection**
- **Spring JPA repositories**

## Getting Started
To get started with this project, you will need to have the following tools installed on your local machine:

- Java 11 or higher
- Apache Maven
- H2 database

## About this project 
The tasks for this project were assigned as part of my Codecool course. The project involves developing a Spring Boot backend application for managing information about magical potions in the Wizarding World. The tasks for the project include implementing Spring Data, Spring Data Queries, Spring database connection, and Spring JPA repositories, as well as creating RESTful API endpoints for managing the potions.

### Here's a list of the given tasks:

1. The Student class is an Entity.

2. There is a JpaRepository interface dedicated to Student entities, which can persist Student objects by their Long IDs.
3. The Room class is an Entity.

4. There is a JpaRepository interface dedicated to Room entities, which can persist Room objects by their Long IDs.
5. Endpoints for creating, finding, deleting, updating, finding available rooms, or finding rooms for rat owners create the same response as with the PostgreSQL database.

6. The Ingredient class is an Entity.

7. There is a JpaRepository interface dedicated to the Ingredient entities, which can persist Ingredient objects by their Long IDs.

8. The Recipe class is an Entity.

9. There is a JpaRepository interface dedicated to the Recipe entities, which can persist Recipe objects by their Long IDs.

10. Potions are persisted in the database. At /potions all existing potions are listed.

11. There is an endpoint at /potions, where a Student can brew the Potion by sending a POST request.

12. The list of Ingredients is checked if it matches any Potion.

13. If the brew is a discovery, the Recipe is persisted with the list of Ingredients, the Student, and with a name generated from the Student's name (e.g. "John Doe's discovery #2"). The response contains the persisted Potion.

14. At /potions/{student-id}, all known Potions of a Student are listed.

15. By sending a POST request to /potions/brew a new Potion is generated containing the Student and the status of brewing.

16. By sending a PUT request to /potions/{potion-id}/add the Potion with the potion-id gets updated with the new Ingredient. The response contains the updated Potion object.


## Acknowledgements
This project was created as part of my learning journey to become a better Spring developer. Special thanks to J.K. Rowling for creating the magical world of Harry Potter.
