/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zawar
 */
public class LoginController implements Initializable {

    //OVERVIEW: This class represents a login page for a bank account
    //This class is mutable
    //Abstract Function: AF(c) = a logincontroller l,  such that
    //                           c.username = l.user, c.password = l.pass
    //Rep Invariant: RI(c) = true if c.username !=null, c.password !=null
    //                       false otherwise
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private Label confirm;

    private String username, password, line = null;
    private final String managerid = "admin";

    private File customerFile;
    private final ArrayList<String> customerData = new ArrayList<>();
    private BufferedReader reader;

    //Effects: returns the username 
    public String getUsername() throws IOException {
        username = user.getText();
        return username;
    }

    //Effects: returns the password
    /**
     *
     * @return @throws IOException
     */
    public String getPassword() throws IOException {
        password = pass.getText();
        return password;
    }

    //Modifies: reads and writes the username, password and balance from a file into the object's customerdata arraylist 
    //Effects:Returns a customers username, passowrd and balance in an arraylist from a file.
    public ArrayList<String> getCustomerData() throws IOException {
        customerFile = new File(getUsername());
        if (customerFile.exists()) {

            reader = new BufferedReader(new FileReader(getUsername()));
            while ((line = reader.readLine()) != null) {
                customerData.add(line);
            }
            reader.close();
        } else {
            customerData.add("");
            customerData.add("");
            customerData.add("");
        }
        return (customerData);
    }

    //Requires:an event (button)
    //Effects:Checks username and password, to see if it matches with any customer's username and pasword, or the manager's
    //username and password.
    /**
     *
     * @param event
     * @throws IOException
     */
    public void verify(ActionEvent event) throws IOException {
        FXMLLoader customerPaneLoader = new FXMLLoader(getClass().getResource("CustomerMenu.fxml"));
        Parent root = customerPaneLoader.load();
        Scene customer = new Scene(root);

        FXMLLoader managerPaneLoader = new FXMLLoader(getClass().getResource("ManagerMenu.fxml"));
        Parent root2 = managerPaneLoader.load();
        Scene manager = new Scene(root2);

        if (getUsername().equals("") || getPassword().equals("")) {
            confirm.setText("Invalid Username/Password");
        } else {
            if (getUsername().equals(managerid) && getPassword().equals(managerid)) {
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(manager);
                primaryStage.show();
            } else {
                if (getUsername().equals(getCustomerData().get(0)) && getPassword().equals(getCustomerData().get(1))) {
                    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    CustomerMenuController customer1 = customerPaneLoader.getController();
                    customer1.setCustomerData(getCustomerData());

                    primaryStage.setScene(customer);
                    primaryStage.show();
                } else {
                    confirm.setText("Invalid Username/Password");
                }
            }
        }
    }

    // Implementation of Abstract Function
    @Override
    public String toString() {
        try {
            return "Username: " + getCustomerData().get(0) + " Password: " + getCustomerData().get(1);
        } catch (IOException ex) {
            return "Error: IOException caught";
        }
    }

    // Implementation of Rep Invariant
    /**
     *
     * @return
     */
    public boolean repOK() {
        if (username != null && password != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
