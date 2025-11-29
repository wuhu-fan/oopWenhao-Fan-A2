import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        this.numOfCycles = 0;
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
                count++;
            } else {
                System.out.println("Visitor " + visitor.getName() + " does not meet height limit.");
            }
        }
        System.out.println("Run one cycle finish.");
        // after one cycle
        numOfCycles++;
    }

    public void exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty.");
            return;
        }
        PrintWriter writer = null; // 声明在外面
        try {
            writer = new PrintWriter(filename);

            for (Visitor v : rideHistory) {
                String line = v.getName() + "," + v.getAge() + "," + v.getSex() + "," +
                        v.getVisitorID() + "," + v.getVisitorType() + "," + v.getHeight();
                writer.write(line + "\n");
            }
            System.out.println("Ride history exported to: " + filename);

        } catch (IOException e) {
            System.out.println("Error writing to file '" + filename + "': " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close(); // 必须关闭！否则文件可能为空
            }
        }
    }

    public void importRideHistory(String filename) {
        File file = new File(filename);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                // split by comma 
                String[] parts = line.split(",");

                // 6 fields
                if (parts.length != 6) {
                    System.out.println("Invalid line: " + line);
                    continue; 
                }

                try {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String sex = parts[2];
                    String visitorID = parts[3];
                    String visitorType = parts[4];
                    int height = Integer.parseInt(parts[5]);

                    Visitor visitor = new Visitor(name, age, sex, visitorID, visitorType, height);
                    addVisitorToHistory(visitor); 

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number in line: " + line);
                    continue;
                }
            }
            System.out.println("Ride history import from: " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found - " + filename);
        } finally {
            if (scanner != null) {
                scanner.close(); 
            }
        }
    }

}