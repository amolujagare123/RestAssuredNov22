package ChatServer;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayload.createUserPayload;

public class CharServerCreatUserWithDataProvider {

    @Test (dataProvider = "getData")
    public void createUSerTest(String username,String password,
    String email,String name,String surname,String nickName) {
        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(createUserPayload(username,password,email,name,surname,nickName))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[3][6];

        data[0][0] = "user99";
        data[0][1] = "pass99";
        data[0][2] = "user99@gmail.com";
        data[0][3] = "user-99";
        data[0][4] = "surname-99";
        data[0][5] = "user-9";

        data[1][0] = "user98";
        data[1][1] = "pass98";
        data[1][2] = "user98@gmail.com";
        data[1][3] = "user-98";
        data[1][4] = "surname-98";
        data[1][5] = "user-8";

        data[2][0] = "user97";
        data[2][1] = "pass97";
        data[2][2] = "user97@gmail.com";
        data[2][3] = "user-97";
        data[2][4] = "surname-97";
        data[2][5] = "user-7";

        return data;
    }
}
