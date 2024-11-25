Feature: API Testing with GET and POST requests

	@test2
  Scenario: GET request to validate response
    Given I send a GET request to "https://echo.free.beeceptor.com/sample-request?author=beeceptor"
    Then the response should contain "path"
    And the response should contain "ip"
    And the response should contain "headers"
	@test3
  Scenario: POST request to validate order details
    Given I send a POST request to "http://echo.free.beeceptor.com/sample-request?author=beeceptor"
    Then the response should contain "parsedBody.order_id" with value "12345"
    And the response should contain "parsedBody.customer.name" with value "Jane Smith"
    #And the response should contain "parsedBody.payment.amount" with value "111.97"
    And the response should contain "parsedBody.shipping.method" with value "standard"
