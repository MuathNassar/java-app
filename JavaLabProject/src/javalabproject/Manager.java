/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moadn
 */
public class Manager {
    
   
    int id;
    String name;
    String password;
    String email;
    String phoneNumber;
    int status;


    
    //Constructor to make Managers >>> Created by Muath

    public Manager(int id, String name, String password, String email, String phoneNumber, int status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        
        //Write information of manager to txt file
        
        
    }
    public void managerInterfase(){
        
    }
    
//    System.out.println("<<<<<<<Login Screen>>>>>>>");
//        System.out.println("1- Admin");
//        System.out.println("2- Manager");
//        System.out.println("3- Employee");
//        Scanner s = new Scanner(System.in);
//        String choice = s.nextLine();
//        switch(choice){
//            case "1":             login("admin");
//                break;
//            case "2":             login("managers");
//                break;
//            case "3":             login("employee");
//                break;            
//                
//       }
    //area to try start
//   Employee e = new Employee(1);
//        e.timeOfDeparture();

    //area to try end   

    } 
    
//    public static boolean login(String fileName){
//        Scanner s = new Scanner(System.in);
//        System.out.println("2- Id");
//        String id = s.nextLine();
//        System.out.println("3- Password");
//        String password=s.nextLine();
//        validate(id, password, fileName);
//        return true;
//    };
//    
//    
//    public static boolean validate(String id, String password, String fileName){
//            if(fileName.equals("admin")){
//                adminInterface();
//            }
////            if(fileName.equals("manager")&& id.equals(1) && password.equals("efd")){
////                Admin admin1 = new Admin(id, password);
////            }
////            if(fileName.equals("employeee")&& id.equals("1") && password.equals("efd")){
////                Admin admin1 = new Admin(id, password);
////            }
//            return false;
//        }

    
    
    
//}
