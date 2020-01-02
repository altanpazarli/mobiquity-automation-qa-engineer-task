# Cafe Townsend Tests & Automation

First of all, I would ask some necessary questions to Product Owner and reading scopes of stories for clarifying below points and testing accurate.

* Which devices should be compatible with this application? This question for 
deciding test for mobile devices or different screen resolutions?

* How many users will use this application at the same time? This question for deciding load/stress test?

## Exploratory Testing
```
Test Case1 : Login with random credentials
Steps
-Go to the login page
-Enter the random creds
-Press on the Login button
Expected : Login should be failed.
Actual   : Expected
Result   : Test Passed!
 
Test Case2 : Login with correct credentials
Steps
-Go to the login page
-Enter the correct creds
-Press on Login button
Expected : Login should be succesful.
Actual   : Expected
Result   : Test Passed!

Test Case3 : Login with correct username ends with space
Steps
-Go to the login page
-Enter "Luke "
-Press on Login button
Expected : Login should be failed.
Actual   : Login succesful
Result   : BUG!

Test Case4 : Deleting User from the edit page
Steps
-Login to the system
-Go to the edit page
-Delete User
Expected : User should be deleted.
Actual   : Expected
Result   : Test Passed!

Test Case5 : Deleting User from the main page
Steps
-Login to the system
Expected : User should be deleted.
Actual   : Expected
Result   : Test Passed!

Test Case6 : Editing user with invalid data
Steps
-Login to the system
-Edit user with
--start date : 2010-01-01abc
--e-mail     : 1@1
-Click Update
Expected : Editing should be failed!
Actual   : Edited Sucessful. 
Result   : BUG!

Test Case7 : Editing user with empty fields
Steps
-Login to the system
-Edit user with empty fields
Expected : Editing should be failed!
Actual   : Expected
Result   : Test Passed!

Test Case8 : Editing user with valid data
Steps
-Login to the system
-Edit user with valid data, should succeed.
Expected : User should be deleted.
Actual   : Expected
Result   : Test Passed!

Test Case9 : Logout
Steps
-Login to the system
-Logout the system
Expected : Logout should be succesful.
Actual   : Expected
Result   : Test Passed!

 ```

### Bugs and Concerns: 

[Bug] Test Case3

[Bug] Test Case6

[Concern] Deletion is flaky and sometimes response time is long.

[Concern] Session expire if user refresh the page

[Security Concern] Password is not clearing after logout.


## Test Automation 

### Requirements 

* [Sbt](https://www.scala-sbt.org/download.html)
* [Chrome](https://www.google.com/chrome)

Ignore ChromeDriver if you are using macOs. Project includes macOs ChromeDriver. 

* [ChromeDriver](http://chromedriver.chromium.org/downloads)

### Techs

* [Scala](https://www.scala-lang.org)
* [Scalatest Framework](http://www.scalatest.org)
* [Selenium Webdriver](https://www.seleniumhq.org/projects/webdriver)

### How to run

* Open Terminal
* Go to project
* ```sbt test```

A new Chrome will be opened. You may follow steps.

### Project Structure 
```
.
|-- .gitignore
|-- README.md
|-- build.sbt                                             : Dependencies
|-- task.md                                               : Homework
|-- drivers
|   |-- chromedriver                                      : ChromeDriver for macOs. Please check  requirements above if you are using another OS                      
|-- project
|   |-- build.properties
|-- src
    |-- main
    |   |-- resources
    |   |   |-- application.conf                         : user data, links, roots are in this conf file
    |   |-- scala
    |       |-- com.cafetownsend.test
    |           |-- Configuration.scala                   : Loading Configurations
    |-- test
        |-- scala
            |-- com.cafetownsend.test
                |-- pages                                 : All page object under this folder
                |   |-- EmployeesEditPage.scala
                |   |-- EmployeesNewPage.scala
                |   |-- EmployeesPage.scala
                |   |-- HomePage.scala
                |   |-- LoginPage.scala
                |-- tests                                 : All tested functions under this folder
                |   |-- LoginTest.scala
                |   |-- NewEmployeeCreationTest.scala
                |   |-- UpdatingEmployeeDataTest.scala
                |-- utilities
                    |-- WebDrivers.scala                  
                    
```



## Improvement Points/Questions

* Asking to UI Dev for selector uniqueness(class, attribute, id etc)

* User should stay logged in after refreshing page

* Adding ID of employees to employee list

## Next Steps 

* Test can be automated with Jenkins, Bamboo

* Tests can be run parallel (Selenium Grid)

* Load Test (Gatling)

* Performance Test (Sitespeed.io or WPT)

* Code Quality and Coverage Management (SonarQube)

* Security Testing (OWASP ZAP)
