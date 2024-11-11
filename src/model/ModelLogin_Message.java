package model;

public class ModelLogin_Message {

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModelLogin_Message(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ModelLogin_Message() {
    }

    private boolean success;
    private String message;
}
