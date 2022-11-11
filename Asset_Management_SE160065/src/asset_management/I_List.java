/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asset_management;

import asset.AssetList;
import borrow_request.BorrowList;
import borrow_request.RequestList;
import employee.EmployeeList;
import employee.Employee;

/**
 *
 * @author Admin
 */
public interface I_List {

    public Employee login(EmployeeList em);

    public void search(Employee em, AssetList as);

    public void create(Employee em, AssetList as);

    public void update(Employee em, AssetList as);

    public void approve(Employee em, BorrowList br, RequestList rq);

    public void show(Employee em, BorrowList br);
}
