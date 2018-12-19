package tasks.login;

public class EmployeeUser extends Login {

    private static int employeeID;

    public EmployeeUser(String username, String password) {
        super(username, password);
        employeeID++;
        Users.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + "(Employee ID: " + employeeID + ")\n";
    }
}
