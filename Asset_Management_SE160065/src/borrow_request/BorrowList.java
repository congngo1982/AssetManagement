/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package borrow_request;

import java.util.HashMap;
import java.util.Set;
import asset.*;
import employee.*;
import utils.Utils;

/**
 *
 * @author Admin
 */
public class BorrowList extends HashMap<String, Borrow> implements B_List {

    public BorrowList() {
        try {
            IOFile.readObject(this, "borrow.DAT");
        } catch (Exception e) {
        }
    }

    public void borrow(RequestList rq) {
        Borrow br = new Borrow();
        br = Borrow.borrow(rq);
        if(br != null){
            this.put(br.getbID(), br);
        try {
            IOFile.writeObject(this, "borrow.DAT");
        } catch (Exception e) {
        }
        } else {
            System.out.println("No Action");
        }
    }

    public void show() {
        Set<String> id = this.keySet();
        Borrow.showTitle();
        for (String ID : id) {
            this.get(ID).show();
        }

    }

    public boolean containID(String ID) {
        int d = 0;
        Set<String> id = this.keySet();
        for (String Id : id) {
            if (this.get(Id).getAssetID().equals(ID)) {
                d++;
            }
        }
        if (d != 0) {
            return true;
        } else {
            return false;
        }
    }
}
