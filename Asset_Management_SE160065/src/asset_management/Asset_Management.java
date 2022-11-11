/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package asset_management;

import asset_management.Management;
import employee.EmployeeList;
import employee.Employee;
//import employee.Manager;
//import employee.Staff;
import asset.AssetList;
import borrow_request.BorrowList;
import borrow_request.RequestList;
import utils.*;

/**
 *
 * @author Admin
 */
public class Asset_Management {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Menu menu = new Menu();
        menu.addItem("+ - - - - - - - - - - - - - - - - - - - - - +");
        menu.addItem("|    Menu:                                  |");
        menu.addItem("|    1. Login.                              |");
        menu.addItem("|    2. Search Asset by Name.               |");
        menu.addItem("|    3. Create new Asset.                   |");
        menu.addItem("|    4. Updating Asset's Information.       |");
        menu.addItem("|    5. Approve the Reaquest of Employee.   |");
        menu.addItem("|    6. Show List of Borrow Asset.          |");
        menu.addItem("|    7. Quit.                              |");
        menu.addItem("+ - - - - - - - - - - - - - - - - - - - - - +");
        EmployeeList eml = new EmployeeList();
        AssetList as = new AssetList();
        Management mn = new Management();
        RequestList rq = new RequestList();
        BorrowList br = new BorrowList();
        Employee em = null;
        int choice;
        int d = 0;
        boolean check = false;
        do {
            menu.showMenu();
            choice = Utils.getInt("Enter your Choice: ", 1, 7);
            if (choice == 1) {
                if (d != 0) {
                    System.out.println("Cannot LogIn");
                } else {
                    em = mn.login(eml);
                    if (em == null) {
                        d = 0;
                    } else {
                        d++;
                    }
                }
            } else if (choice == 2) {
                if (d == 0) {
                    System.out.println("You must Login to Use");
                } else {
                    as.search();
                }
            } else if (choice == 3) {
                if (d == 0) {
                    System.out.println("You must Login to Use");
                } else {
                    if (em.isManager()) {
                        as.add();
                    } else {
                        System.out.println("Your are not Manager");
                    }
                }
            } else if (choice == 4) {
                if (d == 0) {
                    System.out.println("You must Login to Use");
                } else {
                    if (em.isManager()) {
                        as.update();
                    } else {
                        System.out.println("Your are not Manager");
                    }
                }
            } else if (choice == 5) {
                if (d == 0) {
                    System.out.println("You must Login to Use");
                } else {
                    mn.approve(em, br, rq);
                }
            } else if (choice == 6) {
                if (d == 0) {
                    System.out.println("You must Login to Use");
                } else {
                    mn.show(em, br);
                }
            } else if (choice == 7) {
                check = Utils.confirmYesNo("Do you want to Quit");
            }
        } while (check == false);
    }
}
