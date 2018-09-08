Feature: Myntra Application Automation Scenarios

@Precondition
Scenario Outline: Precondition-Opening the browser and application URL
Given I open the "<myBrowser>" and application URL such as "<myURL>"

Examples:
|myBrowser|myURL                 |
|Chrome   |https://www.myntra.com|


@TestCase#1
Scenario Outline: Precondition-Opening the browser and application URL
When I enter search text "<mysearachText>" in search text box and click on search icon button
And I select brand as "<myrequiredBrand>"
And I select item number as <myitemNumber> from items search list
And I select size as "<myitemSize>" and click on "ADD TO CART" button
And I click on "My Shopping Bag" icon button
Then I am able to view my added items in my shopping bags/my cart

Examples:
|mysearachText    |myrequiredBrand |myitemNumber|myitemSize|
|Shirts for Men   |Raymond         |7           |40        |
|Shirts for Female|Wills Lifestyle |12          |M         |
|Shoes for Men    |Adidas          |9           |8         |

@PostCondition
Scenario:Precondition-Closing the application URL and browser
Given I close the application and browser
