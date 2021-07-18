package nl.novi.mariannat.payload.response;

/**Wordt aangeroepen wanneer het betrekking heeft op de demo **/

public class DemoResponse {

    private String message;

    public DemoResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
