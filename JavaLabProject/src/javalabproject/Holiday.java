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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moadn
 */
public class Holiday implements Serializable{
    private int id = 0;
    private String name = "Unknown";
    private String reason = "No reson";
    private String Details = "No Details";
    private String date = "Current day";
    private int check =0;
    public static final File holFile = new File("holidays.txt");

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public String getDetails() {
        return Details;
    }

    public String getDate() {
        return date;
    }

    public int getCheck() {
        return check;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public Holiday(String name) {
        this.name = name;
    }
    public Holiday(String name, String reason, String Details, String date) {
        this.name = name;
        this.reason = reason;
        this.Details = Details;
        this.date = date;
        
    }
    public void writeHolidayToFile(){
        ArrayList<Holiday> data = getHolData();
        try {
            ObjectOutputStream os;
            try (FileOutputStream fo = new FileOutputStream(holFile,false)) {
                os = new ObjectOutputStream(fo);                         
                if (data.isEmpty()) {
                    ArrayList<Holiday> list = new ArrayList<>();
                   list.add(this);
                    os.writeObject(list);
                    System.out.println("Add new Holiday with new Array");
                    
                }else{
                    data.add(this);
                    os.writeObject(data);
                    System.out.println("Add new Holiday to array ");
                }
            }
            os.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    public static ArrayList<Holiday> getHolData(){
     
    ArrayList<Holiday> data = new ArrayList<>();
      
        try {
           ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(holFile));
           Object x = objectInputStream.readObject();
           data = (ArrayList<Holiday>)x;
           objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
          
        } catch (IOException | ClassNotFoundException ex) { 
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            
        }
           
            return data;
        }
    public static void showAllHolidays(){
        ArrayList<Holiday> list = getHolData();
        for (Holiday h: list) {
            System.out.println(h.toString());
            
        }
    }
    @Override
    public String toString() {
        return "id:" + id + " || name:" + name + " || reason:" + reason + " || Details:" + Details + " || date:" + date + " || check=" + check ;
    }  

    void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }  

