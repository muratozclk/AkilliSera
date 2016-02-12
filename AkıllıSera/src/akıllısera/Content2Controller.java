package akıllısera;

import application.Card;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import akıllısera.Content1Controller.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.net.Socket;
import java.util.Collections;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by tareq on 7/13/15.
 */
public class Content2Controller implements Initializable {
    Card card;
    private Label lbl;
    @FXML
    private ComboBox<String> cmb_ssec;
    
    public ObservableList<String> seralar=FXCollections.observableArrayList();
  
    @FXML
    private Button btn_ayarla;
    @FXML
    private Button btn_havalandirma;
    @FXML
    private Button btn_su;
    @FXML
    private Button btn_baglan;
    @FXML
    private TextField txt_sicaklik;
    
   public  Sera sr;
    @FXML
    private Button btn_sera;
   
   

 
    
    
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SeraSorgu sorgu=new SeraSorgu();
     
            seralar=sorgu.seraAd();
            cmb_ssec.setItems(seralar);
          Collections.sort(seralar);
          
           btn_ayarla.setOnAction(buttonAyarlaEventHandler);
           btn_havalandirma.setOnAction(buttonHavalandirmaHandler);
           btn_su.setOnAction(buttonSuEventHandler);
            
        
    }

    private void arttir(ActionEvent event) throws SQLException, IOException{
         Sera sera=new Sera();
        SeraSorgu sorgu=new SeraSorgu();
        sera=sorgu.bilgileriGetir(cmb_ssec.getSelectionModel().getSelectedItem());
        sorgu.sicaklikArtir(sera);
       
        lbl.setText(sorgu.sicaklikGetir(sera.getSera_adi()));
       
       
        
      
        
    }

    private void sicaklikGetir(ActionEvent event) throws SQLException, IOException {
        
       SeraSorgu seraSorgu=new SeraSorgu();
        lbl.setText("Sıcaklık:"+seraSorgu.sicaklikGetir(cmb_ssec.getSelectionModel().getSelectedItem()));
        
       
        
       
    }

    @FXML
    private void ayarla(ActionEvent event) {
        
     
    }

    @FXML
    private void havac(ActionEvent event) {
    }

    @FXML
    private void suac(ActionEvent event) {
    }

    @FXML
    private void baglan(ActionEvent event) {
       String cmb;
       cmb=cmb_ssec.getSelectionModel().getSelectedItem();
        Sera sera=null;
        SeraSorgu sorgu=new SeraSorgu();
        txt_sicaklik.setText(sorgu.sicaklikGetir(cmb_ssec.getSelectionModel().getSelectedItem()));
        sr=sorgu.ipGetir(cmb);
    }
     EventHandler<ActionEvent> buttonAyarlaEventHandler= new EventHandler<ActionEvent>() {
            
            SeraSorgu sorgu=new SeraSorgu();
           
           
            

        @Override
        public void handle(ActionEvent event) {
            String tMsg = "Sıcaklık "+txt_sicaklik.getText()+"°C'ye ayarlanıyor...";
            if (tMsg.equals("")) {
                tMsg = null;
            }

            RunnableClient runnableClient
                = new RunnableClient(sr.getIP(), 
                    (sr.getPort()),
                    tMsg);
            
            new Thread(runnableClient).start();
        }
    };

    @FXML
    private void seraGetir(ActionEvent event) {
         SeraSorgu sorgu=new SeraSorgu();
     
            seralar=sorgu.seraAd();
            cmb_ssec.setItems(seralar);
          Collections.sort(seralar);
    }
     class RunnableClient implements Runnable{
        
        String dstAddress;
        int dstPort;
        String response = "";
        String msgToServer;
        
        public RunnableClient(String addr, int port, String msgTo) {
            dstAddress = addr;
            dstPort = port;
            msgToServer = msgTo;
        }

        @Override
        public void run() {
            Socket socket = null;
            DataOutputStream dataOutputStream = null;
            DataInputStream dataInputStream = null;

            try {
                socket = new Socket(dstAddress, dstPort);
                dataOutputStream = new DataOutputStream(
                    socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());
    
                if(msgToServer != null){
                    dataOutputStream.writeUTF(msgToServer);
                }
    
                response = dataInputStream.readUTF();
   

            } catch (IOException ex) { 
                Logger.getLogger(Content2Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                
                Platform.runLater(new Runnable(){

                    @Override
                    public void run() {
                        System.out.println(response);
                    }
                    
                });
                
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Content2Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Content2Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Content2Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }
        
    }
       
       EventHandler<ActionEvent> buttonHavalandirmaHandler= new EventHandler<ActionEvent>() {
            
        
         
              
         
           
           
            

        @Override
        public void handle(ActionEvent event) {
              String tMsg;
            if(btn_havalandirma.getText().equals("Havalandırmayı Aç")){
            tMsg = "Havalandırma Açılıyor...";
                btn_havalandirma.setText("Havalandırmayı Kapat");
            }
            else {
            
            tMsg="Havalandırma Kapatılıyor...";
             btn_havalandirma.setText("Havalandırmayı Aç");}
                
                      
            
            
           
            if (tMsg.equals("")) {
                tMsg = null;
            }

            RunnableClient runnableClient
                = new RunnableClient(sr.getIP(), 
                    (sr.getPort()),
                    tMsg);
            
            new Thread(runnableClient).start();
        }
    };
        EventHandler<ActionEvent> buttonSuEventHandler= new EventHandler<ActionEvent>() {
            
          
           
           
            

        @Override
        public void handle(ActionEvent event) {
            String tMsg;
            if(btn_su.getText().equals("Sulamayı Aç")){
                
                tMsg = "Sulama sistemi açılıyor...";
             btn_su.setText("Sulamayı Kapat");
            }
               
            else {
                tMsg = "Sulama sistemi Kapatılıyor...";
                btn_su.setText("Sulamayı Aç");
            }
               
            
            if (tMsg.equals("")) {
                tMsg = null;
            }

            RunnableClient runnableClient
                = new RunnableClient(sr.getIP(), 
                    (sr.getPort()),
                    tMsg);
            
            new Thread(runnableClient).start();
        }
    };

   
    
}
