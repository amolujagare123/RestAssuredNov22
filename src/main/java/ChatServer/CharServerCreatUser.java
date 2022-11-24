package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CharServerCreatUser {

    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"username\": \"prathamesh1211\",\n" +
                        "  \"password\": \"pr123\",\n" +
                        "  \"email\": \"amol@gmail.com\",\n" +
                        "  \"name\": \"prathamesh\",\n" +
                        "  \"surname\": \"xyz\",\n" +
                        "  \"chat_nickname\": \"pr\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}")
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
