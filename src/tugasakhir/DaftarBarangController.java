/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class DaftarBarangController implements Initializable {

        @FXML
    private ImageView atasan;

    @FXML
    private ImageView mukena;

    @FXML
    private ImageView pashmina;

    @FXML
    private JFXButton btnpesan;

    @FXML
    private ImageView bawahan;

    @FXML
    void atasan(ActionEvent event) throws IOException {
            try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            //load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MenuRegistrasi.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 550, 670);
            //
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("MenuRegistrasi");
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
            
        }
    }

    @FXML
    void bawahan(ActionEvent event) throws IOException {
       try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            //load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MenuRegistrasi.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 550, 670);
            //
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("MenuRegistrasi");
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
            
        }
    
    }

    @FXML
    void mukena(ActionEvent event) throws IOException {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            //load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MenuRegistrasi.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 550, 670);
            //
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("MenuRegistrasi");
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
            
        }
    
    }

    @FXML
    void pashmina(ActionEvent event) throws IOException {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            //load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MenuRegistrasi.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 550, 670);
            //
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("MenuRegistrasi");
            stage.show();
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
            
        }
    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
