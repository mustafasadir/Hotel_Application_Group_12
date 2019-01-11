package tasks.customer;


import java.util.InputMismatchException;
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
        this.customerNumber = customerCount++;
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

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer addCustomer(){
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
        while (address.length() < 5 || address.length() > 25){
            System.out.println("Please enter valid address.(Address should contain max 50 characters!)");
            address = input.nextLine();
        }
        setAddress(address);

        System.out.println("Please enter customer's telephone number:(0700123456) ");
        String phoneNumber = input.nextLine();
        String phoneFormat = "[0-9]*";
        while (!phoneNumber.matches(phoneFormat) || phoneNumber.length() < 10 || phoneNumber.length() > 10){
            System.out.println("Please enter valid phone number.(Should contain 10 digits!)");
            phoneNumber = input.nextLine();
        }
        setPhoneNumber(phoneNumber);

        customerCount++;
        Customer customer = new Customer(personNummer,name,address,phoneNumber);
        customers.add(customer);
        return customer ;

   }
    public void viewCustomers(ArrayList<Customer> customers){
        for (Customer x: customers) {
            System.out.println(x);
        }
    }

    public void removeCustomer(ArrayList<Customer>customers){

        System.out.println("which customer to remove");
        int cus = input.nextInt();

        customers.remove(cus-1);

    }

    public void editCustomer(ArrayList<Customer> customers){
        String ssnFormat = "[0-9]*-[0-9]*";
        String nameFormat = "[a-zA-Z]* [a-zA-Z]*";
        String phoneFormat = "[0-9]*";


        Scanner input = new Scanner(System.in);
        boolean inputError;
        int  customerNbr = 0;

        System.out.println("Which customer information do you want to change? (Input customer number)");

        Customer customer;
        do {
            try {
                customerNbr = input.nextInt();
                customer = customers.get(customerNbr-1);
                System.out.println(customer);
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number!");
                input.nextLine();
                inputError = true;
            }
            catch (IndexOutOfBoundsException e){
                input.nextLine();
                System.out.println("Customer does not exist, try another number");
                inputError = true;
            }
        }while (inputError);

        customer = customers.get(customerNbr-1);

        System.out.println("Which of the below do you want to change?");
        System.out.println("1) Social Security Number");
        System.out.println("2) Name");
        System.out.println("3) Address");
        System.out.println("4) Telephone number");
        while (!input.hasNextInt()){
            input.next();
            System.out.println("Please input a positive real number! (1-4)");
        }
        int choice;
        choice = input.nextInt();

        while (choice <=0 || choice > 4){
            System.out.println("Please input a positive real number! (1-4)");
            choice = input.nextInt();
        }
        input.nextLine();

        if (choice == 1 ){
            System.out.println("Please enter customer's social security number(yyyymmdd-xxxx)");
            String personNummer = input.nextLine();

            while (personNummer.equals("") || !personNummer.matches(ssnFormat) || personNummer.length() < 13 || personNummer.length() > 13){
                System.out.println("Please enter valid social security number(yyyymmdd-xxxx))!");
                personNummer = input.nextLine();
            }
            customers.get(customerNbr-1).setSsn(personNummer);
        }

        else if (choice == 2){
            System.out.println("Please enter customer's full name:(firstName lastName) ");
            String name = input.nextLine();

            while (!name.matches(nameFormat)){
                System.out.println("Please enter valid name!");
                name = input.nextLine();
            }

            customers.get(customerNbr-1).setName(name);

        }
        else if (choice == 3){
            System.out.println("Please enter customer's address: ");
            String address = input.nextLine();
            //input.nextLine();
            while (address.length() > 50){
                System.out.println("Please enter valid address.(Address should contain max 50 characters!)");
                address = input.nextLine();
            }
            customers.get(customerNbr-1).setAddress(address);
        }
        else if (choice == 4){
            System.out.println("Please enter customer's telephone number:(0700123456) ");
            String phoneNumber = input.nextLine();

            while (!phoneNumber.matches(phoneFormat) || phoneNumber.length() < 10 || phoneNumber.length() > 10){
                System.out.println("Please enter valid phone number.(Should contain 10 digits!)");
                phoneNumber = input.nextLine();
            }
            customers.get(customerNbr-1).setPhoneNumber(phoneNumber);
        }


    }

    public void viewArrivedCustomers(ArrayList<Customer> customers){
        for (Customer x: customers){
            System.out.println(x.arrived);
        }
    }
    /*
    public void viewNotArrivedCustomers(){
        for (Customer x: customers){
            System.out.println(!x.arrived);
        }
    }
*/

    public void viewACustomer(ArrayList<Customer> customers){
        System.out.println("Which customer would you like to look for ?");
        Customer  customer ;
        boolean inputError ;
        int aCustomer  = 0;

        do {
            try {
                aCustomer = input.nextInt();
                customer = customers.get(aCustomer-1);
                System.out.println(customer);
                inputError = false;
            }
            catch (InputMismatchException e){
                System.out.println("Please input a positive real number!");
                input.nextLine();
                inputError = true;
            }
            catch (IndexOutOfBoundsException e){
                input.nextLine();
                System.out.println("Customer does not exist, try another number");
                inputError = true;
            }
        }while (inputError);

        customer = customers.get(aCustomer-1);

    }


    @Override
    public String toString() {
        return "Customer no: "+customerNumber+ " Customer's ssn: " +ssn+ " Name: "+name+ " Address: "+address+ " Phone Number: "+phoneNumber;
    }

}
