package tasks.login;


import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private String username;
    private String password;
    public static ArrayList<Login> Users = new ArrayList<>();

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean showLoginForm(){
        Scanner input = new Scanner(System.in);

        System.out.println("Username: ");
        String readUsername = input.nextLine();
        // Checks for letters and empty spaces and format
        while (readUsername.equals("") ||  readUsername.length() < 1 || readUsername.length() > 50){
            System.out.println("Invalid username! (Username must be between 1-50 letters.) ");
            readUsername = input.nextLine();
        }

        boolean usernameError = true;
        int usernameIndex = 0;
        do {
            for (int i = 0; i <Users.size() ; i++) {
                if (Users.get(i) instanceof EmployeeUser && Users.get(i).getUsername().equals(readUsername)){
                    System.out.println("This user is an employee with the index " + i);
                    usernameIndex = i;
                    usernameError= false;
                }
                else if (Users.get(i) instanceof CustomerUser && Users.get(i).getUsername().equals(readUsername)){
                    System.out.println("This user is a customer with the index " + i);
                    usernameIndex = i;
                    usernameError = false;
                }
            }
            if (usernameError){
                System.out.println("Username not found, please try again!");
                readUsername = input.nextLine();
            }
        }while (usernameError);


        System.out.println("Password:");
        String readPassword = input.nextLine();
        // Checks for letters and empty spaces
        while (readPassword.equals("") ||  readPassword.length() < 1 || readPassword.length() > 50){
            System.out.println("Invalid password! (Password must be between 1-50 characters.) ");
            readPassword = input.nextLine();
        }

        boolean passwordError = true;
        do {
            for (int i = 0; i <Users.size() ; i++) {
                if (Users.get(i) instanceof EmployeeUser && Users.get(i).getPassword().equals(readPassword)){
                    System.out.println("This user is an employee with the index " + i);
                    passwordError = false;
                }
                else if (Users.get(i) instanceof CustomerUser && Users.get(i).getPassword().equals(readPassword)){
                    System.out.println("This user is a customer with the index " + i);
                    passwordError = false;
                }
            }
            if (passwordError){
                System.out.println("Password not found, please try again!");
                readPassword = input.nextLine();
            }
        }while (passwordError);

        boolean isEmployee = false;
        if (Users.get(usernameIndex) instanceof EmployeeUser) {
            isEmployee = true;
        }
        else if (Users.get(usernameIndex) instanceof CustomerUser){
            isEmployee = false;
        }
        System.out.println(Users.get(usernameIndex));
        // If returned value is true it is an employee else is it a customer.
        return isEmployee;
    }

    public  ArrayList<Login> getUsers() {
        return Users;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Welcome " + username;
    }
}
