/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* This is comment, do not delete 2021.11.30
 * and open the template in the editor.
 */
package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hd
 */
public class Utils {

    public static int getInt(String title) {
        int result = 0;
        boolean check = true;
        System.out.println(title);
        do {
            try {
                Scanner sc = new Scanner(System.in);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("You must input an integer!!!");
            }
        } while (check);
        return result;
    }

    public static float getFloat(String title) {
        float result = 0;
        boolean check = true;
        System.out.println(title);
        do {
            try {
                Scanner sc = new Scanner(System.in);
                result = Float.parseFloat(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("You must input an float!!!");
            }
        } while (check);
        return result;
    }

    public static int getInt(String title, int a, int b) {
        int choice;
        do {
            choice = getInt(title);
            if (choice < a || choice > b) {
                System.out.println("Your must input from " + a + " to " + b);
            }
        } while (choice < a || choice > b);
        return choice;
    }

    public static String getString(String title) {
        String result = null;
        boolean check = true;
        System.out.println(title);
        do {
            try {
                Scanner sc = new Scanner(System.in);
                result = sc.nextLine();
                if (!result.isEmpty()) {
                    check = false;
                } else {
                    System.out.println("You need to input here!!!");
                }
            } catch (Exception e) {
                System.out.println("You must input String!!!");
            }
        } while (check);
        return result;
    }

    public static String update(String title, String old) {
        String result = old;
        boolean check = true;
        System.out.println(title);
        do {
            try {
                Scanner sc = new Scanner(System.in);
                result = sc.nextLine();
                if (result.isEmpty()) {
                    result = old;
                    check = false;
                } else {
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("ERRORS");
            }
        } while (check);
        return result;
    }

    public static int updateInt(String title, int old) {
        int result = old;
        boolean check = true;
        String test = String.valueOf(old);
        do {
            try {
                result = Integer.parseInt(Utils.update(title, test));
                check = false;
            } catch (Exception e) {
                System.out.println("You must update Integer!!!");
            }
        } while (check);
        return result;
    }

    public static float updateFloat(String title, float old) {
        float result = old;
        boolean check = true;
        String test = String.valueOf(old);
        do {
            try {
                result = Float.parseFloat(Utils.update(title, test));
                check = false;
            } catch (Exception e) {
                System.out.println("You must update Integer!!!");
            }
        } while (check);
        return old;
    }

    public static boolean getChoice(String title) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println(title);
            choice = sc.nextLine();
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
        if (choice.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = "";
        boolean check;
        do {
            confirm = Utils.getString(welcome);
            if (confirm.equalsIgnoreCase("y")) {
                check = false;
            } else if (confirm.equalsIgnoreCase("n")) {
                check = false;
            } else {
                check = true;
            }
        } while (!confirm.equalsIgnoreCase("y") && !confirm.equalsIgnoreCase("n"));
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    public static String byteToHex(byte[] data) {
        BigInteger number = new BigInteger(1, data);
        String hashtext = number.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static String enCodeMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            return byteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDate() {
        Date a = new Date();
        return DateFormat.getDateTimeInstance().format(a);
    }

}
