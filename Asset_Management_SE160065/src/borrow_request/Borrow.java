/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package borrow_request;

import asset.AssetList;
import utils.Utils;
import java.util.Date;
import employee.*;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Borrow implements Serializable {

    private String bID;
    private String assetID;
    private String emID;
    private int quantity;
    private String bDate;

    public Borrow() {
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String rID) {
        this.bID = rID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmID() {
        return emID;
    }

    public void setEmID(String emID) {
        this.emID = emID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String reDate) {
        this.bDate = reDate;
    }

//    public void add(Asset as, Employee em) {
//        this.rID = Utils.getDate();
//        this.assetID = as.getId();
//        this.emID = em.getId();
//        this.getQuantity() = as.getQuantity();
//        this.reDate = Utils.getDate();
//    }
    public static Borrow borrow(RequestList rq) {
        String id;
        System.out.println("Request List: ");
        Borrow br = new Borrow();
        rq.show();
        do {
            id = Utils.getString("Enter Id of Asset: ");
            if (!rq.containsKey(id)) {
                System.out.println("No Id in List");
            }
        } while (!rq.containsKey(id));
        boolean check = Utils.confirmYesNo("Do you want to Approve this Request: ");
        if (check == true) {
            br.bID = Utils.getDate();
            br.assetID = rq.get(id).getaID();
            br.emID = rq.get(id).geteID();
            br.quantity = rq.get(id).getQuantity();
            br.bDate = Utils.getDate();
            rq.remove(id);
            try {
                IOFile.writeObject(rq, "request.DAT");
            } catch (Exception e) {
                System.out.println(e);
            }
            return br;
        } else {
            return null;
        }
    }

    public void show() {
        System.out.printf("%-40s%-20s%-20s%-20d%-40s\n", this.getbID(), this.getAssetID(), this.getEmID(), this.getQuantity(), this.getbDate());
    }

    public static void showTitle() {
        System.out.printf("%-40s%-20s%-20s%-20s%-40s\n", "bID", "assetID", "employeeID", "quantity", "borrowDateTime");
    }
}
