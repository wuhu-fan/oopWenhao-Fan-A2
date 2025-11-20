public class Ride implements RideInterface {
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

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void printQueue() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void printRideHistory() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeVisitorFromQueue() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void runOneCycle() {
        // TODO Auto-generated method stub
        
    }

    


}