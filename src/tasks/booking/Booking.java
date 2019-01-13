package tasks.booking;


import tasks.customer.Customer;
import tasks.room.Room;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Booking {
    private static int bookingIdCount;
    private int bookingId;
    private int totalPrice;
    private int totalDays;
    private String checkInDate;
    private Customer customer;
    private Room room;


    public Booking(String checkInDate, Customer customer, Room room, int totalDays) {
        this.bookingId = bookingIdCount++;
        this.checkInDate = checkInDate;
        this.customer = customer;
        this.room = room;
        this.totalDays = totalDays;
        int price = room.getPricePerNight();
        this.totalPrice = totalDays * price;
    }

    public void setcheckInDate(String checkInDate) { this.checkInDate = checkInDate; }

    public void searchBooking() {

    }

    public void checkOutCustomer() {

    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setTotalPrice(int days, int pricePerNight) {
        this.totalPrice = days * pricePerNight;
    }

    public Booking makeABooking(ArrayList<Customer> customers, ArrayList<Room> rooms) {

        Scanner input = new Scanner(System.in);
        boolean inputError;


        //CHOOSE DATE
        System.out.println("Please enter the check-in date (dd/mm/yyyy)");
        String readCheckInDate = input.nextLine();
        input.nextLine();
        String dateFormat = "[0-9]*/[0-9]*/[0-9]*";

        while (readCheckInDate.equals("") || !readCheckInDate.matches(dateFormat) || readCheckInDate.length() < 10 || readCheckInDate.length() > 10){
            System.out.println("Please enter the check-in date (Date has to be written in the right format (dd/mm/yyyy)!)");
            readCheckInDate = input.nextLine();
            input.nextLine();
        }

        for (Customer x:customers) {
            System.out.println(x);
        }

        System.out.println("Please type in your customer number ?");
        Customer  customer;
        int customerNbr  = 0;

        do {
            try {
                customerNbr = input.nextInt();
                customer = customers.get(customerNbr-1);
                System.out.println(customer);
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

        customer = customers.get(customerNbr-1);
        System.out.println("Chosen customer: " + customer);
        System.out.println();

        int roomNbr = 0;
        Room room;
        String readRoomNbr;
        System.out.println("Which room do you want to choose (Input room number)");

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
                System.out.println(room);
                inputError = false;
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Room does not exist, try another number");
                inputError = true;
            }

        }while (inputError);

        room = rooms.get(roomNbr-1);
        System.out.println("Chosen Room: " + room);

        // CHOOSE DAYS
        System.out.println("Please input the amount of days for the accommodation?");
        int days = 0;
        String readDays = "";

        //Checks if input is integer
        do {
            try {
                readDays = input.nextLine();
                days = Integer.valueOf(readDays);
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --)");
                input.nextLine();
                inputError = true;
            }
            catch (NumberFormatException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --)");
                inputError = true;
            }
        }while (inputError);

        //Checks if input is inside range(1-5).
        while (days <=0 || days > 100){
            System.out.println("Please input a positive real number! (1-100)");

            //Checks if input is integer
            do {
                try {
                    readDays = input.nextLine();
                    days = Integer.valueOf(readDays);
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Please input a positive real number! (1-100)");
                    input.nextLine();
                    inputError = true;
                }
                catch (NumberFormatException e){
                    System.out.println("Please input a positive real number! (1-100)");
                    inputError = true;
                }
            }while (inputError);
        }
        System.out.println();
        System.out.println("Accommodation is set to " + days + (days == 1 ? " day" : " days"));

        int roomIndex = rooms.indexOf(room);
        rooms.get(roomIndex).setIsAvailable(false);

        Booking booking = new Booking(readCheckInDate,customer ,room,days);
        System.out.println();
        System.out.println("Booking created");

        return booking;
    }

    public void viewBookings(ArrayList<Booking> bookings){
        for (Booking x : bookings) {
            System.out.println(x);
        }
        if (bookings.isEmpty()){
            System.out.println("No bookings in existence!");
        }
    }

    public void editBooking(ArrayList<Booking> bookings,ArrayList<Room> rooms) {
        Scanner input = new Scanner(System.in);
        boolean inputError;
        int bookingNbr = 0;
        Booking booking;
        String readBookingNbr;
        System.out.println("Which bookings information do you want to change? (Input booking ID)");

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
            String date;
            do {
                System.out.println("Please enter the check-in date (dd/mm/yyyy)");
                date = input.nextLine();
                String ssnFormat = "[0-9]*/[0-9]*/[0-9]*";

                boolean formatError = false;
                while (date.equals("") || !date.matches(ssnFormat) || date.length() < 10 || date.length() > 10){
                    System.out.println("Please enter the check-in date (Date has to be written in the right format! (dd/mm/yyyy) )");
                    date = input.nextLine();
                    input.nextLine();
                    formatError = true;
                }
                inputError = formatError;

                System.out.println("Check in date has been changed!");

            }while(inputError);
            booking.setcheckInDate(date);
        }
        //Change room number
        else{
            System.out.println("Please enter the room number to change to: ");

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
                // Changes the old room to available
                booking.room.setIsAvailable(true);
            }while (inputError);

            room = rooms.get(roomNbr-1);
            room.setIsAvailable(false);
            booking.setRoom(room);
            int price = room.getPricePerNight();
            int days = booking.getTotalDays();
            booking.setTotalPrice(days,price);

            System.out.println("Room has been changed!");
        }
    }

    @Override
    public String toString() {
        return  "Booking ID: " + bookingId + "\n" +
                "Customer Information: " + customer + "\n" +
                "Booked Room: " + room + "\n" +
                "Check in Date: " + checkInDate + "\n" +
                "Total days: " + totalDays + "\n" +
                "Total price: " + totalPrice + "$" + "\n" +
                "------------------------------------------------" + "\n";
    }
}