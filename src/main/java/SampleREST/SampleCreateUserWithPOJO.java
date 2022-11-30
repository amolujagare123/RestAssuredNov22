package SampleREST;

import POJOClasses.request.CreateSampleUserPOJO;
import io.restassured.RestAssured;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SampleCreateUserWithPOJO {

    public static void main(String[] args) throws IOException {


        CreateSampleUserPOJO ob = new CreateSampleUserPOJO();
        ob.setName("Vivekanand");
        ob.setJob("HR");

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().body(ob)
                .header("Content-Type","application/json")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name",equalTo("Vivekanand"));
    }
}
