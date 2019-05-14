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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moadn
 */
public class Employee {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private int status;
    private int type;
    private String checkIn = "8:00";
    private String checkOut = "14:00";
    private static String empPath = "employee.txt";
    private static File empFile = new  File(empPath);
    private static String holPath = "holidays.txt";
    private static File holFile = new  File(holPath);
    //getters
     public int getId() {
        return id;
        }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }

    public String getCheckIn() {
        return checkIn;
    }
    
    public String getCheckOut() {    
        return checkOut;
    }
//getters
    public Employee() {
    }
    public Employee(int id) {
       
        ArrayList<ArrayList>  data = new ArrayList<>();
        //1
        data = getEmpFile();
           for(ArrayList<String> row : data){
       
       if ((id+"").equalsIgnoreCase(row.get(1))){
              this.id = id;
              this.name = row.get(3);
              this.password = row.get(5);
              this.email = row.get(7);
              this.phoneNumber = row.get(9);
              this.status = Integer.parseInt(row.get(11)) ;
              this.type = Integer.parseInt(row.get(13));
              this.checkIn = row.get(15);
              this.checkOut = row.get(17);
              
         
             break;
             
       }
           }
        //2
    }
 
    public Employee(int id, String name, String password, String email, String phoneNumber, int status, int type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.type = type;
        // write to file
        
         
        try {
            FileWriter fw = new FileWriter(empFile, true);
            PrintWriter pw = new PrintWriter(fw, true);
           
            String writeInfo = ("\nID: "+id +" "+"NAME: "+ name +" "+"PASSWORD: "+ password +" "+"EMAIL: "+ email +" "+"PHONE_NUMBER: "+ phoneNumber +" "+"STATUS: "+ status +" "+"TYPE: "+type+" "+"CHECK_IN: "+this.checkIn+" CHECK_OUT: "+this.checkOut+" ;");
            pw.println(writeInfo);
            
            pw.flush();
            pw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void changePassword(){
        System.out.println("Enter New Password:");
        this.password = new Scanner(System.in).nextLine();
        
        ArrayList<ArrayList> data = new ArrayList<>();
        data = getEmpFile();
           for(ArrayList<String> row : data){
       if ((id+"").equalsIgnoreCase(row.get(1))){
             String empName = row.get(3);
             row.set(5, password);            
             writeRowsToFile(data);
            System.out.println("Your password is updated successfully.");
             
             break;
       }
  
   }
        
    }
     public static ArrayList<ArrayList> getEmpFile(){
    ArrayList<ArrayList> allRows = new ArrayList<>();   
    ArrayList<String> row = new ArrayList<>();
try {
        Scanner token = new Scanner(empFile);
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
     private static void writeRowsToFile(ArrayList<ArrayList> rows){
        ;
    try {
        File file = new File("managersUpdate.txt");//file temp
       FileWriter fw = new FileWriter(file,false);
        PrintWriter pw = new PrintWriter(fw);
        for(ArrayList<String> row : rows ){
           
            try {
                 pw.println(row.get(0)+" "+row.get(1)+" "+row.get(2)+" "+row.get(3)+" "+row.get(4)+" "+row.get(5)+" "+row.get(6)+" "+row.get(7)+" "+row.get(8)+" "+row.get(9)+" "+row.get(10)+" "+row.get(11)+" "+row.get(11)+" "+row.get(12)+" "+row.get(13)+" "+row.get(14)+" "+row.get(15)+" "+row.get(16)+" "+row.get(17)+" ;");

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        } 
        pw.flush();
        pw.close(); 
    } catch (IOException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }   
     public void timeOfAttendance(){
         System.out.println("Enter the time:");
         checkIn = new Scanner(System.in).nextLine();
         ArrayList<ArrayList> data = new ArrayList<>();
        data = getEmpFile();
           for(ArrayList<String> row : data){
       if ((id+"").equalsIgnoreCase(row.get(1))){
             String empAtt = row.get(15);
             row.set(15, checkIn);            
             writeRowsToFile(data);
            System.out.println("Your time scedule is updated.");
             
             break;
       }
  
   }
     }
      public void timeOfDeparture(){
         System.out.println("Enter the time:");
         checkIn = new Scanner(System.in).nextLine();
         ArrayList<ArrayList> data = new ArrayList<>();
        data = getEmpFile();
           for(ArrayList<String> row : data){
       if ((id+"").equalsIgnoreCase(row.get(1))){
             String empAtt = row.get(17);
             row.set(17, checkIn);            
             writeRowsToFile(data);
            System.out.println("Your time scedule is updated.");
             
             break;
       }
  
   }
     }
      
}
