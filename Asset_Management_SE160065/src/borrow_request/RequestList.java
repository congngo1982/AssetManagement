/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package borrow_request;

import asset.AssetList;
import employee.Employee;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class RequestList extends HashMap<String, Request> implements R_List {

    public RequestList() {
        try {
            IOFile.readObject(this, "request.DAT");
        } catch (Exception e) {
        }
    }

    public void add(AssetList as, Employee em) {
        Request re = new Request();
        re = Request.request(as, em);
        this.put(re.getrID(), re);
        try {
            IOFile.writeObject(this, "request.DAT");
        } catch (Exception e) {
        }
    }

    public void show() {
        Set<String> id = this.keySet();
        Request.showTitle();
        for (String Id : id) {
            this.get(Id).show();
        }
    }
}
