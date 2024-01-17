package API;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POST {

    // Custom class to hold both response data and status code
    public class ResponseData {
        public int statusCode;
        public String responseBody;
    }

    @Test
    void testUnauthorizedRequest() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Username", "prakash1234");
        data.put("password", "Kavita@123");

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://omniwallet.tngbl.xyz/authenticate")
                .then()
                .log().all()
                .extract().response();

        // Create a ResponseData object to store the data and status code
        ResponseData responseData = new ResponseData();
        responseData.statusCode = response.getStatusCode();
        responseData.responseBody = response.asString();

        // You can now use responseData to access both status code and response data
        Assert.assertEquals(responseData.statusCode, 401);
        Assert.assertEquals(responseData.responseBody, "Invalid Credentials");
    }

    @Test
    void testSuccessfulRequest() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Username", "PRAKASH4948");
        data.put("Password", "Integraate@4948");

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://omniwallet.tngbl.xyz/authenticate")
                .then()
                .log().all()
                .extract().response();

        // Create a ResponseData object to store the data and status code
        ResponseData responseData = new ResponseData();
        responseData.statusCode = response.getStatusCode();
        responseData.responseBody = response.asString();

        // You can now use responseData to access both status code and response data
        Assert.assertEquals(responseData.statusCode, 200);
        Assert.assertEquals(responseData.responseBody, "success");
    }
}
