**Project Description**

- This project consist of functional automated test cases for CRUD operation of json place api using REST Assured.
- Details of json place api have been referred from here:- https://jsonplaceholder.typicode.com


**Test Scenarios**

- createJsonPlaceApi (Test Case 1) - Happy scenario for POST operation - Creating a JSON Place post service.
- getPersonWithUsername (Test Case 2) - Happy scenario for GET operation - Reading a specific user with correct username.
- getPostsByUserId (Test Case 3) - Happy scenario for GET operation - Reading a specific posts from user.
- getUserCommentsFromPosts (Test Case 4) - Happy scenario for GET operation - Reading comments from a post by user.
- getPersonWithWrongUsername (Test Case 5) - Error scenario for GET operation - Reading a specific user with wrong username.
- updateNewPosts (Test Case 6) - Happy scenario for PUT operation - Updating posts body for specific post created by user earlier.
- deletePosts (Test Case 7) - Happy scenario for DELETE operation - Delete the post created by user.

**Prerequisite Software**

- Java
- Any Java IDE (Intellij, Eclipse etc)


**How to execute the tests**

- Clone the project.
- Open the project in Intellij or Eclipse.
- Run tests by running "TestRunner" class present under "testrunner" package.


**About the project structure**

src/test/java:


- jsonplace - It has all the class files which contains all test cases.
- testrunner - It has script written to run all the test cases at once.
- testutilities - It has two class which is responsible for giving us information about passed and failed test cases. It also helps to load the configuration file from resource.

resources:

- It contains configuration file required for test cases and also the json body for different test cases.

**Things which can be added**

- More error scenarios can be implemented.
- Integration into CI/CD pipeline.
