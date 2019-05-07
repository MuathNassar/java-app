/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.util.Scanner;

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
        int choice = s.nextInt();
        switch(choice){
            case 1:             validate(12,"dfkcj", "admin");
                break;
            case 2:             validate(12,"dfkcj", "manager");
                break;
            case 3:             
                break;
                
       }
       
    } 
    public static boolean login(){
        return true;
    };
    public static boolean validate(int id, String password, String fileName){
            if(fileName.equals("admin")&& id ==1. && password.equals("efd")){
                Admin admin1 = new Admin(id, password);
            }
            if(fileName.equals("manager")&& id ==1. && password.equals("efd")){
                Admin admin1 = new Admin(id, password);
            }
            if(fileName.equals("employeee")&& id ==1. && password.equals("efd")){
                Admin admin1 = new Admin(id, password);
            }
            return false;
        }
    
}
