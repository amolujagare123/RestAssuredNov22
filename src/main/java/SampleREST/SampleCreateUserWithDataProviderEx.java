package SampleREST;

import io.restassured.RestAssured;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPIPayload.createSampleUserPayLoad;

public class SampleCreateUserWithDataProviderEx {

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
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/myData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][2];

        for (int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            data[i][0] = row.getCell(0).toString().trim();
            data[i][1] = row.getCell(1).toString().trim();
        }

        /*data[0][0] = "Rajesh";
        data[0][1] = "Tester";

        data[1][0] = "Swami";
        data[1][1] = "Test Lead";

        data[2][0] = "Manohar";
        data[2][1] = "Manager";

        data[3][0] = "Pradeep";
        data[3][1] = "HR";*/

        return data;
    }
}
