package tasks.customer;

public class CustomerTest {
    public static void main(String[] args) {
        Customer testC = new Customer("","","","");
        testC.addCustomer();
        testC.addCustomer();
        testC.viewCustomers();
        testC.editCustomer();
        testC.viewCustomers();
        testC.removeCustomer();
        testC.viewCustomers();
        //testC.viewArrivedCustomers();
        //testC.viewArrivedCustomers();
        //Arrived methods not used yet.
    }
}
