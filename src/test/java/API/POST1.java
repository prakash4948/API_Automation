package API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class POST1 {

    @DataProvider(name = "apiData")
    public Object[][] provideData() {
        // Define different sets of data to be sent to the API
        return new Object[][] {
            { "PRAKASH4948", "Integraate@4948" },
           
            // Add more data sets as needed
        };
    }

    @Test(dataProvider = "apiData")
    void test(String username, String password) {
        HashMap<String, String> data = new HashMap<>();
        data.put("Username", "PRAKASH4948");
        data.put("password", "Integraate@4948");

        given()
            .contentType("application/json")
            .body(data)
            
        .when()
            .post("https://omniwallet.tngbl.xyz/authenticate")
        .then()
            .statusCode(200)
            .log().all();
    }
}
