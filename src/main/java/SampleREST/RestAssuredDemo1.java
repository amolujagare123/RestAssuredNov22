package SampleREST;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class RestAssuredDemo1 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().queryParam("page","2")
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200);

    }
}
