public class Ride {
    private String rideName;
    private int minHeight; // Height limit
    private Employee operator; 

    // Default constructor
    public Ride() {
        this.rideName = "";
        this.minHeight = 0;
        this.operator = null;
    }

    public Ride(String rideName, int minHeight, Employee operator) {
        this.rideName = rideName;
        this.minHeight = minHeight;
        this.operator = operator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }
}