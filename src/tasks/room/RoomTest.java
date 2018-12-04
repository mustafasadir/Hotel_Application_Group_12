package tasks.room;

import tasks.customer.Customer;

import java.util.ArrayList;

public class RoomTest {
    public static void main(String[] args) {
        ArrayList<Room> roomArrayList;

        Room testRoom = new Room(1,1,true);
        Customer testC = new Customer("","","","");
        testC.addCustomer();
        testC.viewCustomers();
        testC.editCustomer();
        testC.viewCustomers();
        testC.removeCustomer();
        testC.viewCustomers();
        testRoom.addRoom();
        testRoom.viewRooms();


        System.out.println("-------------------------------");

        testRoom.addRoom();
        testRoom.viewRooms();



    }
}
