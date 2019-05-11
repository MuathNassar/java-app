/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.util.Scanner;
import java.lang.String;
import static javalabproject.Admin.adminInterface;

/**
 *
 * @author m-a-s
 */
public class JavaLabProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
            if(fileName.equals("admin")&& id.equals("1") && password.equals("efd")){
                adminInterface(id, password,fileName);
            }
            if(fileName.equals("manager")&& id.equals("1") && password.equals("efd")){
                Admin admin1 = new Admin(id, password);
            }
            if(fileName.equals("employeee")&& id.equals("1") && password.equals("efd")){
                Admin admin1 = new Admin(id, password);
            }
            return false;
        }
    
}
