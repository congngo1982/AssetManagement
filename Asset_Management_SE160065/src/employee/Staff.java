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
public class Staff extends Employee {
    
    public Staff(String id) {
        super(id);
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
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
        System.out.printf("%-40s%-20s%-20s%-20s%-20s%-20s\n", this.getId(), this.getName(), this.getBirthday(), "Staff", this.getSex(), this.getPassword());
    }
    
}
