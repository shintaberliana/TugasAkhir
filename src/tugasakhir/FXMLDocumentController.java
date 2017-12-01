/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXPasswordField;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField pswd;
    @FXML
    private JFXButton oke;
    @FXML
    private JFXButton oke1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void oke(ActionEvent event) throws IOException, SQLException {
        Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;                                      
                
        try {
            sql = "SELECT * FROM login WHERE username='"+username.getText()+"' AND password='"+pswd.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.getText().equals(rs.getString("username")) && pswd.getText().equals(rs.getString("password"))){
               
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("DaftarBarang.fxml"));
                      
            
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Hijab-Shop");
            stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @FXML
    void back(ActionEvent event) {
        try{
        // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Daftar.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ((Node)(event.getSource())).getScene().getWindow().hide();
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Hijab-Shop");
            stage.show();
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
        
        }    

    }
    }



