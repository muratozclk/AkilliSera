/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

import application.MaterialText;
import application.TabTitle;
import application.ToggleButton;
import static java.awt.Color.white;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Halil
 */
public class Content1Controller implements Initializable {
   
    @FXML
    private TextField txt_sad;
    @FXML
    private TextField txt_sadres;
    @FXML
    private TextField txt_ip;
    @FXML
    private TextField txt_port;
    @FXML
    private TextField txt_sicaklik;
    @FXML
    private TextField txt_nem;
    @FXML
    private ComboBox<String> cmb_urun;
    @FXML
    public ComboBox<String> cmb_ssec;
    @FXML
    private Button btn_baglan;
    @FXML
    private Button btn_duzenle;
    @FXML
    private Button btn_sil;
    @FXML
    private Button btn_kaydet;
    
    public ObservableList<String> urunler=FXCollections.observableArrayList();
    public ObservableList<String> seralar=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        SeraSorgu seraSorgu=new SeraSorgu();
        UrunSorgu urnsorgu=new UrunSorgu();
        urunler=urnsorgu.urunGetir();
        Collections.sort(urunler);
        cmb_urun.setItems(urunler);
        seralar=seraSorgu.seraAd();
                    Collections.sort(seralar);
                    cmb_ssec.setItems(seralar);                                                        
    }    

    @FXML
    private void seraDuzenle(ActionEvent event) throws SQLException {
          Sera sera=new Sera();
        SeraSorgu sorgu=new SeraSorgu();
        sera=sorgu.bilgileriGetir(cmb_ssec.getSelectionModel().getSelectedItem());
       txt_sad.setText(sera.getSera_adi());
       txt_sadres.setText(sera.getSera_adres());
       txt_ip.setText(sera.getIP());
       txt_port.setText(String.valueOf(sera.getPort()));
       cmb_urun.getSelectionModel().select(sera.getUrun_cinsi());
       txt_sicaklik.setText(String.valueOf(sera.getSicaklik()));
       txt_nem.setText(String.valueOf(sera.getNem()));
       
       btn_kaydet.setText("Güncelle");
    }

  

    @FXML
    private void seraKaydet(ActionEvent event) {
          if(btn_kaydet.getText().equals("Kaydet")){
          int sicak=Integer.valueOf(txt_sicaklik.getText());
        int nem=Integer.valueOf(txt_nem.getText());
        int port=Integer.valueOf(txt_port.getText());
        Sera sera=new Sera(txt_sad.getText(), txt_sadres.getText(), txt_ip.getText(), port,cmb_urun.getSelectionModel().getSelectedItem(), sicak, nem);
        SeraSorgu seraSorgu=new SeraSorgu();
        try {        
        seraSorgu.seraKaydet(sera);
      
            seralar=seraSorgu.seraAd();
                    Collections.sort(seralar);
                    cmb_ssec.setItems(seralar);
                    
       
       
        } catch (Exception e) {
            System.out.println(seraSorgu.mesaj);
        }
        temizle();
        }
        else if(btn_kaydet.getText().equals("Güncelle")){
             int sicak=Integer.valueOf(txt_sicaklik.getText());
        int nem=Integer.valueOf(txt_nem.getText());
        int port=Integer.valueOf(txt_port.getText());
            Sera sera=new Sera(txt_sad.getText(), txt_sadres.getText(), txt_ip.getText(), port,cmb_urun.getSelectionModel().getSelectedItem(), sicak, nem);
        SeraSorgu seraSorgu=new SeraSorgu();
        seraSorgu.seraDegistir(sera);
        btn_kaydet.setText("Kaydet");
        temizle();
        cmb_ssec.getSelectionModel().clearSelection();
        }
    }
    public void temizle(){
    txt_sad.clear();
        txt_nem.clear();
        txt_port.clear();
        txt_ip.clear();
        cmb_urun.getSelectionModel().clearSelection();
        txt_sicaklik.clear();
        txt_sadres.clear();
}
    
    
}

