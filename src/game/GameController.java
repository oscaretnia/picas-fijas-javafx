/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oscaretnia
 */
public class GameController implements Initializable {
    
    
    private Game game;
    private Timer timer;
    private Player player;

    @FXML
    private Label title, time, score;
    
    @FXML
    private TextField number;
    
    @FXML
    private TableView table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        game = new Game();         
        player = Data.getPlayer();        
        title.setText("¡A jugar " + player.getName() + "!");   
        score.setText(player.getPoints() + "");
        setTime(player.getLevel().getTime());
        
    }  
        
    public void init(Stage stage) {       
        try {
            Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));                       
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Adivina Numero"); 
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LauncherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void attempt(ActionEvent event) {
        ObservableList<Attempt> data = table.getItems();
        
        if (isValidNumber(number.getText())) {
            game.play(number.getText());
        }
        
        if (game.getState()) {
            showMessage("Ganaste el juego","Ganador");
            player.setPoints(game.getPoints(player.getLevel().getFigures(), getTime()));
            score.setText(player.getPoints() + "");
            Data.upLevel();
        } else {
            
            int f = game.getFigures(), fo = 0;
            
            if (f != fo) {
                fo = f;
                showMessage("¡Excelente!","Adivinaste la cifra");
                player.setPoints(game.getPoints(player.getLevel().getFigures(), getTime()));
                score.setText(player.getPoints() + "");
            }
            
            data.add(new Attempt(
                Integer.parseInt(number.getText()),
                game.getHits(),
                game.getRights()
            ));
            
            player.setPoints(-5);
            score.setText(player.getPoints() + "");
        }       
    }
    
    private boolean isValidNumber(String number) {
        number = number.trim();
                
        if (number.length() != 4) {
            showError("Formato invalido", "El numero debe tener 4 cifras");
            return false;
        }
        
        try {
            Integer.parseInt(number);
        } catch(Exception ex) {
            showError("Formato invalido", "El numero no es valido");
            return false;
        }
        
        return true;
    }
    
    private void setTime(Integer tim) {
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            int res = 0;
            @Override
            public void run(){
                Platform.runLater( ()-> {
                    if (tim - res >= 0) {
                        time.setText(String.valueOf(tim - res));
                        res++;
                    } else {
                        timer.cancel();
                        game.finish();
                        player.setPoints(-50);
                        score.setText(player.getPoints() + "");
                        showMessage("Fin del juego", "Se acabo el tiempo reglamentario\nLa cifra secreta era " + game.getGenerated());
                    }
                });
            }
        }, 1, 1000);
    }
    
    public Integer getTime() {
        timer.cancel();
        int tim = Integer.parseInt(time.getText());        
        return tim;
    }
    
    private void showMessage(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
    
    private void showError(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
    
}
