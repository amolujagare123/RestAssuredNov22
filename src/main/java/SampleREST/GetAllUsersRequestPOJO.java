package SampleREST;

import POJOClasses.response.GetAllUsersPOJO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class GetAllUsersRequestPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        GetAllUsersPOJO getAllUsersPOJO = given().log().all().queryParam("page","2")
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().as(GetAllUsersPOJO.class);

        // print all the users FirstName and last name

        for (int i=0;i< getAllUsersPOJO.getData().size();i++) {
            System.out.print("First name="+getAllUsersPOJO.getData().get(i).getFirst_name());
            System.out.println("  Last name="+getAllUsersPOJO.getData().get(i).getLast_name());
        }

    }
}
