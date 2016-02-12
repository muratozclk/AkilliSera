/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

import application.ActionBar;
import application.DrawerLayout;
import com.sun.glass.ui.Window;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.AWTEventMulticaster;
import static java.awt.event.WindowEvent.WINDOW_CLOSED;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.event.EventDispatchChain;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import static javafx.stage.WindowEvent.WINDOW_HIDDEN;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

/**
 *
 * @author Halil
 */

public class AkıllıSera extends Application{            
    @Override
    public void start(Stage stage) throws Exception {       
              Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumen.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Akıllı Sera");
       stage.setResizable(false);
        stage.show();
        
        stage.setOnCloseRequest( e ->closeProgram());       
    }
    public   void closeProgram(){
        int yes =JOptionPane.showConfirmDialog(null,"Kapatmak İstiyor musunuz?","Çıkış", JOptionPane.ERROR_MESSAGE);
  
    if(yes==JOptionPane.YES_OPTION)
        System.exit(0);
    else if(yes==JOptionPane.NO_OPTION)
        return;    
    }
   
    public static void main(String[] args) {
        launch(args);
        
    }
}