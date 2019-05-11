/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

/**
 *
 * @author m-a-s
 */
public class Admin{
String id ;
String password;
    public Admin(String id, String password) {
        this.id=id;
        this.password=password;
    }
    public static void addManager(){
        System.out.println("enter id ");
    }
    public static void adminInterface(String id, String password, String fileName){
        System.out.println("Add Manager");
        addManager();
        
        
    }
}
