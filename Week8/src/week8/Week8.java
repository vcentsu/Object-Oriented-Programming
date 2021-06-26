/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;

import java.util.*;

class emp{
    public String empName;
    public int empAge;
    public String empRole;
    public String empType;
    public boolean empStatus;
    
    public emp(String name, int age, String role, String type){
        this.empName = name;
        this.empAge = age;
        this.empRole = role;
        this.empType = type;
    }
    
    String getName() {
        return empName;
    }

    int getAge() {
        return empAge;
    }

    String getRole() {
        return empRole;
    }

    String getType() {
        return empType;
    }

    public void setStatusActive(boolean status) {
        this.empStatus = status;
    }

    public boolean isStatusActive() {
        return empStatus;
    }
    
    public void showData(){
        System.out.println("PART TIME EMPLOYEE");
        System.out.println("==================");
        System.out.print("Status : ");
        if(empStatus!=true) {
            System.out.println("NOT ACTIVE");
        }else { 
            System.out.println("ACTIVE");
        }
        System.out.println("Name : " + empName);
        System.out.println("Age : " + empAge);
        System.out.println("Role : " + empRole);
    }
}
class typePartTime extends emp{
    public int empSalary;
    public int empHour;
    public int totalSalary;
    
    public typePartTime(String name, int age, String role, String type, int salary, int hour){
        super(name, age, role, type);
        this.empSalary = salary;
        this.empHour = hour;
    }
    
    public int hasilSalary(){
        totalSalary = empSalary * 4 * empHour;
        return totalSalary;
    }
    
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    @Override
    public String getType() {
        return super.getType();
    }
    
    @Override
    public void setStatusActive(boolean status) {
        super.setStatusActive(status);
    }
    
    public int getSalaryPerHour() {
        return empSalary;
    }

    public int getHour() {
        return empHour;
    }

    public int getTotalSalary() {
        return totalSalary;
    }
    
    @Override
    public void showData(){
        System.out.println("PART TIME EMPLOYEE");
        System.out.println("==================");
        System.out.print("Status : ");
        if(empStatus!=true) {
            System.out.println("NOT ACTIVE");
        }else { 
            System.out.println("ACTIVE");
        }
        System.out.println("Name : " + empName);
        System.out.println("Age : " + empAge);
        System.out.println("Role : " + empRole);
        System.out.println("Pay per hour : " + empSalary);
        System.out.println("Working hour per week : " + empHour);
        System.out.println("Salary per month : " + totalSalary);
    }
}
class typeFullTime extends emp{
    public int empSalary;
    
    public typeFullTime(String name, int age, String role, String type, int salary){
        super(name, age, role, type);
        this.empSalary = salary;
    }
    
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    @Override
    public String getType() {
        return super.getType();
    }
    
    @Override
    public void setStatusActive(boolean status) {
        super.setStatusActive(status);
    }
    
    public int getSalary() {
        return empSalary;
    }
    
    @Override
    public void showData(){
        System.out.println("FULL TIME EMPLOYEE");
        System.out.println("==================");
        System.out.print("Status : ");
        if(empStatus!=true) {
            System.out.println("NOT ACTIVE");
        }else { 
            System.out.println("ACTIVE");
        }
        System.out.println("Name : " + empName);
        System.out.println("Age : " + empAge);
        System.out.println("Role : " + empRole);
        System.out.println("Base salary per month : " + empSalary);
    }
}
/**
 *
 * @author vince
 */
public class Week8 {

    public static void menu() {
        System.out.println("\nABC EMPLOYEE DATA");
        System.out.println("=================");
        System.out.println("1. Add Employee "
                + "\n2. View Employee "
                + "\n3. Resign "
                + "\n4. Exit \n");
        System.out.print("Choice [1-4] >> ");
    }
    private static void listEmployee(ArrayList <emp> employee) {
        for (int i=0; i<employee.size(); i++){
            System.out.println("\nEmployee no."+ (i+1));
            employee.get(i).showData();
        } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner centsu = new Scanner(System.in);
        ArrayList <emp> employee = new ArrayList<>();
        int choice;
        String name, role, type;
        int age = 0, salary = 0;
        boolean status;

        do {
            menu();
            choice = centsu.nextInt();
            centsu.nextLine();

            System.out.println();
            switch (choice) {
                case 1: {
                    do {
                        System.out.print("Input Employee Name [must be more than 3 char]:  ");
                        name = centsu.nextLine();
                    } while (name.length() <= 3);

                    do {
                        System.out.print("Input Employee Age [>=17]:  ");
                        try {
                            age = centsu.nextInt();
                        } catch (Exception e) {
                            System.out.println("Input must be numeric");
                            centsu.nextLine();
                        }
                    } while (age < 17);

                    centsu.nextLine();
                    do {
                        System.out.print("Input Employee Role [Assistant|Programmer](Case Sensitive): ");
                        role = centsu.next();
                    } while (!role.equals("Assistant") && !role.equals("Programmer"));
                    centsu.nextLine();

                    do {
                        System.out.print("Input Employee Type [PartTime|FullTime](Case Sensitive): ");
                        type = centsu.nextLine();
                    } while (!type.equals("PartTime") && !type.equals("FullTime"));

                    if (type.equals("PartTime")) {
                        do {
                            System.out.print("Input pay per hour [>=10000]:  ");
                            try {
                                salary = centsu.nextInt();
                            } catch (Exception e) {
                                System.out.println("Input must be numeric");
                                centsu.nextLine();
                            }
                        } while (salary <10000);
                        
                        int hour = 0;
                        do {
                            System.out.print("Input working hour per week [>0]:  ");
                            try {
                                hour = centsu.nextInt();
                            } catch (Exception e) {
                                System.out.println("Input must be numeric");
                                centsu.nextLine();
                            }
                        } while (hour <0);
                        
                        status = true;
                        typePartTime tipe = new typePartTime(name, age, role, type, salary,hour);
                        employee.add(tipe);
                        tipe.setStatusActive(status);
                        tipe.hasilSalary(); //untuk menjumlahkan hasil salary nya
                        //tipe.showData();
                        
                    }else{
                        do {
                            System.out.print("Input base salary [>=10000]:  ");
                            try {
                                salary = centsu.nextInt();
                            } catch (Exception e) {
                                System.out.println("Input must be numeric");
                                centsu.nextLine();
                            }
                        } while (salary <10000);
                        
                        status = true;
                        typeFullTime tipe = new typeFullTime(name, age, role, type, salary);
                        employee.add(tipe);
                        tipe.setStatusActive(status);
                        //tipe.showData();
                        
                    }
                    System.out.println("\n >> Success Insert Employee Data << ");
                    
                    System.out.print("\nPress ENTER to continue . . .");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 2: {
                    if(employee.isEmpty()==true){
                        System.out.println("There is no employee data in the list\n");
                    }else {
                        listEmployee(employee);    
                    }
                    
                    System.out.print("\nPress ENTER to continue . . .");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;
                }
                
                case 3: {
                    int pilih;
                    
                    if(employee.isEmpty()==true){
                        System.out.println("There is no employee data in the list\n");
                    }else{
                        listEmployee(employee);
                    }
                    
                    System.out.println();
                    do{
                        System.out.print("Pilih Pelanggaran [1.." + employee.size()+"]: ");
                        pilih = centsu.nextInt();
                    }while(pilih<1 || pilih>employee.size());
                    
                    if(employee.get(pilih-1).isStatusActive()){
                        System.out.println(employee.get(pilih-1).empName + " is resigning . . .");
                        employee.get(pilih-1).setStatusActive(false);
                    }else{
                        System.out.println("Employee has already resigned!\n");
                    }
                    
                    System.out.print("\nPress ENTER to continue . . .");
                    centsu.nextLine();
                    centsu.nextLine();
                    break;    
                    
                }
            }
        } while (choice != 4);
    }

}
