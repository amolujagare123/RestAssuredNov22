package SampleREST.SpecBuilderDemo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class CreateUser {

    public static void main(String[] args) {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification reqSec = given().log().all().spec(requestSpecification)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}");

          ResponseSpecification responseSpecification
                  = new ResponseSpecBuilder().expectStatusCode(201).build();

        Response response = reqSec.when().post("/api/users");

        String respStr = response.then().log().all().spec(responseSpecification).extract().asString();

        System.out.println(respStr);
    }
}
