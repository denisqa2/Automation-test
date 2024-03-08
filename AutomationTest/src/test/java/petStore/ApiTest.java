package petStore;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class ApiTest {


    @Test
    public void createUserTest() {
        String endpoint = "https://petstore.swagger.io/v2/user";
        String body = """
                {
                "id": 111,
                "username": "JJ",
                "firstName": "John",
                "lastName": "Jonson",
                "email": "Jonson@test.com",
                "password": "12345",
                "phone": "1234567890",
                "userStatus": 0
                }
                """;
        var response = given().
                contentType("application/json").body(body).
                when().post(endpoint).
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void createListUserTest() {
        String endpoint = "https://petstore.swagger.io/v2/user/createWithList";
        String body = """
                [
                {
                "id": 123,
                "username": "DD",
                "firstName": "Derek",
                "lastName": "Derekson",
                "email": "Derek@test.com",
                "password": "12345",
                "phone": "1234567890",
                "userStatus": 0
                }
                ]
                """;
        var response = given().
                contentType("application/json").body(body).
                when().post(endpoint).
                then().
                assertThat().statusCode(200);
    }


    @Test
    public void loginUserTest() {
        String endpoint = "https://petstore.swagger.io/v2/user/login";
        var response = given().
                queryParam("username", "JJ").
                queryParam("password", "12345").
                when().get(endpoint).then().
                assertThat().statusCode(200);
    }

    @Test
    public void loginOutUserTest() {
        String endpoint = "https://petstore.swagger.io/v2/user/logout";
        var response = given().
                when().get(endpoint).then().
                assertThat().statusCode(200);
    }

    @Test
    public void addNewPetTest() {
        String endpoint = "https://petstore.swagger.io/v2/pet";
        String body = """
                {
                  "id": 11111,
                  "category": {
                    "id": 0,
                    "name": "Mouse"
                  },
                  "name": "Jery",
                  "photoUrls": [
                    "test.com"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "string"
                    }
                  ],
                  "status": "available"
                }
                """;
        var response = given().
                contentType("application/json").
                body(body).
                when().post(endpoint).
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void updatePetTest() {
        String endpoint = "https://petstore.swagger.io/v2/pet";
        String body = """
                {
                  "id": 11111,
                  "category": {
                    "id": 0,
                    "name": "Mouse"
                  },
                  "name": "Jery1",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "string"
                    }
                  ],
                  "status": "available"
                }
                """;
        var response = given().
                contentType("application/json").
                body(body).
                when().put(endpoint).
                then().
                assertThat().statusCode(200);
    }


    @Test
    public void deletePetTest() {
        String endpoint = "https://petstore.swagger.io/v2/pet/{petId}";
        var response = given().pathParams("petId", "11111").
                when().delete(endpoint).
                then().
                assertThat().statusCode(200);

    }
}
