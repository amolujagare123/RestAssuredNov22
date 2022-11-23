package SampleREST;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SampleUpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200);

    }
}
