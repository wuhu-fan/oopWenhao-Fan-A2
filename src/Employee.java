public class Employee extends Person {
    private String employeeId;
    private String role; 

    public Employee() {
        super(); // calls Person's default constructor
        this.employeeId = "";
        this.role = "";
    }

    public Employee(String name, int age, String email, String employeeId, String role) {
        super(name, age, email);
        this.employeeId = employeeId;
        this.role = role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}