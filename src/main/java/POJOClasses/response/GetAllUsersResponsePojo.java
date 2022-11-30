package POJOClasses.response;

import java.util.ArrayList;

public class GetAllUsersResponsePojo {
    boolean error;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ArrayList<Result> getResult() {
        return result;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    ArrayList<Result> result;
}
