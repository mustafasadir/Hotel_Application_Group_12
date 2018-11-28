package tasks.room;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println("Please input amount of beds: ");
        int bed;
        bed = input.nextInt();
        setNumberOfBeds(bed);

        System.out.println("Please input price per night: ");
        int price = input.nextInt();
        input.nextLine();
        setPricePerNight(price);

        System.out.println("Does the room have a balcony? (yes/no): ");
        boolean inputError;
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
        return "Room " + roomNumber + " has " + numberOfBeds + (numberOfBeds > 1 ? " beds " : " bed ") + "and " + (hasBalcony ? "one balcony. " : "no balcony. ")
                + "The price per night is: " + pricePerNight + " $";
    }


}
