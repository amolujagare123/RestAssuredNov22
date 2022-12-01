package ChatServer.SpecBuilderDemo;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    public static void main(String[] args) {

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setAuth(auth)
                .setBaseUri("http://localhost:80/chat/lhc_web/index.php/site_admin")
                //.addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification reqSpec = given().log().all().spec(requestSpecification);

        ResponseSpecification responseSpecification
                = new ResponseSpecBuilder().expectStatusCode(200).build();


        Response response = reqSpec.when().get("/restapi/getusers");

        String respStr = response.then().log().all().spec(responseSpecification).extract().asString();


        System.out.println(respStr);
    }
}
