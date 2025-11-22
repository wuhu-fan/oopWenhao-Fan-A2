public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();

        assignmentTwo.partThree();
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
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}

}
