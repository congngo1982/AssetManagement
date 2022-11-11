/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package borrow_request;

import asset.*;
import employee.*;
import utils.Utils;

/**
 *
 * @author Admin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        AssetList as = new AssetList();
        Employee em = null;
//        for (int i = 1; i <= 4; i++) {
//            em = new Staff(Utils.getString("Enter Id: "));
//            RequestList rq = new RequestList();
//            rq.add(as, em);
//        }
        RequestList rq = new RequestList();
        rq.show();
    }
}
