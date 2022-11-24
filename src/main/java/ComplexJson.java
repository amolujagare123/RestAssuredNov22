import io.restassured.path.json.JsonPath;

public class ComplexJson {

    public static void main(String[] args) {


        String sampleJsonOutput = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"scriptinglogic.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "     {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "       \n" +
                "  ]\n" +
                "}";


        JsonPath jsonPath = new JsonPath(sampleJsonOutput);

        // 1. print total number of courses
        int numberOfCourses = jsonPath.getInt("courses.size()");

        System.out.println("numberOfCourses="+numberOfCourses);

        // 2. print purchase amount
        int purchaseAmount = jsonPath.get("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);

        // 3. print the title of first course
        String title = jsonPath.getString("courses[0].title");
        System.out.println("title="+title);

        // 4. print all courses title and their respective prices
        System.out.println("Below are the courses with their prices");

        for (int i=0;i<numberOfCourses;i++)
        {
            String courseTitle = jsonPath.getString("courses["+i+"].title");
            int coursePrice = jsonPath.get("courses["+i+"].price");

            System.out.println(courseTitle+"="+coursePrice);
        }

        // 5. print the price of RPA course
        for (int i=0;i<numberOfCourses;i++) {
            String courseTitle = jsonPath.getString("courses[" + i + "].title");
            int coursePrice=0;
            if (courseTitle.equalsIgnoreCase("RPA"))
            {
                coursePrice  = jsonPath.get("courses["+i+"].price");
                System.out.println(courseTitle+"="+coursePrice);
            }

        }

        // 6. Verify if Sum of all Course prices matches with Purchase Amount

        int sum = 0;
        for (int i=0;i<numberOfCourses;i++)
        {
            int coursePrice  = jsonPath.get("courses["+i+"].price");
            int courseCopies  = jsonPath.get("courses["+i+"].copies");
            int total = coursePrice * courseCopies;
            sum = sum + total;
        }

        System.out.println("purchaseAmount="+purchaseAmount);
        System.out.println("sum="+sum);

        if(purchaseAmount==sum)
            System.out.println("Pricing is correct");
        else
            System.out.println("Pricing is incorrect");


        }
}
