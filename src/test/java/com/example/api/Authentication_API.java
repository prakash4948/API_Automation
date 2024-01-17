package com.example.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

public class Authentication_API {

    // Define the API endpoint
    String url = "https://omniwallet.tngbl.xyz/authenticate";

    @Test
    public void test_API_With_Valid_Credentials() throws Exception {
        String payload = "{\"username\": \"PRAKASH4948\", \"password\": \"Integraate@4948\"}";
        int numberOfRequests = 10; // Change this to the desired number of requests

        HttpClient client = HttpClients.createDefault();
        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 0; i < numberOfRequests; i++) {
            HttpPost request = new HttpPost(url);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(payload));

            HttpResponse response = client.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());

            // Parse the JSON response
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            // Extract and validate the JSON fields
            int responseStatus = jsonNode.get("status").asInt();
            String responseMessage = jsonNode.get("message").asText();
            String token = jsonNode.get("data").get("Token").asText();

            // Print the JSON fields to the console with a space between results
            System.out.println("Response Status Code: " + responseStatus);
            System.out.println("Response Message: " + responseMessage);
            System.out.println("Token: " + token);
            System.out.println(); // Add a newline

            // Add assertions to check the JSON fields
            Assert.assertEquals(responseStatus, 200, "Response status code is not as expected");
            Assert.assertEquals(responseMessage, "success", "Response message is not as expected");
        }
    }
    
    @Test
    public void test_API_With_Valid_Username_and_Invalid_Password() throws Exception {
        String payload = "{\"username\": \"PRAKASH4948\", \"password\": \"kavita\"}";
        int numberOfRequests = 5; // Change this to the desired number of requests

        HttpClient client = HttpClients.createDefault();
        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 0; i < numberOfRequests; i++) {
            HttpPost request = new HttpPost(url);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(payload));

            HttpResponse response = client.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());

            // Parse the JSON response
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            // Extract and validate the JSON fields
            int responseStatus = jsonNode.get("status").asInt();
            String responseMessage = jsonNode.get("message").asText();

            // Print the JSON fields to the console with a space between results
            System.out.println("Response Status Code: " + responseStatus);
            System.out.println("Response Message: " + responseMessage);
            System.out.println(); // Add a newline

            // Add assertions to check the JSON fields
            Assert.assertEquals(responseStatus, 401, "Response status code is not as expected");
            Assert.assertEquals(responseMessage, "Invalid Credentials", "Response message is not as expected");
        }
    }


@Test
public void test_API_With_INvalid_Username_and_Valid_Password() throws Exception {
    String payload = "{\"username\": \"prakash1234\", \"password\": \"Integraate@4948\"}";
    int numberOfRequests = 5; // Change this to the desired number of requests

    HttpClient client = HttpClients.createDefault();
    ObjectMapper objectMapper = new ObjectMapper();

    for (int i = 0; i < numberOfRequests; i++) {
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(payload));

        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        // Parse the JSON response
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        // Extract and validate the JSON fields
        int responseStatus = jsonNode.get("status").asInt();
        String responseMessage = jsonNode.get("message").asText();

        // Print the JSON fields to the console with a space between results
        System.out.println("Response Status Code: " + responseStatus);
        System.out.println("Response Message: " + responseMessage);
        System.out.println(); // Add a newline

        // Add assertions to check the JSON fields
        Assert.assertEquals(responseStatus, 401, "Response status code is not as expected");
        Assert.assertEquals(responseMessage, "Invalid Credentials", "Response message is not as expected");
    }
}

@Test
public void test_API_With_Null_Username_and_Valid_Password() throws Exception {
    String payload = "{\"username\": \"\", \"password\": \"Integraate@4948\"}";
    int numberOfRequests = 5; // Change this to the desired number of requests

    HttpClient client = HttpClients.createDefault();
    ObjectMapper objectMapper = new ObjectMapper();

    for (int i = 0; i < numberOfRequests; i++) {
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(payload));

        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        // Parse the JSON response
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        // Extract and validate the JSON fields
        int responseStatus = jsonNode.get("status").asInt();
        String responseMessage = jsonNode.get("message").asText();

        // Print the JSON fields to the console with a space between results
        System.out.println("Response Status Code: " + responseStatus);
        System.out.println("Response Message: " + responseMessage);
        System.out.println(); // Add a newline

        // Add assertions to check the JSON fields
        Assert.assertEquals(responseStatus, 401, "Response status code is not as expected");
        Assert.assertEquals(responseMessage, "Invalid Credentials", "Response message is not as expected");
    }
}

@Test
public void test_API_With_Valid_Username_and_Null_Password() throws Exception {
	 String payload = "{\"username\": \"PRAKASH4948\", \"password\": \"\"}";
    int numberOfRequests = 5; // Change this to the desired number of requests

    HttpClient client = HttpClients.createDefault();
    ObjectMapper objectMapper = new ObjectMapper();

    for (int i = 0; i < numberOfRequests; i++) {
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(payload));

        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        // Parse the JSON response
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        // Extract and validate the JSON fields
        int responseStatus = jsonNode.get("status").asInt();
        String responseMessage = jsonNode.get("message").asText();

        // Print the JSON fields to the console with a space between results
        System.out.println("Response Status Code: " + responseStatus);
        System.out.println("Response Message: " + responseMessage);
        System.out.println(); // Add a newline

        // Add assertions to check the JSON fields
        Assert.assertEquals(responseStatus, 401, "Response status code is not as expected");
        Assert.assertEquals(responseMessage, "Invalid Credentials", "Response message is not as expected");
    }
}


@Test
public void test_API_With_Null_Username_and_Null_Password() throws Exception {
	 String payload = "{\"username\": \"\", \"password\": \"\"}";
    int numberOfRequests = 5; // Change this to the desired number of requests

    HttpClient client = HttpClients.createDefault();
    ObjectMapper objectMapper = new ObjectMapper();

    for (int i = 0; i < numberOfRequests; i++) {
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(payload));

        HttpResponse response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        String responseBody = EntityUtils.toString(response.getEntity());

        // Parse the JSON response
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        // Extract and validate the JSON fields
        int responseStatus = jsonNode.get("status").asInt();
        String responseMessage = jsonNode.get("message").asText();

        // Print the JSON fields to the console with a space between results
        System.out.println("Response Status Code: " + responseStatus);
        System.out.println("Response Message: " + responseMessage);
        System.out.println(); // Add a newline

        // Add assertions to check the JSON fields
        Assert.assertEquals(responseStatus, 401, "Response status code is not as expected");
        Assert.assertEquals(responseMessage, "Invalid Credentials", "Response message is not as expected");
    }
}


}
