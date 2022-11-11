/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package borrow_request;

import asset.*;
import employee.Employee;
import employee.EmployeeList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class IOFile {

    public static void writeObject(BorrowList br, String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Set<String> id = br.keySet();
        try {
            for (String Id : id) {
                oos.writeObject(br.get(Id));
            }
            System.out.println("Success.");
        } catch (Exception e) {
            System.out.println("Fail in Method");
            System.out.println(e);
        } finally {
            oos.close();
        }
    }

    public static void readObject(BorrowList br, String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while (fis.available() > 0) {
                Borrow item = (Borrow) ois.readObject();
                br.put(item.getbID(), item);
            }
        } catch (Exception e) {
        } finally {
            fis.close();
            ois.close();
        }
    }

    public static void writeObject(RequestList rq, String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Set<String> id = rq.keySet();
        try {
            for (String Id : id) {
                oos.writeObject(rq.get(Id));
            }
            System.out.println("Success.");
        } catch (Exception e) {
            System.out.println("Fail in Method");
            System.out.println(e);
        } finally {
            oos.close();
        }
    }

    public static void readObject(RequestList rq, String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while (fis.available() > 0) {
                Request item = (Request) ois.readObject();
                rq.put(item.getrID(), item);
            }
        } catch (Exception e) {
        } finally {
            fis.close();
            ois.close();
        }
    }
}
