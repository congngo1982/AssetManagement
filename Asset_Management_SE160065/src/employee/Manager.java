/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import utils.Utils;

/**
 *
 * @author Admin
 */
public class Manager extends Employee {
    
    public Manager(String id) {
        super(id);
    }
    
    @Override
    public void add() {
        this.setName(Utils.getString("Enter Name of Empolyee: "));
        this.setBirthday(Utils.getString("Enter Birtday of Employee: "));
        this.setSex(Utils.getString("Enter Sex of Employee: "));
        this.setPassword(Utils.enCodeMD5(Utils.getString("Enter Password of Employee: ")));
    }
    
    @Override
    public void show() {
//        System.out.println("Id of Employee: " + this.getId());
//        System.out.println("Name of Employee: " + this.getName());
//        System.out.println("Role of Employee: Manager");
//        System.out.println("Birtday of Employee: " + this.getBirthday());
//        System.out.println("Sex of Employee: " + this.getSex());
//        System.out.println("Password of Employee: " + this.getPassword());
        System.out.printf("%-40s%-20s%-20s%-20s%-20s%-20s\n", this.getId(), this.getName(), this.getBirthday(), "Manager", this.getSex(), this.getPassword());
    }
    
    @Override
    public String toString() {
        return "Manager{" + '}';
    }
    
}
