# Assignment_Ebay_01

This project consists of test scripts for two scenarios on eBay.com:
1. Accessing a product via category after applying multiple filters.
2. Accessing a product via search.

## Prerequisites
- IntelliJ IDEA or Eclipse IDE
- Java Development Kit (JDK) 17
- Maven
- Google Chrome browser
- ChromeDriver

## Project Structure
![image](https://github.com/user-attachments/assets/f1c51944-a86a-433b-9abe-2bfe775fe930)

# Assignment_Ebay_01

This project consists of test scripts for two scenarios on eBay.com:
1. Accessing a product via category after applying multiple filters.
2. Accessing a product via search.

## Prerequisites
- IntelliJ IDEA or Eclipse IDE
- Java Development Kit (JDK) 17
- Maven
- Google Chrome browser
- ChromeDriver

## Dependencies
The following dependencies are defined in the `pom.xml` file:
- Selenium Java (4.22.0)
- TestNG (7.10.2)
- JUnit Jupiter API (5.11.0-M2)
- JUnit (3.8.1 and latest release)

## Setup Instructions
1. Clone the repository or download the project files.
2. Open the project in IntelliJ IDEA or Eclipse IDE.
3. Ensure that you have JDK 17 installed and configured in your IDE.
4. Ensure that you have Maven installed and configured in your IDE.
5. Download the ChromeDriver corresponding to your Chrome browser version and place it in a directory (e.g., `C:\Users\<YourUsername>\Documents\chromedriver-win64\`).
6. Update the path to the ChromeDriver in the `setUp` method of both `Ebay.java` and `Ebay2.java` files:
   ```java
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\<YourUsername>\\Documents\\chromedriver-win64\\chromedriver.exe");
Or You can copy the path manually and replace it inside the code as well.

# Running the Tests
1. Open a terminal or command prompt.
2. Navigate to the project directory.
3. Use Maven to run the tests:
   
   ```mvn test``` -- by running this command on terminal

Alternatively, you can run the test classes directly from your IDE.

# Test Scenarios

## Scenario 1: Access a Product via Category after Applying Multiple Filters
- Navigate to eBay.com.
- Go to Electronics > Cell Phones & accessories.
- Click on Cell Phones & Smartphones in the left-hand side navigation section.
- Click on "All Filters" and add three filters: Condition, Price, and Item location.
- Verify that the filter tags are applied.

## Scenario 2: Access a Product via Search
- Navigate to eBay.com.
- Type a search string in the search bar (e.g., MacBook).
- Change the search category (e.g., Computers/Tablets & Networking) and click Search.
- Verify that the page loads completely.
- Verify that the first result name matches the search string.

# Code Description

## File: Ebay.java
- **setUp()**: Initializes the WebDriver and navigates to eBay.com.
- **testFilters()**: Executes the steps for Scenario 1, applying filters and verifying them.
- **tearDown()**: Closes the WebDriver.

## File: Ebay2.java
- **setUp()**: Initializes the WebDriver and navigates to eBay.com.
- **testSearch()**: Executes the steps for Scenario 2, performing a search and verifying the results.
- **tearDown()**: Closes the WebDriver.

# Notes
- Ensure that the ChromeDriver path is correctly set in the `setUp` method.
- The `pom.xml` file contains all necessary dependencies. Ensure they are correctly downloaded by Maven.

---

Feel free to reach out if you have any questions or need further clarification.

