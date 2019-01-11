package tasks;

import tasks.booking.Booking;
import tasks.customer.Customer;
import tasks.login.CustomerUser;
import tasks.login.EmployeeUser;
import tasks.login.Login;
import tasks.room.Room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    Room myRoom = new Room(1,1,false);


    Customer myCustomer = new Customer("12345678-1234","Jane Doe","Kristianstad",
            "0723049586");
    Booking mybooking = new Booking("1",myCustomer,myRoom);
    public static void main(String[] args) {
        Main myApp = new Main();


        Customer myCustomer1 = new Customer("12345678-4321","Anna Petersson","Elmetorspvägen",
                "0723041234");
        Customer myCustomer2 = new Customer("98765432-1234","Eric Svensson","Malmö",
                "0723049586");
        Customer myCustomer3 = new Customer("74654542-6464","John Watson","Faltvägen",
                "0723041234");

        customers.add(myCustomer1);
        customers.add(myCustomer2);
        customers.add(myCustomer3);

        Room room1 = new Room(2,200,true);
        Room room2 = new Room(3,250,true);
        Room room3= new Room(1,150,false);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);


        EmployeeUser employeeUser = new EmployeeUser("mustafa","19981998");
        CustomerUser customerUser = new CustomerUser("kalle","12345678");
        Login login = new Login("haha","haha");

        boolean menuChoice = login.showLoginForm();

        if (menuChoice){
            myApp.showEmployeeMenu();
        }
        else{
            myApp.showCustomerMenu();
        }

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
        Scanner input = new Scanner(System.in);
        int operationChoice;
        do {
            System.out.println("--- MAIN MENU ---");
            System.out.println("1) Make a booking");
            System.out.println("2) Check availability");
            System.out.println("3) View booking history");
            System.out.println("4) Edit Profile");
            System.out.println("5) Exit");

            System.out.println("Please select an operation (1-5):");

            //Checks to see if input is integer
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Please input a positive real number! (1-5)");
            }
            //Creates and initializes choice

            operationChoice = input.nextInt();

            //Checks if input is inside range(1-5).
            while (operationChoice <=0 || operationChoice > 5){
                System.out.println("Please input a positive real number! (1-5)");
                operationChoice = input.nextInt();
            }

            if (operationChoice == 1){
              mybooking.makeABooking(customers,rooms);
            }
            else if (operationChoice == 2){
                myRoom.viewAvailableRooms(rooms);
            }
            else if (operationChoice == 3){

            }

            else if (operationChoice == 4){
                myCustomer.viewCustomers(customers);
                myCustomer.editCustomer(customers);
            }
            else {
                showEmployeeMenu();
            }
        }while (operationChoice != 5);



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
        int choice = 0;
        boolean inputError;
        do {
            Customer myCustomer = new Customer("","","","");
            Scanner input = new Scanner(System.in);
            System.out.println("--- CUSTOMER OPTIONS ---");
            System.out.println("1) View all customers");
            System.out.println("2) Search a customer");
            System.out.println("3) Add a customer");
            System.out.println("4) Remove a customer");
            System.out.println("5) Edit customer's information");
            System.out.println("6) Exit customer menu");

            System.out.println("Please select an operation (1-6):");
            //checks if input is an integer.
            do {
                try {
                    choice = input.nextInt();
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Please input a positive real number! (1-6)");
                    input.nextLine();
                    inputError = true;
                }
            }while (inputError);


            //Checks if input is inside range(1-6).
            while (choice <1 || choice > 6){
                System.out.println("Please input a positive real number! (1-6)");
                choice = input.nextInt();
            }

            if (choice == 1){
                System.out.println("1) View arrived customers (view checked in customers)");
                System.out.println("2) View all customers");
                System.out.println("3) Return to customer menu");
                int arrived = input.nextInt();
                 input.nextLine();
                if (arrived == 1){
                myCustomer.viewArrivedCustomers(customers);
                }
                else if (arrived == 2){
                    myCustomer.viewCustomers(customers);
                }
                else if (arrived == 3){
                    showCustomerOptions();
                }
            }
            else if (choice == 2){

                    myCustomer.viewACustomer(customers);

            }
            else if (choice == 3){

                    Customer customer = myCustomer.addCustomer();
                    customers.add(customer);

            }
            else if (choice == 4){
                    myCustomer.viewCustomers(customers);
                    myCustomer.removeCustomer(customers);

            }

            else  if (choice == 5){
                myCustomer.viewCustomers(customers);
                myCustomer.editCustomer(customers);
            }
            else {
                //Code to return to CUSTOMER MENU
                showEmployeeMenu();
            }
        } while (choice != 6);



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
