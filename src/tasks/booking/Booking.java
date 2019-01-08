package tasks.booking;


import tasks.customer.Customer;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.ArrayList;

public class Booking {
    private int bookingId;
    private int totalPrice;
    private String checkInDate;
    private String checkOutDate;

    private ArrayList<Booking> bookings = new ArrayList<>();


    public Booking()
    {

    }
    public void setcheckInDate(String checkInDate) { this.checkInDate = checkInDate; }

    public void setcheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate;}

    public void searchBooking()
    {

    }
    public void checkOutCustomer()
    {

    }
    public void makeABooking() {

        Scanner input = new Scanner(System.in);
        Customer myCustomer = new Customer("920404-1312","Alex","Solverborgsgatan 24A","0700224332");
        System.out.println("Please input your ssn: ");
        String ssn = input.nextLine();

        while (!ssn.equals(myCustomer.getSsn())){
            System.out.println("Please input your ssn");
            ssn = input.nextLine();

            System.out.println("Available rooms are: "  );

        }




    }
    public void editBooking(ArrayList<Booking> bookings)
    {
        Scanner input = new Scanner(System.in);
        boolean inputError;
        int bookingNbr = 0;
        Booking booking;
        String readBookingNbr;
        System.out.println("Which bookings information do you want to change? (Input booking number)");


        do {
            try {
                do {
                    try {
                        readBookingNbr = input.nextLine();
                        bookingNbr = Integer.valueOf(readBookingNbr);
                        inputError = false;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please input a positive real number!");
                        inputError = true;
                    }
                }while (inputError);

                booking = bookings.get(bookingNbr-1);
                System.out.println(booking);
                inputError = false;
            }

            catch (IndexOutOfBoundsException e){
                System.out.println("Booking does not exist, try another number");
                inputError = true;
            }

        }while (inputError);


        bookings.get(bookingNbr-1);
        int choice = 0;
        String readChoice;
        Booking booking2;
        System.out.println("What would you like to change in this booking?");
        System.out.println("(1) Check-in date ");
        System.out.println("(2) Check-out date ");
        //Checking first input number

        do {
            try {
                readChoice = input.nextLine();
                choice = Integer.valueOf(readChoice);
                inputError = false;
            }
            catch (NumberFormatException e){
                System.out.println("Please input a positive real number! (1-2)");
                inputError = true;
            }
        }while (inputError);


        // CHECKS IF INPUT IS INSIDE RANGE
        while (choice <=0 || choice >  1) {
            System.out.println("Please input a positive real number! (1-2)");
            do {
                try {
                    readChoice = input.nextLine();
                    choice = Integer.valueOf(readChoice);
                    inputError = false;
                } catch (NumberFormatException e) {
                    System.out.println("Please input a positive real number! (1-2)");
                    inputError = true;
                }
            } while (inputError);
        }
        //Check-in Date choice
        if (choice == 1){
            do {
                System.out.println("Enter a new check-in date");

                String answer = input.next();

                System.out.println("Confirm this new date? : " + answer);
                System.out.println("Enter an answer (yes/no)");
                String choice2 = input.next();
                if(choice2.equals("yes")){
                    inputError = false;
           //         booking.setCheckInDate(answer);
                }
                if(choice2.equals("no")){
                    inputError = true;
                }
                else{
                    System.out.println("Error: Unknown answer");
                    inputError = true;
                }

            }while(inputError);


            //Check-out Date choice
        }
        else if(choice == 2) {
            do {
                System.out.println("Enter a new check-out date");

                String answer = input.next();

                System.out.println("Confirm this new date? : " + answer);
                System.out.println("Enter an answer (yes/no) ");
                String choice2 = input.next();
                if(choice2.equals("yes")){
                    inputError = false;
          //          booking2.setCheckOutDate(answer);
                }
                else if(choice2.equals("no")){
                    inputError = true;
                }
                else{
                    inputError = true;
                }

            }while(inputError);
        }
    }

}
