package tasks.room;

import java.util.ArrayList;

public class RoomTest {
    public static void main(String[] args) {
        ArrayList<Room> roomArrayList;

        Room testRoom = new Room(1,1,true);
        testRoom.addRoom();
        testRoom.viewRooms();


        System.out.println("-------------------------------");

        testRoom.addRoom();
        testRoom.viewRooms();



    }
}
