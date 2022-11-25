package ChatServer;

import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayload.createUserPayload;

public class CharServerCreatUserWithDataProviderEx {

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
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("Data/myData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("chat server");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for (int j=0;j<colCount;j++) {

                XSSFCell cell = row.getCell(j);

                if (cell==null)
                    data[i][j] = "";
                else {
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.toString().trim();
                }
            }

        }

        return data;
    }
}
