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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oscaretnia
 */
public class RulesController implements Initializable {
    
    @FXML
    private ListView<String> listRules;;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> items = FXCollections.observableArrayList(
                "- Digita una cifra numerica hasta adivinar la cifra secreta",
                "- La cifra que digites debe tener 4 numeros",
                "- No puedes ingresar numeros repetidos en la misma cifra",
                "- Si digita un numero que no esta en la cifra se le restaran 5 puntos", 
                "- Si el tiempo llega al final y no ha adivinado la cifra se le restaran 50 puntos", 
                "- Por cada cifra acertada serán 50 puntos mas la cantidad de tiempo restante", 
                "  que le sobre en cada nivel"
        );
        
        listRules.setItems(items);
    }   
    
    public void processGame(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        new GameController().init(stage);
    }
    
    public void init(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("rules.fxml"));                       
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Adivina Numero"); 
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LauncherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
