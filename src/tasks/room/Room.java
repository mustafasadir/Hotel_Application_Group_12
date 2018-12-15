package tasks.room;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Room {
    private static int roomNumberCount;
    private int roomNumber;
    private int numberOfBeds;
    private int pricePerNight;
    private boolean hasBalcony;
    private boolean isAvailable;
    private ArrayList<Room> rooms = new ArrayList<>(); // all the created rooms

    public Room(int numberOfBeds, int pricePerNight, boolean hasBalcony) {
        this.roomNumber = roomNumberCount;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
        this.hasBalcony = hasBalcony;
        isAvailable = true;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room addRoom(){
        Scanner input = new Scanner(System.in);
        boolean inputError;

        System.out.println("Please input amount of beds: ");

        int bed = 0;
        String readBed = "";
        //Checks if input is integer
        do {
            try {
                readBed = input.nextLine();
                bed = Integer.valueOf(readBed);
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                input.nextLine();
                inputError = true;
            }
            catch (NumberFormatException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                inputError = true;
            }
        }while (inputError);

        //Checks if input is inside range(1-5).
        while (bed <=0 || bed > 5){
            System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 2");

            //Checks if input is integer
            do {
                try {
                    readBed = input.nextLine();
                    bed = Integer.valueOf(readBed);
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 3");
                    input.nextLine();
                    inputError = true;
                }
                catch (NumberFormatException e){
                    System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 3");
                    inputError = true;
                }
            }while (inputError);
        }
        setNumberOfBeds(bed);
        //*************************************************************************
        System.out.println("Please input price per night: ");

        int price = 0;
        String readPrice;
        //Checks if input is integer.
        do {
            try {
                readPrice = input.nextLine();
                price = Integer.valueOf(readPrice);
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                input.nextLine();
                inputError = true;
            }
            catch (NumberFormatException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                inputError = true;
            }
        }while (inputError);


        //Checks if input is price range.
        while (price <= 0 || price >500){
            System.out.println("Value out of range. Price must be between 1 - 500$");

            //Checks if input is integer
            do {
                try {
                    readPrice = input.nextLine();
                    price = Integer.valueOf(readPrice);
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Value out of range. Price must be between 1 - 500$");
                    input.nextLine();
                    inputError = true;
                }
                catch (NumberFormatException e){
                    System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                    inputError = true;
                }
            }while (inputError);
        }
        setPricePerNight(price);
        //********************************************************************************
        System.out.print("Does the room have a balcony? (yes/no): \n");
        String answer;
        do {
            answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")){
                setHasBalcony(true);
                inputError = false;
            }
            else if (answer.equalsIgnoreCase("no")){
                setHasBalcony(false);
                inputError = false;
            }
            else{
                System.out.println("Please input valid value!(yes/no)");
                inputError = true;
            }
        }while (inputError);


        roomNumberCount++;
        Room room = new Room(bed,price,hasBalcony);
        rooms.add(room);
        System.out.println("Room created!");
        return room;
    }

    public void removeRoom(ArrayList<Room> rooms){
        Scanner input = new Scanner(System.in);
        boolean inputError;
        int roomNbr = 0;

        System.out.println("Which room do you want to remove? (Input room number)");

        Room room;
        do {
            try {
                roomNbr = input.nextInt();
                room = rooms.get(roomNbr-1);
                System.out.println("Chosen room ------> " + room);
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number!");
                input.nextLine();
                inputError = true;
            }
            catch (IndexOutOfBoundsException e){
                input.nextLine();
                System.out.println("Room does not exist, try another number");
                inputError = true;
            }
        }while (inputError);

        room = rooms.get(roomNbr-1);
        rooms.remove(room);
        System.out.println("Room successfully removed.");
    }

    public void viewRooms(ArrayList<Room> rooms){
        if (rooms.isEmpty()){
            System.out.println("No room in existence!");
        }
        else{
            for (Room a: rooms) {
                System.out.println(a);
            }
        }
    }

    public void viewAvailableRooms(ArrayList<Room> rooms){
        for (Room room : rooms) {
            if (room.getIsAvailable()){
                System.out.println(room);
            }
        }
    }

    public void editRoomInfo(ArrayList<Room> rooms){
        Scanner input = new Scanner(System.in);
        boolean inputError;
        int roomNbr = 0;
        Room room;
        String readRoomNbr;
        System.out.println("Which rooms information do you want to change? (Input room number)");


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
        int choice = 0;
        String readChoice;

        System.out.println("Which of the below do you want to change?");
        System.out.println("1) Number of beds");
        System.out.println("2) Price per night");
        System.out.println("3) Availability");
        do {
            try {
                readChoice = input.nextLine();
                choice = Integer.valueOf(readChoice);
                inputError = false;
            }
            catch (NumberFormatException e){
                System.out.println("Please input a positive real number! (1-3)");
                inputError = true;
            }
        }while (inputError);


        // CHECKS IF INPUT IS INSIDE RANGE
        while (choice <=0 || choice > 3){
            System.out.println("Please input a positive real number! (1-3)");
            do {
                try {
                    readChoice = input.nextLine();
                    choice = Integer.valueOf(readChoice);
                    inputError = false;
                }
                catch (NumberFormatException e){
                    System.out.println("Please input a positive real number! (1-3)");
                    inputError = true;
                }
            }while (inputError);
        }

        if (choice == 1){       // CHANGE BED NUMBER

            System.out.println("Please input amount of beds: ");
            int bed = 0;
            String readBed;
            //Checks if input is integer
            do {
                try {
                    readBed = input.nextLine();
                    bed = Integer.valueOf(readBed);
                    inputError = false;
                }
                catch (NumberFormatException e){
                    System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                    inputError = true;
                }
            }while (inputError);

            //Checks if input is inside range(1-5).
            while (bed <=0 || bed > 5){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 2");

                //Checks if input is integer
                do {
                    try {
                        readBed = input.nextLine();
                        bed = Integer.valueOf(readBed);
                        inputError = false;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 3");
                        inputError = true;
                    }
                }while (inputError);
            }
            room.setNumberOfBeds(bed);

        }
        else if (choice == 2){      //CHANGE PRICE PER NIGHT
            System.out.println("Please input price per night: ");

            int price =0;
            String readPrice;

            //Checks if input is integer.
            do {
                try {
                    readPrice = input.nextLine();
                    price = Integer.valueOf(readPrice);
                    inputError = false;
                }
                catch (NumberFormatException e){
                    System.out.println("Please input a positive real number! (--NOTE: Price must be between 1 - 500$ --) ");
                    inputError = true;
                }
            }while (inputError);


            //Checks if input is price range.
            while (price <= 0 || price >500){
                System.out.println("Value out of range. Price must be between 1 - 500$");
                do {
                    try {
                        readPrice = input.nextLine();
                        price = Integer.valueOf(readPrice);
                        inputError = false;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please input a positive real number! (--NOTE: Price must be between 1 - 500$ --) ");
                        inputError = true;
                    }
                }while (inputError);
            }
            room.setPricePerNight(price);
        }
        else {
            System.out.println("Is room available (yes/no)");
            input.nextLine();
            String answer;

            do {
                answer = input.nextLine();
                if (answer.equalsIgnoreCase("yes")){
                    room.setIsAvailable(true);
                    inputError = false;
                }
                else if (answer.equalsIgnoreCase("no")){
                    room.setIsAvailable(false);
                    inputError = false;
                }
                else{
                    System.out.println("Please input valid value!(yes/no)");
                    inputError = true;
                }
            }while (inputError);
        }
    }


    @Override
    public String toString() {
        return "Room " + roomNumber + " has " + numberOfBeds + (numberOfBeds > 1 ? " beds " : " bed ")
                + "and " + (hasBalcony ? "one balcony. " : "no balcony. ")
                + "The price per night is: " + pricePerNight + " $" + (isAvailable ? " (Available)" : " (Occupied) ")
                ;
    }


}
