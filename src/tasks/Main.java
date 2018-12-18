package tasks;

import tasks.customer.Customer;
import tasks.room.Room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Main myApp = new Main();
        ArrayList<Customer> customer = new ArrayList<>();
        Room myRoom = new Room(1,1,false);

        myApp.showEmployeeMenu();

    }

    public void showEmployeeMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("---- MAIN MENU ----");
        System.out.println("1) Booking options");
        System.out.println("2) Customer options");
        System.out.println("3) Room options");
        System.out.println("4) Check-in");
        System.out.println("5) Check-out");

        System.out.println("Please select an operation (1-5):");

        //Checks to see if input is integer
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Please input a positive real number! (1-5)");
        }
        //Creates and initializes choice
        int operationChoice;
        operationChoice = input.nextInt();

        //Checks if input is inside range(1-5).
        while (operationChoice <=0 || operationChoice > 5){
            System.out.println("Please input a positive real number! (1-5)");
            operationChoice = input.nextInt();
        }

        if (operationChoice == 1){
            showBookingOptions();
        }
        else if (operationChoice == 2){
            showCustomerOptions();
        }
        else if (operationChoice == 3){
            showRoomOptions();
        }
        else if (operationChoice == 4){
            checkIn();
        }
        else {
            checkOut();
        }


    }

    public void showCustomerMenu(){
        System.out.println("--- MAIN MENU ---");
        System.out.println("1) Make a booking");
        System.out.println("2) Check availability");
        System.out.println("3) View booking history");
        System.out.println("4) Edit Profile");
    }

    public void showBookingOptions(){
        System.out.println("---- BOOKING OPTIONS ----");
        System.out.println("1) Create booking");
        System.out.println("2) View bookings");
        System.out.println("3) Search booking");
        System.out.println("4) Edit booking");
        System.out.println("5) Exit booking menu");


    }

    public void showCustomerOptions(){
        Customer myCustomer = new Customer("","","","");
        Scanner input = new Scanner(System.in);
        System.out.println("--- CUSTOMER OPTIONS ---");
        System.out.println("1) View all customers");
        System.out.println("2) Search customer");
        System.out.println("3) Add customer");
        System.out.println("4) Remove customer");
        System.out.println("5) Exit customer menu");

        System.out.println("Please select an operation (1-5):");

        //Checks if input is integer.
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Please input a positive real number! (1-5)");
        }

        //Creates and initializes choice number.
        int choice;
        choice = input.nextInt();

        //Checks if input is inside range(1-5).
        while (choice <=1 || choice > 5){
            System.out.println("Please input a positive real number! (1-5)");
            choice = input.nextInt();
        }

        if (choice == 1){
            System.out.println("1) View arrived customers (view checked in customers)");
            System.out.println("2) View not arrived customers (view customers that have not checked in)");
            System.out.println("3) Return to customer menu");
            int arrived = input.nextInt();

            if (arrived == 1){

            }
            else if (arrived == 2){

            }
            else if (arrived == 3){

            }
        }
        else if (choice == 2){
            System.out.println("1) View information");
            System.out.println("2) Edit information");
            System.out.println("3) Return to customer menu");
            int view = input.nextInt();
            if (view == 1 ){
                myCustomer.viewCustomers();
            }
            else if (view == 2){
                myCustomer.editCustomer();
            }
            else if (view == 3){

            }

        }
        else if (choice == 3){
            // Code to add customer
            myCustomer.addCustomer();
        }
        else if (choice == 4){
            //Code to remove customer
            myCustomer.removeCustomer();
        }
        else if (choice == 5){
            //Code to return to CUSTOMER MENU
        }


    }

    public void showRoomOptions(){
        boolean inputError;
        int choice =0;
        do {

            Scanner input = new Scanner(System.in);
            System.out.println("--- ROOM OPTIONS ---");
            System.out.println("1) View all rooms");
            System.out.println("2) View available rooms");
            System.out.println("3) Add room");
            System.out.println("4) Edit Room");
            System.out.println("5) Remove room");
            System.out.println("6) Exit room options");

            System.out.println();
            System.out.println("Please select an operation (1-6) :");

            Room myRoom = new Room(1,1,true);

            do {
                try {
                    choice = input.nextInt();
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Please input a positive real number! (1-5)");
                    input.nextLine();
                    inputError = true;
                }
            }while (inputError);

            while (choice <=0 || choice > 6){
                System.out.println("Please input a positive real number! (1-6)");
                choice = input.nextInt();
            }

            if (choice == 1){
                myRoom.viewRooms(rooms);
            }
            else if (choice == 2){
                myRoom.viewAvailableRooms(rooms);
            }
            else if (choice == 3){
                Room room = myRoom.addRoom();
                rooms.add(room);
            }
            else if(choice == 4){
                myRoom.editRoomInfo(rooms);
            }
            else if (choice == 5){
                myRoom.removeRoom(rooms);
            }
            else{
                showEmployeeMenu();
            }
        }while (choice != 6);
    }

    public void checkIn(){
        //Code to check in
    }

    public void checkOut(){
        //code to check out
    }
}
