/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moadn
 */
public class Main {
    public static void main(String[] args) {
        
       Holiday j = new  Holiday("aaaaa");
       j.setDetails("no");
       j.setDate("11/8/888");
       j.setReason("no reason");
        System.out.println(j.toString());
        
    }
    
}
