import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int minHeight; // Height limit
    private Employee operator;

    private Queue<Visitor> queue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

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
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Visitor is null. Can't add to queue");
            return;
        }

        if (visitor.getHeight() >= minHeight) {
            queue.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " added to the queue.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " cannot ride due to height limit.");
        }

    }

    @Override
    public void removeVisitorFromQueue() {

        if (!queue.isEmpty()) {
            Visitor removedVisitor = queue.poll();
            System.out.println("Visitor " + removedVisitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Queue is empty.");
        }

    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue of visitors:");
        for (Visitor visitor : queue) {
            System.out.println("ID:" + visitor.getVisitorID() + ", name: " + visitor.getName() + ", age:"
                    + visitor.getAge() + ", sex:" + visitor.getSex() +
                    "type:" + visitor.getVisitorType() + ", Height: " + visitor.getHeight());
        }

    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
         if (visitor == null) {
            System.out.println("Visitor is null. Can't add to queue");
            return;
        }

        //histroy from queue, so no need to check heigh

        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
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
    public void printRideHistory() {
        // TODO Auto-generated method stub

    }

    @Override
    public void runOneCycle() {
        // TODO Auto-generated method stub

    }

}