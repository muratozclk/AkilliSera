/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;


import application.ActionBar;
import application.DrawerLayout;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.skins.JFXTextFieldSkin;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import java.awt.event.ActionListener;
import java.awt.im.spi.InputMethod;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Skin;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFrame;//pencere nesnesi oluşturabilmemiz için içe aktarmamız gereken sınıf
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author Halil
 */
public class FXMLDocumentController  implements Initializable {
    
    @FXML
    private JFXTextField yeni_ad;
    @FXML
    private PasswordField yeni_psw;
    @FXML
    private ComboBox<String> kul_ad;
    @FXML
    private PasswordField kul_psw;
    @FXML
    private JFXButton Kul_ac;
    private TextArea txt_are;
 
    public ObservableList<String> kullanici_liste=FXCollections.observableArrayList();
    
    public String[] dizi=new String[kullanici_liste.size()];
    @FXML
    private Button kul_kaydet;
    @FXML
    private JFXButton btnMenu;
   
    
    
    public Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      listeAyarla();
      
     
            MaterialIconView iconMenu = new MaterialIconView(MaterialIcon.ACCESS_TIME);
            iconMenu.getStyleClass().add("icon");
            iconMenu.setSize("34");
            Kul_ac.setGraphic(iconMenu);
            
            MaterialIconView iconMenu2 = new MaterialIconView(MaterialIcon.ACCOUNT_BALANCE_WALLET);
            iconMenu2.getStyleClass().add("icon"); 
            iconMenu2.setSize("34");
            kul_kaydet.setGraphic(iconMenu2);
            
          Kul_ac.setButtonType(JFXButton.ButtonType.FLAT);
      FontAwesomeIconView ıc=new FontAwesomeIconView(FontAwesomeIcon.SIGN_IN);
      ıc.getStyleClass().add("icon");
      ıc.setSize("34");
      
      Kul_ac.setGraphic(ıc);                 
    }    

    @FXML
    private void olustur(ActionEvent event) throws SQLException{
               
        Kullanıcı kullanici=new Kullanıcı(yeni_ad.getText(), yeni_psw.getText());
        KullanıcıSorgu kullaniciSorgu=new KullanıcıSorgu();       
        kullaniciSorgu.kullanici_kayit(kullanici);
        listeAyarla();
        if(kullaniciSorgu.kontrol==true){
             txt_are.setText("YENİ KULLANICI OLUŞTURULDU...");            
             yeni_ad.clear();
             yeni_psw.clear();          
       }
       else
              JOptionPane.showMessageDialog(null,"Giriş Yapılamadı.Hata Sebebi:"+kullaniciSorgu.mesaj,"HATA", JOptionPane.WARNING_MESSAGE);        
    }
    

    @FXML
    private void oturumac(ActionEvent event) throws IOException, Exception {
      
      Node node;
        
        Kullanıcı kul=new Kullanıcı(kul_ad.getValue(),kul_psw.getText());       
        
        KullanıcıSorgu kullaniciSorgu=new KullanıcıSorgu();
        
      if(kullaniciSorgu.parolaGetir(kul))
      {
          System.out.println("çalıştı");
           MA ma=new MA();
        Stage stage =new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        ma.basla(stage);                                                                 
      }
      else 
           JOptionPane.showMessageDialog(null,"Giriş Yapılamadı.Hata Sebebi:Geçersiz Kullanıcı Adı veya parola...","HATA", JOptionPane.WARNING_MESSAGE);                                        
    }              
    private void listeAyarla(){
        KullanıcıSorgu sorgu=new KullanıcıSorgu();
        kullanici_liste=sorgu.AdGetir();
        Collections.sort(kullanici_liste);
        kul_ad.setItems(kullanici_liste);
        
}            
}