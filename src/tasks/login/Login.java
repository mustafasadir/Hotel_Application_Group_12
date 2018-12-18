package tasks.login;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private String username;
    private String password;
    private ArrayList<Login> accountList = new ArrayList<>();

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void showLoginForm(){
        Scanner input = new Scanner(System.in);

        System.out.println("Username: ");
        String readUsername = input.nextLine();
        String usernameFormat = "[A-Za-z]";

        // Checks for letters and empty spaces
        while (readUsername.equals("") || !readUsername.matches(usernameFormat) || readUsername.length() < 1 || readUsername.length() > 50){
            System.out.println("Invalid value! Username must be between 1-50 letters. ");
            readUsername = input.nextLine();
        }

        //Checks if username matches with input
        while (!readUsername.matches(getUsername())){
            System.out.println("Wrong username! Please try again: ");
            readUsername = input.nextLine();
        }

        System.out.println("Password:");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
