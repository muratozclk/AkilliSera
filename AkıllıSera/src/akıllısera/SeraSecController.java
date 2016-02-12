/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Halil
 */
public class SeraSecController implements Initializable {
    @FXML
    private TextField txt_sad;
    @FXML
    private TextField txt_sadres;
    @FXML
    private TextField txt_sicaklik;
    @FXML
    private TextField txt_nem;
    @FXML
    private TextField txt_ip;
    @FXML
    private TextField txt_port;
    @FXML
    private Button btn_kaydet;
    @FXML
    private ComboBox<String> cmb_urun;
    @FXML
    private Button btn_baglan;
    @FXML
    private Button btn_duzenle;
    @FXML
    private Button btn_sil;
    @FXML
    private ComboBox<String> cmb_ssec;
   public ObservableList<String> urunler=FXCollections.observableArrayList();
   public ObservableList<String> seralar=FXCollections.observableArrayList();
    @FXML
    private Button btn_sicaklik;
    @FXML
    private Button btn_azalt;
    @FXML
    private Label lbl_sicaklik;
    public  Socket socket ;
    public PrintWriter out;
    public BufferedReader in;
    public String inputLine, outputLine;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void seraKaydet(ActionEvent event) throws SQLException {
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
        }
    }

    @FXML
    private void seraBaglan(ActionEvent event) {
        SeraSorgu seraSorgu=new SeraSorgu();
        lbl_sicaklik.setText("Sıcaklık:"+seraSorgu.sicaklikGetir(cmb_ssec.getSelectionModel().getSelectedItem()));
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
    private void sera_sil(ActionEvent event) throws IOException {
        
      


    }
    public void temizle(){
     txt_sad.clear();
        txt_nem.clear();
        txt_port.clear();
        txt_ip.clear();
        cmb_urun.getSelectionModel().clearSelection();
        txt_sicaklik.clear();
        txt_sadres.clear();}

    @FXML
    private void sicaklikArtar(ActionEvent event) throws SQLException, IOException {
        
        Sera sera=new Sera();
        SeraSorgu sorgu=new SeraSorgu();
        sera=sorgu.bilgileriGetir(cmb_ssec.getSelectionModel().getSelectedItem());
        sorgu.sicaklikArtir(sera);
       
        
        try {
			socket = new Socket("localhost", 5555); // "localhost" ya da sunucu IP adresi
                        // input stream ve output stream yaratılıyor...
			 out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Sunucu bulunamadı");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("I/O exception:" + e.getMessage());
			System.exit(1);
		}
		System.out.println("Sunucuya baglanildi.");
              
        
       
       
       
        
        
     
           if(outputLine!=null){
           out.println(outputLine);
           }
      outputLine="Sıcaklık "+sorgu.sicaklikGetir(sera.getSera_adi())+" Derece";    
      
      
     
       in.close();
       out.close();
       socket.close();
       
      
       
    }

    @FXML
    private void sicaklikAzalt(ActionEvent event) {
        
    }
    
    
}
