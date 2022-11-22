import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SampleCreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }
}
