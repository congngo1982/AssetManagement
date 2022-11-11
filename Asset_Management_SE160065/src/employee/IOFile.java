/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package employee;

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

    public static void writeObject(EmployeeList em, String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Set<String> id = em.keySet();
        try {
            for (String Id : id) {
                oos.writeObject(em.get(Id));
            }
            System.out.println("Success.");
        } catch (Exception e) {
            System.out.println("Fail in Method");
            System.out.println(e);
        } finally {
            oos.close();
        }
    }

    public static void readObject(EmployeeList em, String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while (fis.available() > 0) {
                Employee emp = (Employee) ois.readObject();
                em.put(emp.getId(), emp);
            }
        } catch (Exception e) {
        } finally {
            fis.close();
            ois.close();
        }
    }
}
