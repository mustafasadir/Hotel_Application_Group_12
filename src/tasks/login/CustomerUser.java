package tasks.login;

public class CustomerUser extends Login{

    private static int customerID;

    public CustomerUser(String username, String password) {
        super(username, password);
        customerID++;
        Users.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + "(Customer ID: " + customerID + ")\n";
    }
}
