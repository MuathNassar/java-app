/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m-a-s
 */
public class Admin{
private int id ;
private String password;
private static String mgrPath = "manager.txt";
private static File mgrFile = new  File(mgrPath);


    public Admin() {
    }

    public Admin(int id, String password) {
        this.id=id;
        this.password=password;
        
    }
    public static void addManager(){
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

  
    
    
    public static void updateManager(int id){
       
   ArrayList<ArrayList> data = getMgrFile();
   boolean isFound = false;
  
   for(ArrayList<String> row : data){
       
       if ((id+"").equalsIgnoreCase(row.get(1))){
             System.out.println("Entre new password:");
             Scanner keyboard = new Scanner(System.in);
             String newPassword = keyboard.nextLine();
             row.set(5,newPassword);
             
             writeRowsToFile(data);
             System.out.println("Manager "+row.get(3)+" has Been updated successfully");
             isFound = true; 
             break;
       }  
   }
   if(!isFound){System.out.println("There is no manager who has an ID = "+id);}
    }
    private static void writeRowsToFile(ArrayList<ArrayList> rows){
        ;
    try {
        File file = new File("managersUpdate.txt");//file temp
       FileWriter fw = new FileWriter(file,false);
        PrintWriter pw = new PrintWriter(fw);
        for(ArrayList<String> row : rows ){
            pw.println(row.get(0)+" "+row.get(1)+" "+row.get(2)+" "+row.get(3)+" "+row.get(4)+" "+row.get(5)+" "+row.get(6)+" "+row.get(7)+" "+row.get(8)+" "+row.get(9)+" "+row.get(10)+" "+row.get(11)+" ;");
        } 
        pw.flush();
        pw.close(); 
    } catch (IOException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }
    public static ArrayList<ArrayList> getMgrFile(){
    ArrayList<ArrayList> allRows = new ArrayList<>();   
    ArrayList<String> row = new ArrayList<>();
try {
        Scanner token = new Scanner(mgrFile);
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
    }
    public static void deleteManager(int id){
        
        
       ArrayList<ArrayList> data = getMgrFile();
       boolean isFound  = false;
  
   for(ArrayList<String> row : data){
       
       if ((id+"").equalsIgnoreCase(row.get(1))){
             String mgrName = row.get(3);
             data.remove(row);
            
             writeRowsToFile(data);
             System.out.println("Manager "+mgrName+" has Been deleted successfully");
             isFound = true;
             break;
       }
      
           
        
   }
   if(!isFound)
      {System.out.println("There is no manager who has an ID = "+id);}    
    }
    public static void searchForManager(int id){
         ArrayList<ArrayList> data = getMgrFile();
         boolean isFound = false;
  
   for(ArrayList<String> row : data){
       
       if ((id+"").equalsIgnoreCase(row.get(1))){
             String txt ="Name: "+row.get(3)+"  ||  Status:"+row.get(11) ;
             System.out.println(txt);
             isFound = true;
             break;
       }
       
    
   }
   if (!isFound) {
           System.out.println("There is no manager who has an ID = "+id);
       }
        
    }
    public static void reportManager(int id) {
          ArrayList<ArrayList> data = getMgrFile();
         boolean isFound = false;
  
   for(ArrayList<String> row : data){
       
       if ((id+"").equalsIgnoreCase(row.get(1))){
             String txt ="ID: "+row.get(1)+"  ||  Name: "+row.get(3)+"  ||  Email: "+row.get(7)+"  ||  Phone: "+row.get(9)+"  ||  Status: "+row.get(11)+"  " ;
             System.out.println(txt);
             isFound = true;
             break;
       } 
   }
    if (!isFound) {
           System.out.println("There is no manager who has an ID = "+id);
       } 
    }
    public static void reportManager(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Enter Name or ID:");
        String search = keyboard.nextLine();
        if (isInteger(search)) {
            reportManager(Integer.parseInt(search));
        }else{
            reportManager(search);
        }
    }
    private static boolean isInteger(String string){
        
        boolean numeric = true;

        try {
            Integer num = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            numeric = false;
        }

        if(numeric)
            return numeric;
        else
            return numeric;
    } 
    public static void reportManager(String name) {
                ArrayList<ArrayList> data = getMgrFile();
         boolean isFound = false;
  
   for(ArrayList<String> row : data){
       
       if ((name).equalsIgnoreCase(row.get(3))){
             String txt ="ID: "+row.get(1)+"  ||  Name: "+row.get(3)+"  ||  Email: "+row.get(7)+"  ||  Phone: "+row.get(9)+"  ||  Status: "+row.get(11)+"  " ;
             System.out.println(txt);
             isFound = true;
             break;
       }
  
   } 
    if (!isFound) {
           System.out.println("There is no manager who has a name of "+name);
       }
   }
    public static void reportAllManagers(){
        ArrayList<ArrayList> data = getMgrFile();
        int length = data.size();
        for (int i = 0; length >= i; i++) {
            reportManager(i);
        }
    }
    public static void activateManager(int id){
          ArrayList<ArrayList> data = getMgrFile();
         boolean isFound = false; 
   for(ArrayList<String> row : data){     
       if ((id+"").equalsIgnoreCase(row.get(1))){
             row.set(11, "1");
             writeRowsToFile(data);
             System.out.println("The manager "+row.get(3)+" is activ now");
             isFound = true;
             break;
       }
   }
   if (!isFound) {
           System.out.println("There is no manager who has an ID = "+id);
       }      
    }
    public static void activateManager(){
         System.out.println("Enter manager's ID:");
         int id = new Scanner(System.in).nextInt();
         activateManager(id);
     }
    public static void deactivateManager(int id){
          ArrayList<ArrayList> data = getMgrFile();
         boolean isFound = false; 
   for(ArrayList<String> row : data){     
       if ((id+"").equalsIgnoreCase(row.get(1))){
             row.set(11, "0");
             writeRowsToFile(data);
             System.out.println("The manager "+row.get(3)+" isn't activ now");
             isFound = true;
             break;
       }
   }
   if (!isFound) {
           System.out.println("There is no manager who has an ID = "+id);
       }      
    }  
    public static void deactivateManager(){
         System.out.println("Enter manager's ID:");
         int id = new Scanner(System.in).nextInt();
         deactivateManager(id);
     }
    

    
   
}
     
   


