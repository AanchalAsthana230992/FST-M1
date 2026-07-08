package Activities;


import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;

public class Activity2 {

    private static final String USERNAME = "justinc";
    private static final int ID = 9901;
    private static final String FIRST_NAME = "Justin";
    private static final String LAST_NAME = "Case";
    private static final String EMAIL = "justincase@mail.com";
    private static final String PASSWORD = "password123";
    private static final String PHONE = "9812763450";

    @Test(priority = 1)
    public void createUser() throws IOException {

        File jsonFile = new File("src/test/resources/users.json");
        String requestBody = new String(Files.readAllBytes(jsonFile.toPath()));

        Response response =
                given()
                        .contentType("application/json")
                        .body(requestBody)
                .when()
                        .post("https://petstore.swagger.io/v2/user")
                .then()
                        .statusCode(200)
                        .extract()
                        .response();

        Assert.assertEquals(response.jsonPath().getInt("code"), 200);

        System.out.println("POST User Response:");
        System.out.println(response.asPrettyString());
    }

    @Test(priority = 2)
    public void getUser() throws IOException {

        Response response =
                given()
                        .pathParam("username", USERNAME)
                .when()
                        .get("https://petstore.swagger.io/v2/user/{username}")
                .then()
                        .statusCode(200)
                        .extract()
                        .response();

        // Assertions for all fields
        Assert.assertEquals(response.jsonPath().getInt("id"), ID);
        Assert.assertEquals(response.jsonPath().getString("username"), USERNAME);
        Assert.assertEquals(response.jsonPath().getString("firstName"), FIRST_NAME);
        Assert.assertEquals(response.jsonPath().getString("lastName"), LAST_NAME);
        Assert.assertEquals(response.jsonPath().getString("email"), EMAIL);
        Assert.assertEquals(response.jsonPath().getString("password"), PASSWORD);
        Assert.assertEquals(response.jsonPath().getString("phone"), PHONE);

        // Write response to external JSON file
        FileWriter writer = new FileWriter("getUserResponse.json");
        writer.write(response.asPrettyString());
        writer.close();

        System.out.println("GET User Response written to getUserResponse.json");
    }

    @Test(priority = 3)
    public void deleteUser() {

        Response response =
                given()
                        .pathParam("username", USERNAME)
                .when()
                        .delete("https://petstore.swagger.io/v2/user/{username}")
                .then()
                        .statusCode(200)
                        .extract()
                        .response();

        // Assertions
        Assert.assertEquals(response.jsonPath().getInt("code"), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), USERNAME);

        System.out.println("DELETE User Response:");
        System.out.println(response.asPrettyString());
    }
}