package JopPortal;

import POJOClasses.request.JobPortalPOJO;
import POJOClasses.request.Project;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateJobRequestWithPOJO {

    @Test
    public void createJob() {


        JobPortalPOJO ob = new JobPortalPOJO();

        ArrayList<String> forExperience = new ArrayList<>();
        forExperience.add("1 year in manual testing");
        forExperience.add("2 years in automation");
        ob.setExperience(forExperience);

        ob.setJobDescription("Software Tester with 3 years experience are required with automation knowledge");
        ob.setJobId(4321);
        ob.setJobTitle("Software Tester with 3 years experience");

        Project project1 = new Project();
        project1.setProjectName("Hospital Management");
        ArrayList<String> forTechnology1 = new ArrayList<>();
        forTechnology1.add("Java");
        forTechnology1.add("My SQL");
        project1.setTechnology(forTechnology1);


        Project project2 = new Project();
        project2.setProjectName("ERP");
        ArrayList<String> forTechnology2 = new ArrayList<>();
        forTechnology2.add("Dot net");
        forTechnology2.add("MS SQL");
        project2.setTechnology(forTechnology2);


        ArrayList<Project> forProject = new ArrayList<>();
        forProject.add(project1);
        forProject.add(project2);

        ob.setProject(forProject);


        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all().body(ob).header("Content-Type","application/json")
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201);

    }

}
