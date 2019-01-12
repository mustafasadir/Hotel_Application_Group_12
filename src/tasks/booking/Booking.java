package tasks.booking;


import tasks.ReadWriteFile;
import tasks.customer.Customer;
import tasks.room.Room;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Booking {
    private  static int bookingId ;
    private int bookingNumber ;
    private int totalPrice;
    private String checkInDate;
    private Customer customer;
    private Room room ;
    Scanner input = new Scanner(System.in);
    ReadWriteFile rw = new ReadWriteFile();

    public Booking(String checkInDate, Customer customer , Room room)
    {
        this.bookingNumber= bookingId++;
        this.checkInDate = checkInDate;
        this.customer = customer;
        this.room = room ;


    }
    public void setcheckInDate(String checkInDate) { this.checkInDate = checkInDate; }


    public void viewBookingHistory(ArrayList<Customer> customers , ArrayList<Booking> bookings){


    }

    public void searchBooking(ArrayList<Booking> bookings)
    {

        System.out.println("Please enter your booking number: ");
        boolean inputError ;
        Booking booking  ;
        int bookingNbr = 0 ;


        do {
            try {
                bookingNbr = input.nextInt();
                booking = bookings.get(bookingNbr-1);
                System.out.println(booking.toString());
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number!");
                input.nextLine();
                inputError = true;
            }
            catch (IndexOutOfBoundsException e){
                input.nextLine();
                System.out.println("Booking does not exist, try another number");
                inputError = true;
            }
        }while (inputError);

        booking = bookings.get(bookingNbr-1);


    }
    public void checkOutCustomer( ArrayList<Room> rooms)
    {

        boolean inputError;
        int roomNbr = 0;
        Room room;
        String readRoomNbr;
        System.out.println("Please enter which room you were staying : ");


        do {
            try {
                do {
                    try {
                        readRoomNbr = input.nextLine();
                        roomNbr = Integer.valueOf(readRoomNbr);
                        inputError = false;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please input a positive real number!");
                        inputError = true;
                    }
                }while (inputError);

                room = rooms.get(roomNbr-1);
                //   System.out.println(room);
                inputError = false;
            }

            catch (IndexOutOfBoundsException e){
                System.out.println("Room does not exist, try another number");
                inputError = true;
            }

        }while (inputError);

        room = rooms.get(roomNbr-1);

        while (room.getIsAvailable() == true) {
            System.out.println("this room was already empty please enter the right room number!");
            readRoomNbr = input.nextLine();
            roomNbr = Integer.valueOf(readRoomNbr);
            room = rooms.get(roomNbr-1);
        }

        room.setIsAvailable(true);
        System.out.println("You succesfully checked out ! ");


    }

    public Booking makeABooking(ArrayList<Customer> customers, ArrayList<Room> rooms , ArrayList<Booking> bookings) {

        Scanner input = new Scanner(System.in);
        System.out.println(" Please enter the check-in date (dd/mm/yyyy)");
        checkInDate = input.nextLine();
        String ssnFormat = "[0-9]*/[0-9]*/[0-9]*";

        while (checkInDate.equals("") || !checkInDate.matches(ssnFormat) || checkInDate.length() < 10 || checkInDate.length() > 10){
            System.out.println("Please enter the check-in date (Date has to be written in the right format (dd/mm/yyyy)!)");
            checkInDate = input.nextLine();
            input.nextLine();
        }
        setcheckInDate(checkInDate);

/*
        for (Customer x:customers) {
            System.out.println(x);
        }
*/
        System.out.println("Please type in your customer number ?");
        Customer  customer ;
        boolean inputError ;
        int aCustomer  = 0;

        do {
            try {
                aCustomer = input.nextInt();
                customer = customers.get(aCustomer-1);
             //   System.out.println(customer);
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number!");
                input.nextLine();
                inputError = true;
            }
            catch (IndexOutOfBoundsException e){
                input.nextLine();
                System.out.println("Customer does not exist, try another number");
                inputError = true;
            }
        }while (inputError);

        customer = customers.get(aCustomer-1);
        System.out.println("Chosen customer: " + customer);
        System.out.println();


        int roomNbr = 0;
        Room room;
        String readRoomNbr;
        System.out.println("Which room do you want to choose (Input room number)");
        input.nextLine();
        for (Room x:rooms) {
            System.out.println(x);
        }

        do {
            try {
                do {
                    try {
                        readRoomNbr = input.nextLine();
                        roomNbr = Integer.valueOf(readRoomNbr);
                        inputError = false;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please input a positive real number!");
                        inputError = true;
                    }
                }while (inputError);

                room = rooms.get(roomNbr-1);
             //   System.out.println(room);
                inputError = false;
            }

            catch (IndexOutOfBoundsException e){
                System.out.println("Room does not exist, try another number");
                inputError = true;
            }

        }while (inputError);
        room = rooms.get(roomNbr-1);
        room.setIsAvailable(false);
        System.out.println("Chosen Room: " + room);

        Booking booking = new Booking(checkInDate,customer ,room);
        bookings.add(booking);
        rw.writeObject(booking);
        System.out.println();
        System.out.println("Booking created");

        return booking;
    }


    public void editBooking(ArrayList<Booking> bookings,ArrayList<Room> rooms)
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

        booking = bookings.get(bookingNbr-1);

        int choice = 0;
        String readChoice;
        Booking booking2;
        System.out.println("What would you like to change in this booking?");
        System.out.println("(1) Check-in date ");
        System.out.println("(2) Room number");
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
        while (choice <=0 || choice >  2) {
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
                System.out.println(" Please enter the check-in date (dd/mm/yyyy)");
                checkInDate = input.nextLine();
                String ssnFormat = "[0-9]*/[0-9]*/[0-9]*";

                while (checkInDate.equals("") || !checkInDate.matches(ssnFormat) || checkInDate.length() < 10 || checkInDate.length() > 10){
                    System.out.println("Please enter the check-in date (Date has to be written in the right format (dd/mm/yyyy)!)");
                    checkInDate = input.nextLine();
                    input.nextLine();
                }
                setcheckInDate(checkInDate);
                inputError = false;

                System.out.println("Check in date has been changed!");

            }while(inputError);
        }
        else{
            System.out.println("Please enter the room number: ");

            for (Room x : rooms) {
                System.out.println(x);
            }

            int roomNbr = 0;
            Room room;
            String readRoomNbr;

            do {
                try {
                    do {
                        try {
                            readRoomNbr = input.nextLine();
                            roomNbr = Integer.valueOf(readRoomNbr);
                            inputError = false;
                        }
                        catch (NumberFormatException e){
                            System.out.println("Please input a positive real number!");
                            inputError = true;
                        }
                    }while (inputError);

                    room = rooms.get(roomNbr-1);
                    System.out.println(room);
                    inputError = false;
                }

                catch (IndexOutOfBoundsException e){
                    System.out.println("Room does not exist, try another number");
                    inputError = true;
                }

            }while (inputError);

            this.room = rooms.get(roomNbr-1);

        }
    }
    @Override
    public String toString() {
        return "Booking number: "+bookingNumber+ " Check-in Date: "+checkInDate+"\n" +customer+
                "\n" +room;
    }


}
