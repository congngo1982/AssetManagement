/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asset_management;

import employee.EmployeeList;
import employee.Manager;
import employee.Staff;
import employee.LogIn;
import asset.AssetList;
import employee.Employee;
import borrow_request.BorrowList;
import borrow_request.RequestList;

/**
 *
 * @author Admin
 */
public class Management implements I_List {

    @Override
    public Employee login(EmployeeList em) {
        return LogIn.login(em);
    }

    @Override
    public void search(Employee em, AssetList as) {
        as.show();
    }

    @Override
    public void create(Employee em, AssetList as) {
        if(em.isManager()){
            as.add();
        } else {
            System.out.println("You are not Manager");
        }
    }

    @Override
    public void update(Employee em, AssetList as) {
        if(em.isManager()){
            as.update();
        } else {
            System.out.println("You are not Manager");
        }
    }

    @Override
    public void approve(Employee em, BorrowList br, RequestList rq) {
        if(em.isManager()){
            br.borrow(rq);
        } else {
            System.out.println("You are not Manager");
        }

    }

    @Override
    public void show(Employee em, BorrowList br) {
        if(em.isManager()){
            br.show();
        } else {
            System.out.println("You are not Manager");
        }
    }

}
