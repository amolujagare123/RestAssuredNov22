package ChatServer;

import POJOClasses.response.GetAllUsersResponsePojo;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CharServerViewAllUsersResponsePOJO {

    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        GetAllUsersResponsePojo getAllUsersResponsePojo =  given().log().all().auth().preemptive().basic("admin","admin123")
                .when().get("/restapi/getusers")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(GetAllUsersResponsePojo.class);

    for (int i=0;i<getAllUsersResponsePojo.getResult().size();i++) {
        System.out.print("Name=" + getAllUsersResponsePojo.getResult().get(i).getName());
        System.out.println(" " + getAllUsersResponsePojo.getResult().get(i).getSurname());
    }
    }
}
