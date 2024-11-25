package testFiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class ApiSteps {

    private Response response;

    @Given("I send a GET request to {string}")
    public void iSendAGETRequestTo(String url) {
        response = RestAssured.given().get(url);
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String field) {
        response.then().body(field, notNullValue());
        String bodyAsString = response.getBody().asString();
        System.out.println(bodyAsString);
    }

    @Given("I send a POST request to {string}")
    public void iSendAPOSTRequestToWithThePayloadFrom(String url) {
        File payload = new File(System.getProperty("user.dir")+"/Resources/postPayload.json");
        response = RestAssured.given()
                	.header("Content-Type", "application/json")
                	.body(payload)
                	.post(url);


    }

    @Then("the response should contain {string} with value {string}")
    public void theResponseShouldContainWithValue(String field, String expectedValue) {
    	
    	String responseString = response.getBody().asString();
    	response.then().body(field, equalTo(String.valueOf(expectedValue))); 
    	

    	
    	
       
    }
}