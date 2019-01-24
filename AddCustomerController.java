/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author zawar
 */
//This class is reponsible for adding the customer file
public class AddCustomerController extends ManagerMenuController implements Initializable {

    //private File directory = new File("BankApp/customers").listFiles();
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Label confirm;

    private FileWriter writer;
    
     //returns to the manager menu screen
    public void returnManagerMenu(ActionEvent event) throws IOException {
        FXMLLoader managerPaneLoader = new FXMLLoader(getClass().getResource("ManagerMenu.fxml"));
        Parent root = managerPaneLoader.load();
        Scene manager = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(manager);
        primaryStage.show();
    }
    
    //responsible for creating customer files, catches the following errors: customers cant have a username named
    //admin, usernames cant be duplicates
    @Override
    public void addCustomer(ActionEvent event) throws IOException {

        customerUser = user.getText();
        customerPass = pass.getText();
        if (customerUser.equals("admin"))
         {
            confirm.setText("You can not add another admin!");
        } else {
            File customer = new File(customerUser);
            if (customer.exists()) {
                confirm.setText("Username exists already!");
            } else {
                writer = new FileWriter(customer);
                writer.write(customerUser);
                writer.write(System.getProperty("line.separator"));
                writer.write(customerPass);
                writer.write(System.getProperty("line.separator"));
                writer.write("100");
                writer.close();

                confirm.setText("Customer file created for " + customerUser);
            }
        }
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.show();

    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
