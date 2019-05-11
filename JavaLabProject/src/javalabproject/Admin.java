/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author m-a-s
 */
public class Admin{
private int id ;
private String password;

    public Admin() {
    }

    public Admin(int id, String password) {
        this.id=id;
        this.password=password;
    }
    public void addManager(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Manager's ID:");
        int  mId = keyboard.nextInt();
        keyboard.nextLine();
        
        //new entery
        System.out.println("Enter Manager's name:");
        String mName = keyboard.nextLine();
        
        //new entery
        System.out.println("Enter Manager's password:");
        String mPassword = keyboard.nextLine();
        //new entery
        System.out.println("Enter Manager's email:");
        String mEmail = keyboard.nextLine();
        //new entery
        System.out.println("Enter Manager's phone number:");
        String mPhoneNumber = keyboard.nextLine();
       //new entery
        System.out.println("Enter Manager's status:");
        int mStatus = keyboard.nextInt();
      
    
        //End of entries
        new Manager(mId, mName, mPassword, mEmail, mPhoneNumber, mStatus);
        System.out.println("The manager "+ mName +" has been added successfully");
        
        
    }
    
     
    }


