package SampleREST;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPIPayload.createSampleUserPayLoad;

public class SampleCreateUserWithDataProvider {

    @Test (dataProvider = "getData")
    public void sampleCreateUserTest(String name,String job) {

        RestAssured.baseURI = "https://reqres.in";

       /* String name = "Rajesh";
        String job = "Trainer";*/

        given().log().all().body(createSampleUserPayLoad(name,job))
                .header("Content-Type","application/json")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name",equalTo(name));
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[4][2];

        data[0][0] = "Rajesh";
        data[0][1] = "Tester";

        data[1][0] = "Swami";
        data[1][1] = "Test Lead";

        data[2][0] = "Manohar";
        data[2][1] = "Manager";

        data[3][0] = "Pradeep";
        data[3][1] = "HR";

        return data;
    }
}
