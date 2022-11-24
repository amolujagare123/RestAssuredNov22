package payload;

public class ChatServerPayload {



    public static String createUserPayload()
    {
        return "{\n" +
                "  \"username\": \"prathamesh122\",\n" +
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
                "}";
    }

    public static String createUserPayload(String username,String password,
                                           String email,String name,
                                           String surname,String nickName)
    {
        return "{\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"surname\": \""+surname+"\",\n" +
                "  \"chat_nickname\": \""+nickName+"\",\n" +
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
                "}";
    }
}
