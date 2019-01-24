/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project; 

import java.io.File;
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
//this class is responsible for deleting customer files
public class DeleteCustomerController extends ManagerMenuController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private Label confirm;
    //returns to the manager menu
    public void returnManagerMenu(ActionEvent event) throws IOException {
        FXMLLoader managerPaneLoader = new FXMLLoader(getClass().getResource("ManagerMenu.fxml"));
        Parent root = managerPaneLoader.load();
        Scene manager = new Scene(root);

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(manager);
        primaryStage.show();
    }
    //deletes a customers file, if it exists
    public void removeCustomer(ActionEvent event) throws IOException {
        customerUser = user.getText();
       
        File file = new File(customerUser); 
          
        if(file.delete()) 
        { 
           confirm.setText("File deleted successfully for " + customerUser); 
        } 
        else
        { 
           confirm.setText("Failed to delete the file"); 
        } 

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.show();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
