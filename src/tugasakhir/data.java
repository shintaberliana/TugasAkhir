/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author SMK TELKOM
 */
public class data {

    static void add(data data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final StringProperty Nama;
    private final StringProperty Alamat;
    private final StringProperty Telp;
    private final StringProperty Tgl;
  
    public data(String nama, String alamat, String telp, String tgl){
        this.Nama = new SimpleStringProperty(nama);
        this.Alamat = new SimpleStringProperty(alamat);
        this.Telp = new SimpleStringProperty(telp);
        this.Tgl = new SimpleStringProperty(tgl);
    }

    data(String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getNama(){
        return Nama.get();
    }
    
    public String getAlamat(){
        return Alamat.get();
    }
    
    public String getTelp(){
        return Telp.get();
    }
    
    public String getTanggal(){
        return Tgl.get();
    }
    
    public void setNama(String value){
        Nama.set(value);
    }
    
    public void setAlamat(String value){
        Alamat.set(value);
    }
    
    public void setTelp(String value){
        Telp.set(value);
    }
    
    public void setTanggal(String value){
        Tgl.set(value);
    }
    
    public StringProperty namaProperty(){
        return Nama;
    }
    
    public StringProperty alamatProperty(){
        return Alamat;
    }
    
    public StringProperty telpProperty(){
        return Telp;
    }
    
    public StringProperty tglProperty(){
        return Tgl;
    }
}
