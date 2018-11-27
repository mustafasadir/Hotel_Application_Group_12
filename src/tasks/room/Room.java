package tasks.room;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private static int roomNumberCount;
    private int roomNumber;
    private int numberOfBeds;
    private int pricePerNight;
    private boolean hasBalcony;
    private boolean isAvaiable;
    private ArrayList<Room> rooms = new ArrayList<>();


    public Room(int numberOfBeds, int pricePerNight, boolean hasBalcony) {
        roomNumberCount++;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
        this.hasBalcony = hasBalcony;
        this.roomNumber = roomNumberCount;
    }

    public void addRoom(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input amount of beds: ");
        int bed;
        bed = input.nextInt();
        bed = numberOfBeds;

        System.out.println("Please input price per night: ");
        int price = input.nextInt();
        price = pricePerNight;
        System.out.println();

        System.out.println("Does the room have a balcony? (yes/no): ");
        boolean inputError;
        do {
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")){
                hasBalcony = true;
                inputError = false;
            }
            else if (answer.equalsIgnoreCase("no")){
                hasBalcony = false;
                inputError = false;
            }
            else{
                System.out.println("Please input valid value!(yes/no)");
                inputError = true;
            }
        }while (inputError);

        Room room = new Room(bed,price,hasBalcony);
        rooms.add(room);
        System.out.println(rooms);
    }

    //This method returns the ArrayList
    public ArrayList<Room> getRooms(){
        return rooms;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " has " + numberOfBeds + (numberOfBeds > 1 ? " beds " : " bed ") + " and " + (hasBalcony ? "one balcony.\n " : "no balcony.\n ")
                + "The price per night is: " + pricePerNight;
    }
}
