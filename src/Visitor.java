public class Visitor extends Person {
    private String visitorID;
    private String visitorType; 
    private int height;

    // Default constructor
    public Visitor() {
        super();
        this.visitorID = "";
        this.visitorType = "";
        this.height = 0;
    }

    public Visitor(String name, int age, String sex, String visitorID, String visitorType, int height) {
        super(name, age, sex);
        this.visitorID = visitorID;
        this.visitorType = visitorType;
        this.height = height;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

  
}