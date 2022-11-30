package ChatServer;

import POJOClasses.request.CreateChatUserPOJO;
import POJOClasses.response.CreateChatUserResponse;
import io.restassured.RestAssured;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ChatServerCreatUserForResponseWithPOJO {

    public static void main(String[] args) throws IOException {

        CreateChatUserPOJO ob = new CreateChatUserPOJO();

        ob.setUsername("rahul222");
        ob.setPassword("r1234");
        ob.setEmail("rahul@gmail.com");
        ob.setName("rahul");
        ob.setSurname("ujagare");
        ob.setChat_nickname("r11");

      ArrayList<Integer> dept = new ArrayList<Integer>()
        {{
            add(1);
            add(2);
        }};
        ob.setDepartment(dept);

        ArrayList<Integer> deptRead = new ArrayList<Integer>()
        {{
            add(2);

        }};
        ob.setDepartments_read(deptRead);

        ArrayList<Integer> deptGroups = new ArrayList<Integer>()
        {{
            add(1);

        }};
        ob.setDepartment_groups(deptGroups);

        ArrayList<Integer> userGroups = new ArrayList<Integer>()
        {{
            add(1);

        }};

        ob.setUser_groups(userGroups);

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        CreateChatUserResponse createChatUserResponse = given().log().all().auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(ob)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().as(CreateChatUserResponse.class);

        System.out.println("username="+createChatUserResponse.getResult().getUsername());
        System.out.println("password="+createChatUserResponse.getResult().getPassword());
        System.out.println("name="+createChatUserResponse.getResult().getName());
        System.out.println("surname="+createChatUserResponse.getResult().getSurname());
        System.out.println("email="+createChatUserResponse.getResult().getEmail());
        System.out.println("nickName="+createChatUserResponse.getResult().getChat_nickname());

    }
}
