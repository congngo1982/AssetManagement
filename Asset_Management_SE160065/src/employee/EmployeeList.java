/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.util.HashMap;
import utils.Menu;
import utils.Utils;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class EmployeeList extends HashMap<String, Employee> implements E_List {

    public EmployeeList() {
        try {
            IOFile.readObject(this, "employee.DAT");
        } catch (Exception e) {
        }
    }

    public void add() {
        Menu menu = new Menu();
        Employee em = null;
        String id;
        menu.add("1. Manager. ");
        menu.add("2. Staff. ");
        menu.showMenu();
        int c = Utils.getInt("Enter your choice: ", 1, 2);
        if (c == 1) {
            do {
                id = Utils.getString("Enter Id of Employee: ");
                if (this.containsKey(id)) {
                    System.out.println("Id has been Existed.");
                }
            } while (this.containsKey(id));
            em = new Manager(id);
            em.add();
            this.put(id, em);
        } else {
            do {
                id = Utils.getString("Enter Id of Employee: ");
                if (this.containsKey(id)) {
                    System.out.println("Id has been Existed.");
                }
            } while (this.containsKey(id));
            em = new Staff(id);
            em.add();
            this.put(id, em);
        }
        try {
            IOFile.writeObject(this, "employee.DAT");
        } catch (Exception e) {
        }
    }

    public void show() {
        String id = Utils.getString("Enter Id of Employee: ");
        if (this.containsKey(id)) {
            this.showTitle();
            this.get(id).show();
//            System.out.println(this.get(id).isManager());
        } else {
            System.out.println("No Data");
        }
    }

    public void showAll() {
        Set<String> id = this.keySet();
        this.showTitle();
        for (String Id : id) {
            this.get(Id).show();
        }
    }

    public void showTitle() {
        System.out.printf("%-40s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name", "BirthDay", "Role", "Sex", "Password");
    }
}
