/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.table.DefaultTableModel;


/**
 * FXML Controller class
 *
 * @author SMK TELKOM
 */
public class MenuRegistrasiController implements Initializable {

    @FXML
    private TextField nama;
    @FXML
    private TextField alamat;
    @FXML
    private TextField telp;
    @FXML
    private TextField tgl;
    @FXML
    private JFXButton btnproses;
    @FXML
    private JFXButton btnreset;
    @FXML
    private TextArea ta;
    @FXML
    private ToggleGroup kodebrg;
    @FXML
    private JFXRadioButton atasan;
    @FXML
    private JFXRadioButton mukena;
    @FXML
    private JFXRadioButton pashmina;
    @FXML
    private JFXRadioButton bawahan;
     @FXML
    private JFXButton btnreset1;
    @FXML
    private JFXButton btnreset2;
    @FXML
    private JFXButton btnhapus;
    @FXML
    private TableView<data> tabel;
    @FXML
    private TableColumn<data, String> nm;
    @FXML
    private TableColumn<data, String> almt;
    @FXML
    private TableColumn<data, String> tlp;
    @FXML
    private TableColumn<data, String> tg;
    @FXML
    private TableColumn<data, String> harga;
    @FXML
    private JFXButton btntampil;
    private ObservableList<data>doto;
    private data dc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proses(ActionEvent event) {
    
        if(!(atasan.isSelected() || bawahan.isSelected() || mukena.isSelected() || pashmina.isSelected() )){
            JOptionPane.showMessageDialog(null, "Harap Pilih Kode Barang");
        } else{
        try{
            String sql= "INSERT INTO registrasi (nama,alamat,telp,tgl) VALUES ('"+nama.getText()+"','"+alamat.getText()+"',"
                    + "'"+telp.getText()+"','"+tgl.getText()+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Save Success");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal"+ e.getMessage());
        }
    }
    }
   
    
    @FXML
    private void tampilkan(ActionEvent event) {
        Connection con;
        Statement stat;

        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = (Statement) DB.stm;
        try{
            doto = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM registrasi");
            while (rs.next()){
                doto.add(new data(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        
        nm.setCellValueFactory(new PropertyValueFactory<>("nama"));
        almt.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        tlp.setCellValueFactory(new PropertyValueFactory<>("telp"));
        tg.setCellValueFactory(new PropertyValueFactory<>("tgl"));
       
        

        tabel.setItems(null);
        tabel.setItems(doto);

    }

    @FXML
    private void hapus(ActionEvent event) {
        try{
            data val = tabel.getSelectionModel().getSelectedItem();
            String sql = "DELETE FROM registrasi WHERE nama='"+val.getNama()+"'";
            System.out.println(sql);
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sukses Hapus");
            tampilkan(event);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Hapus"+ nama);
        }

    }
    
    
    @FXML
    private void reset(ActionEvent event) {
        nama.setText("");
        alamat.setText("");
        telp.setText("");
        atasan.setSelected(false);
        mukena.setSelected(false);
        pashmina.setSelected(false);
        bawahan.setSelected(false);
        tgl.setText("");
        ta.setText("");
    }
    
     @FXML
    void home(ActionEvent event) {
         try{
        // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("DaftarBarang.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Hijab-Shop");
            stage.show();
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
        
        }    

    }
    

    @FXML
    void keluar(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
}
