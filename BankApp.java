/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project; 

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author zawar
 */
public class BankApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loginPaneLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loginPaneLoader.load();
        Scene login = new Scene(root);

        primaryStage.setScene(login);
        primaryStage.show();

    }

    /**
     *
     * @param e
     * @throws java.lang.Exception
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
