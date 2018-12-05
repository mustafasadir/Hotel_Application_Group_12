package tasks.customer;

public class CustomerTest {
    public static void main(String[] args) {
        Customer testC = new Customer("","","","");
        testC.addCustomer();
        testC.viewCustomers();
        testC.editCustomer();
        testC.viewCustomers();
        testC.removeCustomer();
        testC.viewCustomers();
    }
}
