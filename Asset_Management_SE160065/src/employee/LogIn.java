/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import utils.Utils;

/**
 *
 * @author Admin
 */
public class LogIn {

    public static Employee login(EmployeeList em) {
        String id = Utils.getString("Enter Id of Employee: ");
        if (em.containsKey(id)) {
            String password = Utils.enCodeMD5(Utils.getString("Enter Password: "));
            if (password.equals(em.get(id).getPassword())) {
                System.out.println("Succesfull");
                return em.get(id);
            } else {
                System.out.println("Incorrect Id or Password");
                return null;
            }
        } else {
            System.out.println("Incorrect Id or Password");
            return null;
        }
    }
}
