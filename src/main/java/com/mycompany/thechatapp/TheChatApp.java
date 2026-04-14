/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.thechatapp;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Student
 */
public class TheChatApp {

   private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Check if username meets requirements
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check if password meets complexity requirements
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE).matcher(password).find();
        return password.length() >= 8 && hasUpper && hasDigit && hasSpecial;
    }

    // Handles the registration process and returns status messages
    public String registerUser(String user, String pass, String first, String last, String phone) {
        if (!checkUserName(user)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(pass)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        
        this.username = user;
        this.password = pass;
        this.firstName = first;
        this.lastName = last;
        this.phoneNumber = phone;
        return "User has been registered successfully.";
    }

    // Validates login credentials
    public boolean loginUser(String enteredUser, String enteredPass) {
        return enteredUser.equals(this.username) && enteredPass.equals(this.password);
    }

    // Returns the final login status message
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main entry point for interactive console
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TheChatApp auth = new TheChatApp();

        System.out.println("--- Registration ---");
        System.out.print("First Name: ");
        String fname = sc.nextLine();
        System.out.print("Last Name: ");
        String lname = sc.nextLine();
        System.out.print("Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        String regStatus = auth.registerUser(user, pass, fname, lname, phone);
        System.out.println(regStatus);

        if (regStatus.contains("successfully")) {
            System.out.println("\n--- Login ---");
            System.out.print("Username: ");
            String loginUser = sc.nextLine();
            System.out.print("Password: ");
            String loginPass = sc.nextLine();

            boolean success = auth.loginUser(loginUser, loginPass);
            System.out.println(auth.returnLoginStatus(success));
        }
    }
}
