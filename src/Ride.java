import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Ride implements RideInterface {
    private String rideName;
    private int minHeight; // Height limit
    private Employee operator;

    private Queue<Visitor> queue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    private int maxRider;
    private int numOfCycles;

    // Default constructor
    public Ride() {
        this.rideName = "";
        this.minHeight = 0;
        this.operator = null;
        this.maxRider = 1;
        numOfCycles = 0;
    }

    public Ride(String rideName, int minHeight, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.minHeight = minHeight;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0; // update by method
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
            System.out.println("Visitor is null. Can't add to hisitory");
            return;
        }

        // histroy from queue, so no need to check heigh

        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Visitor is null. Can't check");
            return false;
        }
        if (rideHistory.contains(visitor)) {
            System.out.println("Visitor is in the ride history:" + rideName);
            return true;
        }

        return false;
    }

    @Override
    public int numberOfVisitors() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " Ride history is empty.");
            return 0;
        }
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " Ride history is empty.");
            return;
        }
        System.out.println(rideName + " Ride history:");
        Iterator<Visitor> iterator = rideHistory.iterator(); // MUST use Iterator (requirement)
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println("ID:" + visitor.getVisitorID() + ", name: " + visitor.getName() + ", age:"
                    + visitor.getAge() + ", sex:" + visitor.getSex() +
                    "type:" + visitor.getVisitorType() + ", Height: " + visitor.getHeight());
        }
    }

    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " Ride history is empty.");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Finish Sorting.");
    }

    @Override
    public void runOneCycle() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int count = 0;
        while (!queue.isEmpty() && count < maxRider) {
            Visitor visitor = queue.poll();
            if (visitor.getHeight() >= minHeight) {
                addVisitorToHistory(visitor); // add to history
                System.out.println("Visitor: " + visitor.getName() + " is add to history.");
                count++;
            } else {
                System.out.println("Visitor " + visitor.getName() + " does not meet height limit.");
            }
        }
        // after one cycle
        numOfCycles++;
    }

}