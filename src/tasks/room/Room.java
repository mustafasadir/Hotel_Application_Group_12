package tasks.room;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private static int roomNumberCount;
    private int roomNumber;
    private int numberOfBeds;
    private int pricePerNight;
    private boolean hasBalcony;
    private boolean isAvailable;
    private ArrayList<Room> rooms = new ArrayList<>();


    public Room(int numberOfBeds, int pricePerNight, boolean hasBalcony) {
        this.roomNumber = roomNumberCount;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
        this.hasBalcony = hasBalcony;
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

    public void addRoom(){
        Scanner input = new Scanner(System.in);
        boolean inputError;

        System.out.println("Please input amount of beds: ");

        //Checks if input is integer.
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --)");
        }
        //Creates and initializes bed number.
        int bed;
        bed = input.nextInt();

        //Checks if input is inside range(1-5).
        while (bed <=0 || bed > 5){
            System.out.println("Please input a positive real number! (--NOTE: a room can have maximum 5 beds! --)");
            bed = input.nextInt();
        }

        setNumberOfBeds(bed);

        //****************************************************************

        System.out.println("Please input price per night: ");

        //Checks if input is integer.
        while (!input.hasNextInt()){
            input.next();
            System.out.println("Please input a positive real number! (Maximum price for a room is 500$.)");
        }

        //Creates and initializes price per night.
        int price = input.nextInt();
        input.nextLine();

        //Checks if input is price range.
        while (price <= 0 || price >500){
            System.out.println("Value out of range. Price must be between 0 - 500$");
            price = input.nextInt();
            input.nextLine();
        }
        setPricePerNight(price);

//-------------------------------------------------------------------------

        System.out.println("Does the room have a balcony? (yes/no): ");
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
    }

    public void viewRooms(){
        for (Room a: rooms) {
            System.out.println(a);
        }
    }


    @Override
    public String toString() {
        return "Room " + roomNumber + " has " + numberOfBeds + (numberOfBeds > 1 ? " beds " : " bed ")
                + "and " + (hasBalcony ? "one balcony. " : "no balcony. ")
                + "The price per night is: " + pricePerNight + " $";
    }


}
