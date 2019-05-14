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
    
    
    
    
}
