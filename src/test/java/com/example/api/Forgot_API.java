package com.example.api;


	
	import org.testng.annotations.Test;
	import org.apache.http.HttpResponse;
	import org.apache.http.client.HttpClient;
	import org.apache.http.client.methods.HttpPost;
	import org.apache.http.entity.StringEntity;
	import org.apache.http.impl.client.HttpClients;
	import org.apache.http.util.EntityUtils;
	import org.testng.Assert;

	public class Forgot_API {

	    String apiURL = "https://omniwallet.tngbl.xyz/forgot-password";

	    @Test
	    public void testForgotPasswordForValidUsername() throws Exception {
	        String username = "PRAKASH@4948";
	        String payload = "{\"username\": \"" + username + "\"}";

	        HttpClient client = HttpClients.createDefault();
	        HttpPost request = new HttpPost(apiURL);
	        request.setHeader("Content-Type", "application/json");
	        request.setEntity(new StringEntity(payload));

	        HttpResponse response = client.execute(request);
	        int statusCode = response.getStatusLine().getStatusCode();
	        String responseBody = EntityUtils.toString(response.getEntity());

	        // Assert the HTTP status code
	        Assert.assertEquals(statusCode, 200);

	        // You can further validate the response JSON if needed
	    }

	    @Test
	    public void testForgotPasswordForInvalidUsername() throws Exception {
	        String username = "hello";
	        String payload = "{\"username\": \"" + username + "\"}";

	        HttpClient client = HttpClients.createDefault();
	        HttpPost request = new HttpPost(apiURL);
	        request.setHeader("Content-Type", "application/json");
	        request.setEntity(new StringEntity(payload));

	        HttpResponse response = client.execute(request);
	        int statusCode = response.getStatusLine().getStatusCode();

	        // For this case, the provided JavaScript code expects a 200 status code for invalid username.
	        // You may want to change this to 400 or a relevant status code depending on your API's behavior.
	        Assert.assertEquals(statusCode, 200);
	    }

	    @Test
	    public void testForgotPasswordForBlankUsername() throws Exception {
	        String username = " ";
	        String payload = "{\"username\": \"" + username + "\"}";

	        HttpClient client = HttpClients.createDefault();
	        HttpPost request = new HttpPost(apiURL);
	        request.setHeader("Content-Type", "application/json");
	        request.setEntity(new StringEntity(payload));

	        HttpResponse response = client.execute(request);

	        // You can validate the response status code and the response data here
	        int statusCode = response.getStatusLine().getStatusCode();
	        String responseBody = EntityUtils.toString(response.getEntity());

	        // Assert the status code
	        Assert.assertEquals(statusCode, 200);
	    }
	}



