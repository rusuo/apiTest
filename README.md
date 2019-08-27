# apiTest

To provide the solution, I used InteliJ IDEA and created a new maven project.

To build the project, use InteliJ and build the app from the IDEA.

The solution has a few different tests for the POST method. As there are no specifications to the API, the tests are passing, but I would have expected a few different results for some cases. The tests are as follows:
1. Test that sends a correct payload and expects a return status code 200
2. Test that sends an incorrect payload and verifies a return status code 200. I would have expected a different status code for an incorrect payload.
3. Test that sends an empty payload and verifies a return status code 200. I would have expected a different status code for an empty payload.
4. Test that sends the payload but as a different content type and checks for 200.
5. Test that sends the payload to a wrong endpoint and verifying that it gets back 400 status code.

To check the results, I used Postman app and did a GET request to see if the entries have been added as a results of POST requests and noticed that the IDs that are being given after the POST request is made are not unique, which should not happen in a correct specification of an API

