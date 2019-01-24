/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project; 

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zawar
 */
//this is the first screen a manager sees when they log in
public class ManagerMenuController implements Initializable {

    protected String customerUser;
    protected String customerPass;

    /**
     * Initializes the controller class.
     *
     * @param event
     * @throws java.io.IOException
     */
    //returns to the login page
    public void logout(ActionEvent event) throws IOException {
        FXMLLoader loginPaneLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loginPaneLoader.load();
        Scene login = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(login);
        primaryStage.show();

    }
    
    //switches scene to adding customer page
    public void addCustomer(ActionEvent event) throws IOException {
        FXMLLoader addCustomerPaneLoader = new FXMLLoader(getClass().getResource("AddCustomer.fxml"));
        Parent root = addCustomerPaneLoader.load();
        Scene addCustomer = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(addCustomer);
        primaryStage.show();
    }
    
    //switches scene to deleting customer page
    public void deleteCustomer(ActionEvent event) throws IOException {
        FXMLLoader removeCustomerPaneLoader = new FXMLLoader(getClass().getResource("DeleteCustomer.fxml"));
        Parent root = removeCustomerPaneLoader.load();
        Scene removeCustomer = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(removeCustomer);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
