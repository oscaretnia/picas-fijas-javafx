/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oscaretnia
 */
public class LauncherController implements Initializable {
    
    @FXML
    private TextField name;
    @FXML
    private Spinner<Integer> level;   
    
    private void initLevels() {
        level.setValueFactory( new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7));
    }
    
    public void init(Stage stage){        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("launcher.fxml"));
            Scene scene = new Scene(root);                       
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Adivina Numero"); 
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initLevels();
    }   
    
    public void processGame(ActionEvent event) {   
        
        Integer l = level.getValue();
        String n = name.getText();
        
        Data.setPlayer(n, l);
        
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        new RulesController().init(stage);
        
        
        
    }
    
}
