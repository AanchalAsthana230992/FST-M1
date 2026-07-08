package Activities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Activity1 {

    private static final long PET_ID = 77232;
    private static final String PET_NAME = "Riley";
    private static final String PET_STATUS = "alive";

    @Test(priority = 1)
    public void createPet() {

        String requestBody = """
                {
                  "id": 77232,
                  "name": "Riley",
                  "status": "alive"
                }
                """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
        .when()
                .post("https://petstore.swagger.io/v2/pet")
        .then()
                .statusCode(200)
                .extract()
                .response();

        // Assertions for POST response
        Assert.assertNotNull(response.jsonPath().get("id"));
        Assert.assertNotNull(response.jsonPath().get("name"));
        Assert.assertNotNull(response.jsonPath().get("status"));

        Assert.assertEquals(response.jsonPath().getLong("id"), PET_ID);
        Assert.assertEquals(response.jsonPath().getString("name"), PET_NAME);
        Assert.assertEquals(response.jsonPath().getString("status"), PET_STATUS);

        System.out.println("POST Request Passed");
    }

    @Test(priority = 2)
    public void getPet() {

        Response response = given()
                .pathParam("petId", PET_ID)
        .when()
                .get("https://petstore.swagger.io/v2/pet/{petId}")
        .then()
                .statusCode(200)
                .extract()
                .response();

        // Assertions for GET response
        Assert.assertNotNull(response.jsonPath().get("id"));
        Assert.assertNotNull(response.jsonPath().get("name"));
        Assert.assertNotNull(response.jsonPath().get("status"));

        Assert.assertEquals(response.jsonPath().getLong("id"), PET_ID);
        Assert.assertEquals(response.jsonPath().getString("name"), PET_NAME);
        Assert.assertEquals(response.jsonPath().getString("status"), PET_STATUS);

        System.out.println("GET Request Passed");
    }

    @Test(priority = 3)
    public void deletePet() {

        Response response = given()
                .pathParam("petId", PET_ID)
        .when()
                .delete("https://petstore.swagger.io/v2/pet/{petId}")
        .then()
                .statusCode(200)
                .extract()
                .response();

        // Assertions for DELETE response
        Assert.assertNotNull(response.jsonPath().get("code"));
        Assert.assertNotNull(response.jsonPath().get("message"));

        Assert.assertEquals(response.jsonPath().getInt("code"), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), String.valueOf(PET_ID));

        System.out.println("DELETE Request Passed");
    }
}