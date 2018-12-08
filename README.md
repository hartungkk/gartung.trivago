# gartung.trivago

Java was used as a programming language. Selenide, TestNG, AllureReport, WebDriverManager were chosen as frameworks and libraries
I think this set is optimal for creation of qa automation scalable solutions, because this stack can be launched in the Docker container, as in recent years, development trends prefer choosing containerizing. One very simple, but effective solution is used here for launching on any platform. These functions are taken over by Java and WebDriverManager library, which itself downloads a relevant driver for operation in any browser and any operating system. As a result:
Restrictions (necessary components in a system):
-Jdk 8
-Maven
-Chrome (because I used this browser as an example),(if it’s necessary to launch in some other browser, then it’s necessary to set the value of the other browser in the Settuper class. See the link for additional information about the library (https://github.com/bonigarcia/webdrivermanager )
In order to launch tests and generate reports, it’s necessary to use the following commands:
1. Open the console, go to the folder of the project
2. Execute the mvn clean test command (it’s also possible to supplement this command with parameters, for example launching in Headless mode and etc).
3. After tests execution, generate a report. In order to achieve this, perform mvn allure:report
After that the report will be stored in the folder target/site/allure-maven-plugin/index.html (open using any browser).
