package SampleREST;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPIPayload.createSampleUserPayLoad;

public class SampleCreateUserWithJson {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().body(

      //          new String(Files.readAllBytes(Paths.get("D:\\MyProg\\jsonFiles\\createUserSample.json")))
        new String(Files.readAllBytes(Paths.get("JsonFiles/createSampleUser.json")))

        )
                .header("Content-Type","application/json")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name",equalTo("Pradeep"));
    }
}
