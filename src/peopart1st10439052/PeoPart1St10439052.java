/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package peopart1st10439052;

import javax.swing.JOptionPane;

/**
 *
 * @author st10439052
 */

public class PeoPart1St10439052 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declaring sign up variables 
     String username,password,firstname,lastname; 
        //declaring variables to test validation
     String svalidUsername, svalidPassword;
        //declaring variables for login
     String usernameLogin, passwordLogin;
     
     //inserting all the values into their variables
     username = JOptionPane.showInputDialog(null, "enter your username for signup");
     password = JOptionPane.showInputDialog(null, "enter your password for signup");
     firstname = JOptionPane.showInputDialog(null, "enter your firstname for signup");
     lastname = JOptionPane.showInputDialog(null, "enter your lastname for signup");
     
     //calling the constructor for all the get and set methods
       Validation validation = new Validation(username, password, firstname, lastname);
       

       
 boolean isValidUsername = false;
//while loop to retry username if entered uncorectly
while (!isValidUsername) {
    svalidUsername = validation.checkusernametext();
    System.out.println(svalidUsername);

    if (validation.checkusername()) {
        isValidUsername = true;
    } else {
        username = JOptionPane.showInputDialog(null, "Enter your username for signup");
        validation.setFusername(username);
    }
}
         

boolean isValidPassword = false;
//while loop to retry password if entered uncorectly
while (!isValidPassword) {
   svalidPassword = validation.validatePasswordComplexitytext();
    System.out.println(svalidPassword);

    if (validation.validatePasswordComplexity()) {
        isValidPassword = true;
    } else {
        password = JOptionPane.showInputDialog(null, "Enter your password for signup");
        validation.setFpassword(password);
    }
}

//message for succesful signup
System.out.println("you have successfully created account username " + username + " Password " + password);
        
     //boolean for login loop
        boolean isAuthenticated = false;
        // loop until isAuthenticated is true
         while (!isAuthenticated) {
     //inserting the login values into their variables  
     usernameLogin = JOptionPane.showInputDialog(null, "enter your username");
     passwordLogin = JOptionPane.showInputDialog(null, "enter your password");
     
     //validating if the usernames and passwords match
            if (usernameLogin.equals(username) && passwordLogin.equals(password)) {
                //showing a welcome message
            System.out.println("Welcome " + firstname +", "+ lastname + ", it is great to see you again.");
            isAuthenticated = true;
        } else {
                //showing a error message
            System.out.println("Username or password incorrect, please try again.");
            }
        }
    }
    

    }
    

