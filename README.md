**Take Home ExerciseChallenge**

Write an automated test for a web application using Java and SeleniumProblem Statement 

Retrieve Data from UI and compare it with an existing collection (belowgiven test data)
Given Test Data : List<String> expectedStockSymbols = Arrays.asList("NFLX","MSFT","TSLA".......)

Instructions:Write a Test Suite that does the following:

1. Opens a webpage www.google.com/finance on a chrome browser
2. Verifies the page is loaded by asserting the page title
3. Retrieves the stock symbols listed under the section “You may be interested in info”(please note, this is a sample of what to look for on the above browser link and the stockdata will differ day to day)
4. Compare the stock symbols retrieved from (3) with expectedStockSymbols
5. Print all stock symbols that are in (3) but not in expectedStockSymbols
6. Print all stock symbols that are in expectedStockSymbols but not in (3)
                 
When you submit your solution, make sure to include:TestNG file to run the test
