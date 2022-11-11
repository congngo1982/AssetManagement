/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asset;

import java.util.HashMap;
import utils.Menu;
import utils.Utils;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class AssetList extends HashMap<String, Asset> implements A_List {

    public AssetList() {
        try {
            IOFile.readObject(this, "asset.DAT");
        } catch (Exception e) {
        }
    }

    public void add() {
        String id;
        do {
            id = Utils.getString("Enter Id of Asset: ");
            if (this.containsKey(id)) {
                System.out.println("Id has been Existed.");
            }
        } while (this.containsKey(id));
        Asset asset = new Asset(id);
        asset.add();
        this.put(id, asset);
        try {
            IOFile.writeObject(this, "asset.DAT");
        } catch (Exception e) {
        }
    }

//    public void add(Asset as) {
//        this.put(as.getId(), as);
//    }
    public void show() {
        String id = Utils.getString("Enter Id of Asset: ");
        if (this.containsKey(id)) {
            AssetList.showTitle();
            this.get(id).show();
        } else {
            System.out.println("No Data");
        }
    }

    public void showAll() {
        Set<String> id = this.keySet();
        if (id.isEmpty()) {
            System.out.println("No Data");
        } else {
            this.showTitle();
            for (String Id : id) {
                this.get(Id).show();
            }
        }
    }

    public void update() {
        String id = Utils.getString("Enter Id of Asset: ");
        if (this.containsKey(id)) {
            this.get(id).update();
            try {
                IOFile.writeObject(this, "asset.DAT");
            } catch (Exception e) {
            }
        } else {
            System.out.println("No Id in List");
        }
    }

    public static void showTitle() {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "assetId", "name", "color", "price", "quantity", "weight");
    }

    public void search() {
        Set<String> id = this.keySet();
        int d = 0;
        String name = Utils.getString("Enter Name of Asset: ");
        for (String Id : id) {
            if (this.get(Id).getName().equals(name)) {
                this.showTitle();
                this.get(Id).show();
                d++;
            }
        }
        if (d == 0) {
            System.out.println("No Asset in List");
        }
    }
}
