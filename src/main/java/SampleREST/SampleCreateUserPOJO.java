package SampleREST;

import POJOClasses.request.CreateSampleUserPOJO;
import POJOClasses.response.CreateSampleUserResponsePOJO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SampleCreateUserPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        CreateSampleUserPOJO ob = new CreateSampleUserPOJO();
        ob.setName("Vivekanand");
        ob.setJob("HR");

        CreateSampleUserResponsePOJO createSampleUserResponsePOJO = given().log().all().body(ob)
                .header("Content-Type","application/json")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .extract().response().as(CreateSampleUserResponsePOJO.class);

        System.out.println("Id="+createSampleUserResponsePOJO.getId());
        System.out.println("Name="+createSampleUserResponsePOJO.getName());
        System.out.println("Job="+createSampleUserResponsePOJO.getJob());
        System.out.println("Created AT="+createSampleUserResponsePOJO.getCreatedAt());
    }
}
