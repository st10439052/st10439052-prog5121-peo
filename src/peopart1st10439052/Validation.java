/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peopart1st10439052;

/**
 *
 * @author sjaco
 */
public class Validation {
    String fusername,fpassword,ffirstname,flastname;

    public void setFusername(String fusername) {
        this.fusername = fusername;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword;
    }

    public void setFfirstname(String ffirstname) {
        this.ffirstname = ffirstname;
    }

    public void setFlastname(String flastname) {
        this.flastname = flastname;
    }

    public String getFusername() {
        return fusername;
    }

    public String getFpassword() {
        return fpassword;
    }

    public String getFfirstname() {
        return ffirstname;
    }

    public String getFlastname() {
        return flastname;
    }
    //constructor for calling the variables 
    public Validation(String fusername, String fpassword, String ffirstname, String flastname) {
        this.fusername = fusername;
        this.fpassword = fpassword;
        this.ffirstname = ffirstname;
        this.flastname = flastname;
    }
    
      // Method to validate username and show message
    public String checkusernametext() {
        if (fusername.length() <= 5 && fusername.contains("_")) {
            return "Username meets the criteria";
        } else {
            return "Username must be no longer than 5 characters and contain an underscore";
        }
    }
    
          //same method as above but to assign true or false
    public boolean checkusername() {
        if (fusername.length() <= 5 && fusername.contains("_")) {
            return true;
        } else {
            return false;
        }
    }
    // Method to validate password complexity rules adn show a message
    public String validatePasswordComplexitytext() {
        String message = "";

        // Check password length
        if (fpassword.length() < 8) {
            message += "Password must be at least 8 characters long. ";
        }

        // Check for capital letter
        if (!fpassword.matches(".*[A-Z].*")) {
            message += "Password must contain a capital letter. ";
        }

        // Check for a number
        if (!fpassword.matches(".*\\d.*")) {
            message += "Password must contain a number. ";
        }

        // Check for a special character
        if (!fpassword.matches(".*[^A-Za-z0-9].*")) {
            message += "Password must contain a special character. ";
        }
        //returning a message if the password is valid
        return message.isEmpty() ? "password succesfully captured" : message;
    }
    
       //same method as above Method to validate password complexity rules and show true/false
    public boolean validatePasswordComplexity() {


        // Check password length
        if (fpassword.length() < 8) {
            return false;
        }

        // Check for capital letter
        if (!fpassword.matches(".*[A-Z].*")) {
           return false;
        }

        // Check for a number
        if (!fpassword.matches(".*\\d.*")) {
           return false;
        }

        // Check for a special character
        if (!fpassword.matches(".*[^A-Za-z0-9].*")) {
           return false;
        }
        //returning a message if the password is valid
        return true;
    }
}    
    
 

