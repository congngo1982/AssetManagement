/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public abstract class Employee implements Serializable {

    private String id;
    private String name;
    private String birthday;
    private String sex;
    private String password;

    public Employee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void add();

    public abstract void show();

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + ", sex=" + sex + ", password=" + password + '}';
    }

    public boolean isManager() {
        if (this instanceof Manager) {
            return true;
        } else {
            return false;
        }
    }

}
