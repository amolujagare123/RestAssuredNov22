package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayload.createUserPayload;

public class CharServerCreatUserWithPayLoadParam {

    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(createUserPayload("rahul123","r1234",
                        "rahul@gmail.com","Rahul","Ujagare","r123"))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
