package tasks;

import tasks.customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWriteFile {

    public static void writeObject(Object myObject){
        File file = new File("C:\\dev\\gitprojects\\Hotel_Application_Group_12\\bookingInfo.data");
        try {
            ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(file));
            outFile.writeObject(myObject);
        } catch (FileNotFoundException ex){
            System.out.println("File not found!");
        }
        catch (IOException e){}

    }

    public static Object readObject(){

        Object  objFromFile = null ;
        File file = new File("C:\\dev\\gitprojects\\Hotel_Application_Group_12\\bookingInfo.data");

        try {
            ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(file));
            objFromFile = inFile.readObject();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }catch (IOException e){}
        catch (ClassNotFoundException e){}


        return objFromFile ;
    }


}
