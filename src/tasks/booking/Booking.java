package src.tasks.booking;

import tasks.customer.Customer;

import javax.naming.Name;
import java.util.Scanner;

public class Booking {
    private int bookingId;
    private int totalPrice;
    private String checkInDate;
    private String checkOutDate;

    public Booking()
    {

    }
    public void searchBooking()
    {

    }
    public void checkOutCustomer()
    {

    }
    public void makeABooking() {
        Scanner input = new Scanner(System.in);
        Customer myCustomer = new Customer("920404-1312","Alex","Solverborgsgatan 24A","0700224332");
        System.out.println("Please input your ssn: ");
        String ssn = input.nextLine();

        while (!ssn.equals(myCustomer.getSsn())){
            System.out.println("Please input your ssn");
            ssn = input.nextLine();
            System.out.println("Available rooms are: " + );

        }




    }
    public void editBooking()
    {

    }

}
