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

    public void addRoom(){
        Scanner input = new Scanner(System.in);
        boolean inputError;

        System.out.println("Please input amount of beds: ");

        int bed = 0;

        //Checks if input is integer
        do {
            try {
                bed = input.nextInt();
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                input.nextLine();
                inputError = true;
            }
        }while (inputError);

        //Checks if input is inside range(1-5).
        while (bed <=0 || bed > 5){
            System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 2");

            //Checks if input is integer
            do {
                try {
                    bed = input.nextInt();
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 3");
                    input.nextLine();
                    inputError = true;
                }
            }while (inputError);
        }
        setNumberOfBeds(bed);
        //*************************************************************************
        System.out.println("Please input price per night: ");

        int price = 0;
        //Checks if input is integer.
        do {
            try {
                price = input.nextInt();
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                input.nextLine();
                inputError = true;
            }
        }while (inputError);


        //Checks if input is price range.
        while (price <= 0 || price >500){
            System.out.println("Value out of range. Price must be between 1 - 500$");

            //Checks if input is integer
            do {
                try {
                    price = input.nextInt();
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Value out of range. Price must be between 1 - 500$");
                    input.nextLine();
                    inputError = true;
                }
            }while (inputError);
        }
        setPricePerNight(price);
        //********************************************************************************
        System.out.println("Does the room have a balcony? (yes/no): ");
        String answer;
        do {
            input.nextLine();
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
    }

    public void removeRoom(){
        Scanner input = new Scanner(System.in);
        boolean inputError;
        int roomNbr = 0;

        System.out.println("Which room do you want to remove? (Input room number)");

        Room room;
        do {
            try {
                roomNbr = input.nextInt();
                room = rooms.get(roomNbr-1);
                System.out.println(room);
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

    public void viewRooms(){
        if (rooms.isEmpty()){
            System.out.println("No room in existence!");
        }
        else{
            for (Room a: rooms) {
                System.out.println(a);
            }
        }
    }

    public void viewAvailableRooms(){
        for (Room room : rooms) {
            if (room.getIsAvailable()){
                System.out.println(room);
            }
        }
    }

    public void editRoomInfo(){
        Scanner input = new Scanner(System.in);
        boolean inputError;
        int roomNbr = 0;

        System.out.println("Which rooms information do you want to change? (Input room number)");

        Room room;
        do {
            try {
                roomNbr = input.nextInt();
                room = rooms.get(roomNbr-1);
                System.out.println(room);
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

        System.out.println("Which of the below do you want to change?");
        System.out.println("1) Number of beds");
        System.out.println("2) Price per night");
        System.out.println("3) Availability");
        while (!input.hasNextInt()){
            input.next();
            System.out.println("Please input a positive real number! (1-3)");
        }
        int choice;
        choice = input.nextInt();

        while (choice <=0 || choice > 3){
            System.out.println("Please input a positive real number! (1-3)");
            choice = input.nextInt();
        }

        if (choice == 1){       // CHANGE BED NUMBER

            System.out.println("Please input amount of beds: ");
            int bed = 0;
            //Checks if input is integer
            do {
                try {
                    bed = input.nextInt();
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                    input.nextLine();
                    inputError = true;
                }
            }while (inputError);

            //Checks if input is inside range(1-5).
            while (bed <=0 || bed > 5){
                System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 2");

                //Checks if input is integer
                do {
                    try {
                        bed = input.nextInt();
                        inputError = false;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 3");
                        input.nextLine();
                        inputError = true;
                    }
                }while (inputError);
            }
            room.setNumberOfBeds(bed);

        }
        else if (choice == 2){      //CHANGE PRICE PER NIGHT
            System.out.println("Please input price per night: ");

            int price =0;

            //Checks if input is integer.
            do {
                try {
                    price = input.nextInt();
                    inputError = false;
                }
                catch (InputMismatchException e){
                    System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --) 1");
                    input.nextLine();
                    inputError = true;
                }
            }while (inputError);


            //Checks if input is price range.
            while (price <= 0 || price >500){
                System.out.println("Value out of range. Price must be between 1 - 500$");
                price = input.nextInt();
                input.nextLine();
            }
            room.setPricePerNight(price);
        }
        else {
            System.out.println("Is room available (yes/no)");
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
