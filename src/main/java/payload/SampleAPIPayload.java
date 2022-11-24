package payload;

public class SampleAPIPayload {

    public static String createSampleUserPayLoad()
    {
        return "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }

    public static String createSampleUserPayLoad(String name,String job)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }
}
