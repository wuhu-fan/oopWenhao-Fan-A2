public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();

        // assignmentTwo.partThree();
        // assignmentTwo.partFourA();
        assignmentTwo.partFourB();
    }

    public void partThree() {
        // Create a new Ride object
        Employee operator = new Employee("John", 30, "male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 140, operator);

        Visitor visitor1 = new Visitor("Alice", 25, "male","E001", "Single ticket", 150);
        Visitor visitor2 = new Visitor("Bob", 22, "female", "E002","Single ticket", 160);
        Visitor visitor3 = new Visitor("Charlie", 28, "male","E003", "VIP", 145);
        Visitor visitor4 = new Visitor("David", 24, "female", "E004","Annual pass", 170);
        Visitor visitor5 = new Visitor("Eve", 29, "male","E005", "Annual pass", 155);

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        rollerCoaster.removeVisitorFromQueue();

        System.out.println("After remove:");
        rollerCoaster.printQueue();

    }

    public void partFourA() {
         // Create a new Ride object
        Employee operator = new Employee("John", 30, "male", "E001", "Operator");
        Ride ferrisWheel = new Ride("Ferris Wheel", 140, operator);

        Visitor visitor1 = new Visitor("Alice", 25, "male","E001", "Single ticket", 150);
        Visitor visitor2 = new Visitor("Bob", 22, "female", "E002","Single ticket", 160);
        Visitor visitor3 = new Visitor("Charlie", 28, "male","E003", "VIP", 145);
        Visitor visitor4 = new Visitor("David", 24, "female", "E004","Annual pass", 170);
        Visitor visitor5 = new Visitor("Eve", 29, "male","E005", "Annual pass", 155);

        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);
        ferrisWheel.addVisitorToHistory(visitor4);
        ferrisWheel.addVisitorToHistory(visitor5);

        boolean isIN = ferrisWheel.checkVisitorFromHistory(visitor5);
        if (isIN) {
            System.out.println(visitor5.getName()+" is in the ride history.");
        }else{
            System.out.println(visitor5.getName()+" is not in the ride history.");
        }

        int num =  ferrisWheel.numberOfVisitors();
        System.out.println("The number of "+ferrisWheel.getRideName()+": "+num);

        ferrisWheel.printRideHistory();


    }


    public void partFourB() {
         // Create a new Ride object
        Employee operator = new Employee("John", 30, "male", "E001", "Operator");
        Ride thunderStorm = new Ride("Thunder Storm", 140, operator);

        Visitor visitor1 = new Visitor("Alice", 25, "male","E001", "Single ticket", 150);
        Visitor visitor2 = new Visitor("Jacket", 22, "female", "E002","Single ticket", 160);
        Visitor visitor3 = new Visitor("Alice", 28, "male","E003", "VIP", 145);
        Visitor visitor4 = new Visitor("Andy", 24, "female", "E004","Annual pass", 170);
        Visitor visitor5 = new Visitor("Macket", 29, "male","E005", "Annual pass", 155);

        thunderStorm.addVisitorToHistory(visitor1);
        thunderStorm.addVisitorToHistory(visitor5);
        thunderStorm.addVisitorToHistory(visitor4);
        thunderStorm.addVisitorToHistory(visitor2);
        thunderStorm.addVisitorToHistory(visitor3);

        thunderStorm.printRideHistory();
        thunderStorm.sortRideHistory();
        System.out.println("After sort by ID and Name:");
        thunderStorm.printRideHistory();

    }
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}

}
