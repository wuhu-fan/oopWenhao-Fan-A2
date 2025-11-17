public class Visitor extends Person {
    private String visitorID;
    private String visitorType; 

    // Default constructor
    public Visitor() {
        super();
        this.visitorID = "";
        this.visitorType = "";
    }

    public Visitor(String name, int age, String sex, String visitorID, String visitorType) {
        super(name, age, sex);
        this.visitorID = visitorID;
        this.visitorType = visitorType;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(String visitorID) {
        this.visitorID = visitorID;
    }

    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

  
}