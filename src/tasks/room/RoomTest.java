package tasks.room;

public class RoomTest {
    public static void main(String[] args) {

        Room testRoom = new Room(1,1,true);

        testRoom.addRoom();
        testRoom.addRoom();
        testRoom.viewRooms();

        testRoom.editRoomInfo();
        testRoom.viewAvailableRooms();

    }
}
