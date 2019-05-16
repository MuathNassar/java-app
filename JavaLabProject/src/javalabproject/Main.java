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
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javalabproject.Admin.adminInterface;

/**
 *
 * @author moadn
 */
public class Main {
    public static void main(String[] args) {
     startup();
        
   }

        
   

   

    public static  void loginInterface(){
     
       
       System.out.println("<<<<<<<Login Screen>>>>>>>");
        System.out.println("1- Admin");
        System.out.println("2- Manager");
        System.out.println("3- Employee");
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        switch(choice){
            case "1": 
                
                break;
            case "2":  
            {
                String path = "manager.txt";
                System.out.println("Enter ID");
                String ID = s.nextLine();
                System.out.println("Enter Password");
                String password = s.nextLine();
                int id = Integer.parseInt(ID);
                validateStuff(id, password, path);
                
                
            }
                break;
            case "3": 
                {
                String path = "employee.txt";
                System.out.println("Enter ID");
                String ID = s.nextLine();
                System.out.println("Enter Password");
                String password = s.nextLine();
                int id = Integer.parseInt(ID);
                validateStuff(id, password, path);
                
            }
                break;            
                
       }  
    }
    
 
    
    
    public static boolean validateStuff(int id, String password, String path){
         boolean authentic = false;
         //start

   ArrayList<ArrayList> data = getFileData(path);
   for(ArrayList<String> row : data){
       System.out.println(row);
       if ((id+"").equalsIgnoreCase(row.get(1)) &&
               password.equals(row.get(5))  &&
               (row.get(11)+"").equalsIgnoreCase("1") )
       {
             authentic = true;             
             break;
       }else{ 
           System.out.println("Somthing is wrong . Please ask fo admin advice");
       }
       
   }
         
         //end
         return authentic;
        }

    private static void startup(){
       String path = "Admin.txt";
       ArrayList<ArrayList> data = getFileData(path);
        if (data.isEmpty()) {
           try {
               Scanner keyboard = new Scanner(System.in);
               FileWriter fileWriter = new FileWriter(new File(path), false);
               PrintWriter printWriter = new PrintWriter(fileWriter);
               //Entries
               System.out.println("Enter Admin ID please (Please Enter Numbers Only)");
               int  aId = keyboard.nextInt();
               keyboard.nextLine();
               System.out.println("Enter Admin name");
               String aName  = keyboard.nextLine();
               System.out.println("Enter Admin password");
               String aPassword = keyboard.nextLine();
               printWriter.println("ID: "+aId +" "+"NAME: "+aName +" "+"PASSWORD: "+ aPassword + " ;");
               printWriter.close();
           } catch (IOException ex) {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               
           }
           loginInterface();
        }else{
            loginInterface();
        }
        
        
    }
    private static ArrayList<ArrayList> getFileData(String path){
        File file = new File(path);
        
        //
         ArrayList<ArrayList> allRows = new ArrayList<>();   
         ArrayList<String> row = new ArrayList<>();
try {
        Scanner token = new Scanner(file);
        while(token.hasNext()){
            
            String x=token.next();
            
            if (!x.equals(";")) {
                row.add(x);
            }else{
                allRows.add((ArrayList) row.clone());
               row.clear();
                
            }
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
        
      return allRows;
        //
        
        
    }
    }
    

