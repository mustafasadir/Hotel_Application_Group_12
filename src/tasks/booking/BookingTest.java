package tasks.booking;

import tasks.customer.Customer;
import tasks.room.Room;

import java.util.ArrayList;

public class BookingTest {
    public static void main(String[] args){
        ArrayList<Room> AvailableRooms = new ArrayList<Room>();
        Room Room1 = new Room(2,100,true);
        Room Room2 = new Room(1,75,false);
        Room Room3 = new Room(3,220,true);
        Room Room4 = new Room(2,110,true);
        Room Room5 = new Room(4,340,true);

        AvailableRooms.add(Room1);
        AvailableRooms.add(Room2);
        AvailableRooms.add(Room3);
        AvailableRooms.add(Room4);
        AvailableRooms.add(Room5);

        ArrayList<Customer> registeredCustomers = new ArrayList<Customer>();
        Customer Customer1 = new Customer("920404-1312","Alex","Solverborgsgatan 24A","0700224332");
        Customer Customer2 = new Customer("820404-1001","Peter","Äpplegatan 23S","0700229876");
        Customer Customer3 = new Customer("960214-7923","John","Centralen 12A","0700225637");
        Customer Customer4 = new Customer("970409-1972","Jack","Triangeln 43B","0700876234");
        Customer Customer5 = new Customer("990604-2334","Victor","Augustenborgsgatan 4D","0700209980");

        registeredCustomers.add(Customer1);
        registeredCustomers.add(Customer2);
        registeredCustomers.add(Customer3);
        registeredCustomers.add(Customer4);
        registeredCustomers.add(Customer5);


    }
}
