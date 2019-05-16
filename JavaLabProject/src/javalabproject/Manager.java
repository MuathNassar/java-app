/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.BreakNode;

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
    static Scanner addEmployee =new Scanner(System.in);
    private String mgrPath = "employee.txt";
    private File mgrFile = new  File(mgrPath);

    public Manager(int id) {
        this.id=id;
    }

public ArrayList<ArrayList> readFile(){
        ArrayList<ArrayList> allRows=new ArrayList<>();
        ArrayList<String> oneRow = new ArrayList<>();
        try {
            Scanner read=new Scanner(mgrFile);
            while (read.hasNext()) {
                String world = read.next();
                if (!world.equals(";")) {
                    oneRow.add(world);
                }else{
                    allRows.add((ArrayList)oneRow.clone());
                    oneRow.clear();
                }
//                read.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allRows;
    }

    public void writeArrayToFile(ArrayList<ArrayList> allRow){
        boolean coun=false;
        for (ArrayList<String> onerow : allRow) {
            addToFile(onerow.get(1), onerow.get(3),onerow.get(5),onerow.get(7), onerow.get(9), onerow.get(11), onerow.get(13), onerow.get(15), onerow.get(17), coun);
            coun=true;

        }}
public void clearFile(){
    FileWriter fw = null;
        try {
            fw = new FileWriter(mgrFile,false);
            PrintWriter pw=new PrintWriter(fw,false);
            pw.print("");
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}



    public void addToFile(String id,String name,String password,String email,String phoneNumber,String typeOfEmployee,String statas,String checkIn,String checkOut,boolean isTrue){
        try {
            //add one emp
            FileWriter fw =new FileWriter(mgrFile,isTrue);
            PrintWriter pr =new PrintWriter(fw,true);


            String rightInfo=("ID: "+id +" "+"NAME: "+name +" "+"PASSWORD: "+ password +" "+"EMAIL: "+email +" "+"PHONE_NUMBER: "+ phoneNumber +" "+"Type_Of_Employee: "+ typeOfEmployee +" STATUS: "+ statas +" "+"CHECK_IN: "+ checkIn+" CHECK_OUT: "+checkOut+ " ;");
            pr.println(rightInfo);
            pr.close();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }


    }public static void addEmployeeToFileManager(String id,String name,String password,String email,String phoneNumber,String statas){
        try {
            //add one emp
            File manager=new File("manager.txt");
            FileWriter fw =new FileWriter(manager,true);
            PrintWriter pr =new PrintWriter(fw,true);
            String rightInfo=("ID: "+id +" NAME: "+name +" PASSWORD: "+ password +" EMAIL: "+
                    email +" PHONE_NUMBER: "+ phoneNumber +" STATUS: "+ statas +" ;");
            pr.println(rightInfo);
            pr.close();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public ArrayList<Holiday> getHolyDayData(){
    ArrayList<Holiday>holyDays=new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("holidays.txt")));
            Object x = objectInputStream.readObject();
            holyDays=(ArrayList<Holiday>)x;
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }return holyDays;
}
    private void addEmployee() {
        //entering employee info -by mohammad
        System.out.print("<<<<< Add Employee >>>>>\n"
                + "Enter Id ");
        String id =addEmployee.nextLine();
        System.out.print("Enter name : ");
        String name =addEmployee.nextLine();
        System.out.print("Enter password : ");
        String password =addEmployee.nextLine();
        System.out.print("Enter email : ");
        String email =addEmployee.nextLine();
        System.out.print("Enter Phone Number : ");
        String phoneNumber =addEmployee.nextLine();
        System.out.print("Types of Employee (1-Full-time 2-Part-time) : ");
        String typeOfEmployee =addEmployee.nextLine();
        System.out.print("Enter statas( 0 or 1 ) : ");
        String statas =addEmployee.nextLine();
        String checkIn="08:00";

        String checkOut="05:00";
        //method to put info to -by mohammad
        addToFile(id,name,password,email,phoneNumber,typeOfEmployee,statas,checkIn,checkOut,true);
        System.out.println("add employee "+name+" is done");
        managerInterfase();
    }

    private void UpdateEmployee() {
        System.out.print(">>>>> Update Employee <<<<<\n"
                + "Enter Id : ");
        int id =addEmployee.nextInt();

        ArrayList<ArrayList>employees=readFile();
        for(ArrayList<String> row:employees){
            if((id+"").equalsIgnoreCase(row.get(1))){
                System.out.print("New Password : ");
                addEmployee.nextLine();
                String password =addEmployee.nextLine();
                row.set(5, password);
                writeArrayToFile(employees);
                System.out.println("the employee"+row.get(3)+" Update is done");
                managerInterfase();
            }
                            

        }managerInterfase();
    }

    private void deleteEmployee() {
        System.out.print(">>>>> Delete Employee <<<<<\n"
                        + "Enter Id : ");

        int id =addEmployee.nextInt();
        ArrayList<ArrayList> employees=readFile();
        for (ArrayList<String> oneRow : employees) {
            if((id+"").equalsIgnoreCase(oneRow.get(1))){
                System.out.println("employee "+oneRow.get(5)+" is deleted\n\n");

                employees.remove(oneRow);
                writeArrayToFile(employees);
                managerInterfase();
            }
        }managerInterfase();
          }

    private void searchOneEmployee() {
        System.out.print(">>>>> Search about Employee <<<<<\n"
                + "Enter Id : ");
        int id =addEmployee.nextInt();
       ArrayList<ArrayList> employees=readFile();
        for (ArrayList<String> oneRow : employees) {
            if((id+"").equals(oneRow.get(1))){
                System.out.println("name : "+oneRow.get(3)+" status "+ oneRow.get(13));
                managerInterfase();
            }
        }managerInterfase();
    }

    private void reportOneEmployee() {
System.out.print(">>>>> Report about Employee <<<<<\n"
        + "Enter Id : ");
        int id =addEmployee.nextInt();
        ArrayList<ArrayList>employees=readFile();
        for(ArrayList<ArrayList> oneRow:employees){
            if((id+"").equals(oneRow.get(1))){
                System.out.println("Id: "+oneRow.get(1)+" ||"
                + " Name: "+oneRow.get(3)+" ||"
                + " Email: "+oneRow.get(7)+" ||"
                + " Phone: "+oneRow.get(9)+" ||"
                + " Type Emp: "+oneRow.get(11)+" ||"
                + " Statas: "+oneRow.get(13)+" ||"
                + " Check out: "+oneRow.get(15)
                + " Check out: "+oneRow.get(17));
                managerInterfase();
            }
        }managerInterfase();

    }

    private void reportAllEmployee() {
            ArrayList<ArrayList>employees=readFile();
        for(ArrayList<ArrayList> oneRow:employees){

                System.out.println("Id: "+oneRow.get(1)+" ||"
                + " Name: "+oneRow.get(3)+" ||"
                + " Email: "+oneRow.get(7)+" ||"
                + " Phone: "+oneRow.get(9)+" ||"
                + " Type Emp: "+oneRow.get(11)+" ||"
                + " Statas: "+oneRow.get(13)+" ||"
                + " Check out: "+oneRow.get(15)+" ||"
                + " Check out: "+oneRow.get(17));
                ;
            }
            managerInterfase();
        }

    private void statasEmployee() {
        System.out.println(">>>>> Deactivate & Activate Employee <<<<<\n"
                + "1- Activate.\n"
                + "2- Deactivate.\n"
                + "3- Exit.");
        int choice =addEmployee.nextInt();
        if(choice==1)
                        {System.out.print(">>>>> Activate Employee <<<<<\n"
                    + "Enter id : ");
                    int id=addEmployee.nextInt();
                    ArrayList<ArrayList>employee=readFile();
                            for (ArrayList oneRow : employee) {
                                if((id+"").equals(oneRow.get(1))){
                                    oneRow.set(13, "1"); //Activated
                                    writeArrayToFile(employee);
                                    break;
                                }
                            }

                    statasEmployee();
                        }
                    else if(choice==2){System.out.print(">>>>> Deactivated Employee <<<<<\n"
                    + "Enter id : ");
                        int id=addEmployee.nextInt();
                        ArrayList<ArrayList>employee=readFile();
                            for (ArrayList oneRow : employee) {
                                if((id+"").equals(oneRow.get(1))){
                                    oneRow.set(13, "0"); //deactivated
                                    writeArrayToFile(employee);
                                    statasEmployee();
                                }
                            }
                        
                            }
                    else{managerInterfase();


                    }

    }

    private void employeeToManager() {


                    ArrayList<ArrayList>employees=readFile();
                    if (employees.isEmpty()) {
                                 addEmployee();
                             }
                    System.out.print(">>>>> Promote Employee to Manager <<<<<\n"
                    + "Enter id : ");
                    int id=addEmployee.nextInt();

                    for (ArrayList oneRow : employees) {

                         if((id+"").equals(oneRow.get(1))){
                             String mId=oneRow.get(1)+"";
                             String name =""+oneRow.get(3);
                             String password =""+oneRow.get(5);
                             String email =""+oneRow.get(7);
                             String phoneNumber =""+oneRow.get(9);
                             String status =""+oneRow.get(13);
                             addEmployeeToFileManager(mId, name, password, email, phoneNumber, status);
                             employees.remove(oneRow);
                             if (employees.isEmpty()) {
                                 clearFile();
                                 System.out.println("Add employee thats no one : ");
                                 managerInterfase();
                             }else{
                                 writeArrayToFile(employees);
                                 managerInterfase();
                             }
                         }managerInterfase();
                    }

    }

    private void attendance() {
        Scanner attendance = new Scanner(System.in);
        System.out.print(">>>>> Attendance <<<<<\n"
                    + "1- Time of attendance.\n"
                    + "2- Time to leave.\n"
                    + "3- Exit\n");
                    int choice=attendance.nextInt();
                    if(choice==1)
                        {System.out.print(">>>>> Time of attendance <<<<<\n"
                                + "Enter the Time :\nhours : ");
                                int hours = attendance.nextInt();
                                System.out.print("menutes : ");
                                int minutes = attendance.nextInt();
                                ArrayList<ArrayList>employees=readFile();
                                for (ArrayList<String> oneRow : employees) {
                                    oneRow.set(15,hours+":"+minutes);
                                    writeArrayToFile(employees);
                                }
                                attendance();
                        }
                    else if(choice==2){
                            System.out.print(">>>>> Time to leave <<<<<\n"
                            + "Enter the Time : hours : ");
                            int hours = attendance.nextInt();
                                System.out.print("menutes : ");
                                int minutes = attendance.nextInt();
                                ArrayList<ArrayList>employees=readFile();
                                for (ArrayList<String> oneRow : employees) {
                                    oneRow.set(17,hours+":"+minutes);
                                    writeArrayToFile(employees);
                                }
                            attendance();
                            }

                    else{managerInterfase();

                    }
    }

    public void myHolidays(){
       ArrayList<Holiday> listOfAllHolidays = getHolyDayData();
       ArrayList<Holiday> listOfMyHolidays = new ArrayList<>();
       for(Holiday h : listOfAllHolidays){
           if(h.getId()== this.id) {
                listOfMyHolidays.add(h);
           }   
           
       }
       for(Holiday hol : listOfMyHolidays){
           System.out.println(hol.toString());
       }
    }
    private void holiday() {
        System.out.println(">>>>> Holiday <<<<<\n"
                + "1-My Holiday.\n"
                + "2-Creat Holiday.\n"
                + "3-Exit.");
        int choice=addEmployee.nextInt();
        if(choice==1){
            System.out.println(">>>>> My Holiday <<<<<\n");
            myHolidays();
            holiday();
        }else if(choice==2){
            System.out.print(">>>>> Creat Holiday <<<<<\n"
                + "Enter Name : ");
            addEmployee.nextLine();
        String name=addEmployee.nextLine();
        System.out.print("Enter Reason : ");
        String reson=addEmployee.nextLine();
        System.out.print("Enter Details : ");
        String details=addEmployee.nextLine();
        System.out.print("Enter Date : ");
        String date=addEmployee.nextLine();
        Holiday holiday = new Holiday(name, reson, details, date);
        holiday.setId(this.id);
        holiday.writeHolidayToFile();
        holiday();
        }else if(choice==3){
            managerInterfase();
        }


    }





    public void managerInterfase(){
        System.out.println(">>>>> Manager <<<<< \n"
                + "1- Add Employee\n"
                + "2- Update Employee\n"
                + "3- Delete Employee\n"
                + "4- Search Employee\n"
                + "5- Report about Employee\n"
                + "6- Report about All Employee\n"
                + "7- Deactivate & Activate Manager\n"
                + "8- Promote an Employee to Manager\n"
                + "9- Attendance\n"
                + "10- Holiday\n"
                + "11- Exit" );
        Scanner manager=new Scanner(System.in);
        int choice =manager.nextInt();
        switch(choice){
            case 1:addEmployee();
                break;
            case 2:UpdateEmployee();
                break;
            case 3:deleteEmployee();
                break;
            case 4:searchOneEmployee();
                break;
            case 5:reportOneEmployee();
                break;
            case 6:reportAllEmployee();
                break;
            case 7:statasEmployee();
                break;
            case 8:employeeToManager();
                break;
            case 9:attendance();
                break;
            case 10:holiday();
                break;
            case 11:Main.startup();
        }
    }


//    System.out.println("<<<<<<<Login Screen>>>>>>>");
//        System.out.println("1- Admin");
//        System.out.println("2- Manager");
//        System.out.println("3- Employee");
//        Scanner s = new Scanner(System.in);
//        String choice = s.nextLine();
//        switch(choice){
//            case "1":             login("admin");
//                break;
//            case "2":             login("managers");
//                break;
//            case "3":             login("employee");
//                break;
//
//       }
    //area to try start
//   Employee e = new Employee(1);
//        e.timeOfDeparture();

    //area to try end

    }

//    public static boolean login(String fileName){
//        Scanner s = new Scanner(System.in);
//        System.out.println("2- Id");
//        String id = s.nextLine();
//        System.out.println("3- Password");
//        String password=s.nextLine();
//        validate(id, password, fileName);
//        return true;
//    };
//
//
//    public static boolean validate(String id, String password, String fileName){
//            if(fileName.equals("admin")){
//                adminInterface();
//            }
////            if(fileName.equals("manager")&& id.equals(1) && password.equals("efd")){
////                Admin admin1 = new Admin(id, password);
////            }
////            if(fileName.equals("employeee")&& id.equals("1") && password.equals("efd")){
////                Admin admin1 = new Admin(id, password);
////            }
//            return false;
//        }




//}
