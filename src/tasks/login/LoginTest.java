package tasks.login;

public class LoginTest {

    public static void main(String[] args) {
        EmployeeUser employeeUser = new EmployeeUser("mustafa","19981998");
        CustomerUser customerUser = new CustomerUser("Kalle","12345678");
        Login login = new Login("haha","haha");

        login.showLoginForm();






    }

}
