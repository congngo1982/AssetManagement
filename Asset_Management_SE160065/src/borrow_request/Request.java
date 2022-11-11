/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package borrow_request;

import asset.*;
import employee.*;
import java.io.Serializable;
import utils.Utils;

/**
 *
 * @author Admin
 */
public class Request implements Serializable{

    private String rID;
    private String aID;
    private String eID;
    private int quantity;
    private String rDate;

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
    }

    public String getaID() {
        return aID;
    }

    public void setaID(String aID) {
        this.aID = aID;
    }

    public String geteID() {
        return eID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public static Request request(AssetList as, Employee em) {
        String id;
        System.out.println("Asset List: ");
        as.showAll();
        do {
            id = Utils.getString("Enter id of Asset: ");
            if (!as.containsKey(id)) {
                System.out.println("No Id in List: ");
            }
        } while (!as.containsKey(id));
        Request re = new Request();
        re.rID = Utils.getDate();
        re.aID = as.get(id).getId();
        re.eID = em.getId();
        re.quantity = Utils.getInt("Enter Quantity of Asset: ", 0, as.get(id).getQuantity());
        as.get(id).update(re.quantity);
        try {
            asset.IOFile.writeObject(as, "asset.DAT");
        } catch (Exception e) {
        }
        re.rDate = Utils.getDate();
        return re;

    }

    public void show() {
        System.out.printf("%-40s%-20s%-20s%-20d%-40s\n", this.getrID(), this.getaID(), this.geteID(), this.getQuantity(), this.getrDate());
    }

    public static void showTitle() {
        System.out.printf("%-40s%-20s%-20s%-20s%-40s\n", "rID", "assetID", "employeeID", "quantity", "requestDateTime");
    }

}
