/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import static javalabproject.Admin.adminInterface;

/**
 *
 * @author moadn
 */
public class Main {
    public static void main(String[] args) {
        
        Manager.managerInterfase();
   }

        
   

   

    public static  void startup(){
             Holiday j = new  Holiday("aaaaa");
       j.setDetails("no");
       j.setDate("11/8/888");
       j.setReason("no reason");
       System.out.println(j.toString());
       System.out.println("<<<<<<<Login Screen>>>>>>>");
        System.out.println("1- Admin");
        System.out.println("2- Manager");
        System.out.println("3- Employee");
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        switch(choice){
            case "1":             login("admin");
                break;
            case "2":             login("managers");
                break;
            case "3":             login("employee");
                break;            
                
       }  
    }
    
    public static boolean login(String fileName){
        Scanner s = new Scanner(System.in);
        System.out.println("2- Id");
        String id = s.nextLine();
        System.out.println("3- Password");
        String password=s.nextLine();
        validate(id, password, fileName);
        return true;
    };
    
    
    public static boolean validate(String id, String password, String fileName){
            if(fileName.equals("admin")){
                adminInterface();
            }
            if(fileName.equals("manager")){
            }
            if(fileName.equals("employeee")&& id.equals("1") && password.equals("efd")){
            }
            return false;
        }

    
    }
    

