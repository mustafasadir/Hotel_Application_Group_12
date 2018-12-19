package tasks.customer;

import tasks.ReadWriteFile;

public class CustomerTest {
    public static void main(String[] args) {

        Customer testC = new Customer("","","","");
        Customer Customer1 = new Customer("920404-1312","Alex","Solverborgsgatan 24A","0700224332");
        Customer Customer2 = new Customer("820404-1001","Peter","Äpplegatan 23S","0700229876");
        Customer Customer3 = new Customer("960214-7923","John","Centralen 12A","0700225637");
        Customer Customer4 = new Customer("970409-1972","Jack","Triangeln 43B","0700876234");
        Customer Customer5 = new Customer("990604-2334","Victor","Augustenborgsgatan 4D","0700209980");

        ReadWriteFile rw = new ReadWriteFile();
        rw.writeObject(Customer1);
        rw.writeObject(Customer3);
        Customer customerFromFile = (Customer)  rw.readObject();
        System.out.println(Customer1.toString());
        System.out.println(Customer3.toString());


        //testC.viewArrivedCustomers();
        //testC.viewArrivedCustomers();
        //Arrived methods not used yet.
    }
}
