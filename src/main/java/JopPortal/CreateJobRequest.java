package JopPortal;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateJobRequest {

    @Test
    public void createJob() {

        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all().body(
                "{\n" +
                        "  \"experience\": [\n" +
                        "    \"2 years of manual Testing\",\n" +
                        "   \"1 year in automation Testing\"\n" +
                        "  ],\n" +
                        "  \"jobDescription\": \"Automation testers with selenium & API Testing are needed\",\n" +
                        "  \"jobId\": 1234,\n" +
                        "  \"jobTitle\": \"Automation testers with selenium & API\",\n" +
                        "  \"project\": [\n" +
                        "    {\n" +
                        "      \"projectName\": \"Stock management system\",\n" +
                        "      \"technology\": [\n" +
                        "        \"PHP\",\n" +
                        "       \"mySQL\",\n" +
                        "         \"java scipt\"\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"
        ).header("Content-Type","application/json")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);

    }

}
