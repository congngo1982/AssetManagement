/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asset;

import java.io.Serializable;
import utils.Utils;

/**
 *
 * @author Admin
 */
public class Asset implements Serializable {

    private String id;
    private String Name;
    private String Color;
    private int Price;
    private float weight;
    private int quantity;

    public Asset(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void add() {
        this.Name = Utils.getString("Enter Name of Asset: ");
        this.Color = Utils.getString("Enter Color of Asset: ");
        this.Price = Utils.getInt("Enter Price of Asset: ");
        this.quantity = Utils.getInt("Enter Quantity of Asset: ");
        this.weight = Utils.getFloat("Enter Weight of Asset: ");
    }

    public void show() {
        System.out.printf("%-20s%-20s%-20s%-20d%-20d%-20f\n", this.getId(), this.getName(), this.getColor(), this.getPrice(), this.getQuantity(), this.getWeight());
    }

    public void update(int num) {
        this.quantity = this.quantity - num;
    }

    public void update() {
        this.Name = Utils.update("Update Name of Asset: ", this.getName());
        this.Color = Utils.update("Update Color of Asset: ", this.getColor());
        this.Price = Utils.updateInt("Update Price of Asset: ", this.getPrice());
        this.quantity = Utils.updateInt("Update Quantity of Asset: ", this.getQuantity());
        this.weight = Utils.updateFloat("Update Weight of Asset: ", this.getWeight());
    }
}
