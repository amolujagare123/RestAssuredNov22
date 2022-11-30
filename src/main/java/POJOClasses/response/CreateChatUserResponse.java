package POJOClasses.response;



public class CreateChatUserResponse {

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    boolean error;

    Result result;


}
