package ChatServer;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayload.createUserPayload;

public class CharServerCreatUserWithJson {

    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(

                     //   new String(Files.readAllBytes(Paths.get("D:\\MyProg\\jsonFiles\\createChatUserSample.json")))
        new String(Files.readAllBytes(Paths.get("JsonFiles/createChatUser.json")))
                )
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
