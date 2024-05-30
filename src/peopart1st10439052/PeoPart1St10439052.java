/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package peopart1st10439052;

import java.awt.GridLayout;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
//part 2
 if (isAuthenticated == true){

 int iAmountTask;   
iAmountTask =Integer.parseInt( JOptionPane.showInputDialog("Enter amount tasks"));   

        
        
        //prompt shown to the user
        String sNumMenu = "\n Please Choose One Of The Following Options\n"
                + "1) Add Tasks\n"
                + "2) Show Report\n"
                + "3) Quit ";

        String sSelectedNum = "0";
        

        do{
           sSelectedNum = JOptionPane.showInputDialog(sNumMenu);
             
        switch (Integer.parseInt(sSelectedNum)) {
            case 1:

        {

        String[] taskDescriptions = new String[iAmountTask];
        String[] developerDetails = new String[iAmountTask];
        String[] taskIDs = new String[iAmountTask];
        String[] taskStatuses = new String[iAmountTask];

        int currentTaskCount = 0;
        int totalHours = 0;

        while (currentTaskCount < iAmountTask) {
            // Create a custom panel with input fields
            JPanel panel = new JPanel(new GridLayout(6, 2)); // Add one row for Task Number, Task Name, and Duration
            JTextField descriptionField = new JTextField(20);
            JTextField developerField = new JTextField(20);
            JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"To Do", "Doing", "Done"});
            JTextField taskNumberField = new JTextField(20); // New field for Task Number
            JTextField taskNameField = new JTextField(20); // New field for Task Name
            JTextField durationField = new JTextField(20); // New field for Duration

            panel.add(new JLabel("Task Description:"));
            panel.add(descriptionField);
            panel.add(new JLabel("Developer Details:"));
            panel.add(developerField);
            panel.add(new JLabel("Task Status:"));
            panel.add(statusComboBox);
            panel.add(new JLabel("Task Number:")); // Add label for Task Number
            panel.add(taskNumberField);
            panel.add(new JLabel("Task Name:")); // Add label for Task Name
            panel.add(taskNameField);
            panel.add(new JLabel("Duration (hours):")); // Add label for Duration
            panel.add(durationField);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Enter Task Details", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the input values
                String taskDescription = descriptionField.getText();
                String developerDetail = developerField.getText();
                String taskStatus = Objects.requireNonNull(statusComboBox.getSelectedItem()).toString();
                String taskNumber = taskNumberField.getText();
                String taskName = taskNameField.getText();
                String durationString = durationField.getText();

                // Validate inputs here...

                // Calculate total hours
                int duration;
                try {
                    duration = Integer.parseInt(durationString);
                    totalHours += duration;
                } catch (NumberFormatException e) {
                    
                    JOptionPane.showMessageDialog(null, "Error: Invalid duration format. Please enter a valid number.");
                    continue;
                }

                // Generate the Task ID (format: TSK<number>)
                String taskId = taskName + ":" + taskNumber + ":" + developerDetail.substring(developerDetail.length() - 3).toUpperCase();
                taskIDs[currentTaskCount] = taskId;

                // Store the task details
                taskDescriptions[currentTaskCount] = taskDescription;
                developerDetails[currentTaskCount] = developerDetail;
                taskStatuses[currentTaskCount] = taskStatus;

                currentTaskCount++;
            } else {
                break; // User clicked on Cancel or closed the dialog
            }
        }

        // Display the stored data
        StringBuilder displayMessage = new StringBuilder("Task Details:\n");
        for (int i = 0; i < currentTaskCount; i++) {
            displayMessage.append("Task ID: ").append(taskIDs[i]).append("\n");
            displayMessage.append("Description: ").append(taskDescriptions[i]).append("\n");
            displayMessage.append("Developer: ").append(developerDetails[i]).append("\n");
            displayMessage.append("Status: ").append(taskStatuses[i]).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, displayMessage.toString(), "Tasks", JOptionPane.INFORMATION_MESSAGE);
        
            // Display total hours
            System.out.println("Total Hours: " + totalHours);
        }

        

                
            break;
            
            case 2:
                System.out.println("Coming Soon");    
            break;
            
            case 3:
                System.out.println("Quiting Application");
                System.exit(0);
            break;
                  
            default:
                System.out.println("Please enter a Value From 1 to 3");;
        }
        }while (!(Integer.parseInt(sSelectedNum) == 3));


}        
    }

}
       

    
    
    

    

