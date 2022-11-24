package SampleREST;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPIPayload.createSampleUserPayLoad;

public class SampleCreateUserWithPayload {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().body(createSampleUserPayLoad())
                .header("Content-Type","application/json")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name",equalTo("morpheus"));
    }
}
