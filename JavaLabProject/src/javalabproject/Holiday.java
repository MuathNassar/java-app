/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.io.EOFException;
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
    private String name;
    private String reason;
    private String Details;
    private String date;
    private int check =0;
    private static final File holFile = new File("holidays.txt");

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
        this.writeHolidayToFile();
        
    }
    public void writeHolidayToFile(){
        try {
            ObjectOutputStream os;
            try (FileOutputStream fo = new FileOutputStream(holFile,false)) {
                os = new ObjectOutputStream(fo);            
                ArrayList<Holiday> data = getHolData();
                if (data.isEmpty()) {
                    ArrayList<Holiday> list = new ArrayList<>();
                   list.add(this);
                    os.writeObject(list);
                    
                }else{
                    os.writeObject(data.add(this));
                }
            }
            os.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public static ArrayList<Holiday> getHolData(){
     ObjectInputStream objectInputStream = null;
      ArrayList<Holiday> data = new ArrayList<>();
      
        try {
           
            objectInputStream = new ObjectInputStream(new FileInputStream(holFile));
           data = (ArrayList<Holiday>) objectInputStream.readObject();
           objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) { 
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return data;
        }
 

    @Override
    public String toString() {
        return "Holiday{" + "name=" + name + ", reason=" + reason + ", Details=" + Details + ", date=" + date + ", check=" + check + '}';
    }
    
  }  

