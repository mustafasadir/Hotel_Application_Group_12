package tasks.customer;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer {

    Scanner input = new Scanner(System.in);
    private  static int customerCount ;
    private int customerNumber ;
    private String ssn ;
    private String name ;
    private String address ;
    private String phoneNumber;
    private Boolean arrived;
    private ArrayList<Customer> customers = new ArrayList<>();


    public Customer(String ssn , String name , String address ,String phoneNumber){
        this.customerNumber = customerCount;
        this.ssn = ssn ;
        this.name = name ;
        this.address = address ;
        this.phoneNumber = phoneNumber ;
    }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public void setName(String name) { this.name = name; }

    public void setAddress(String address) { this.address = address; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setArrived(Boolean arrived) {this.arrived = arrived; }

    public String getSsn() {
        return ssn;
    }

    public void addCustomer(){
        System.out.println("Please enter customer's social security number(yyyymmdd-xxxx)");
        String personNummer = input.nextLine();
        String ssnFormat = "[0-9]*-[0-9]*";
        String nameFormat = "[a-zA-Z]* [a-zA-Z]*";


        while (personNummer.equals("") || !personNummer.matches(ssnFormat) || personNummer.length() < 13 || personNummer.length() > 13){
            System.out.println("Please enter valid social security number.(Social security number has to be written in the right format(yyyymmdd-xxxx))!");
            personNummer = input.nextLine();
        }
        setSsn(personNummer);

        System.out.println("Please enter customer's full name:(firstName lastName) ");
        String name = input.nextLine();
        while (!name.matches(nameFormat)){
            System.out.println("Please enter valid name!");
            name = input.nextLine();
        }
        setName(name);

        System.out.println("Please enter customer's address: ");
        String address = input.nextLine();
        while (address.length() < 10 || address.length() > 15){
            System.out.println("Please enter valid address.(Address should contain at least 10 characters and max 15 characters!)");
            address = input.nextLine();
        }
        setAddress(address);

        System.out.println("Please enter customer's telephone number:(07001234567) ");
        String phoneNumber = input.nextLine();
        String phoneFormat = "[0-9]*";
        while (!phoneNumber.matches(phoneFormat) || phoneNumber.length() < 11 || phoneNumber.length() > 11){
            System.out.println("Please enter valid phone number.(Should contain 11 digits!)");
            phoneNumber = input.nextLine();
        }
        setPhoneNumber(phoneNumber);

        customerCount++;
        Customer customer = new Customer(personNummer,name,address,phoneNumber);
        customers.add(customer);

   }
    public void viewCustomers(){
        for (Customer x: customers) {
            System.out.println(x);
        }
    }

    public void removeCustomer(){

        System.out.println("which customer to remove");
        int cus = input.nextInt();

        customers.remove(cus-1);

    }

    public void editCustomer(){

        System.out.println("which customer to edit");
        int editCustomerr = input.nextInt();

        System.out.println("new ssn");
        input.nextLine();
        String newSSN = input.nextLine();
        customers.get(editCustomerr-1).setSsn(newSSN);

        System.out.println("new name");
        String newName = input.nextLine();
        customers.get(editCustomerr-1).setName(newName);

        System.out.println("new address");
        String newAddress = input.nextLine();
        customers.get(editCustomerr-1).setAddress(newAddress);

        System.out.println("new phone");
        String newPhone = input.nextLine();
        customers.get(editCustomerr-1).setPhoneNumber(newPhone);


    }
    public void viewArrivedCustomers(){
        for (Customer x: customers){
            System.out.println(x.arrived);
        }
    }
    public void viewNotArrivedCustomers(){
        for (Customer x: customers){
            System.out.println(!x.arrived);
        }
    }

    @Override
    public String toString() {
        return "Customer no: "+customerNumber+ " Customer's ssn: " +ssn+ " Name: "+name+ " Address: "+address+ " Phone Number: "+phoneNumber;
    }

}
