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
int id ;
String password;
    public Admin(int id, String password) {
        this.id=id;
        this.password=password;
    }
    public static void addManager(){
        System.out.println("enter id ");
    }
    public static void admin(){
        System.out.println("Add Manager");
        addManager();
        
        
    }
}
