/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

import application.ActionBar;
import application.Button;
import application.CheckBox;
import application.DrawerLayout;
import application.MaterialRootLayout;
import application.MaterialText;
import application.RadioButton;
import application.TabTitle;
import application.TextInput;
import application.ToggleButton;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Halil
 */
public class MA {
    
    public   void basla(Stage primaryStage) throws IOException{
    ActionBar actionBar = new ActionBar("Akıllı Sera");
        DrawerLayout drawerLayout = new DrawerLayout();
       
       
        drawerLayout.getChildren().add(FXMLLoader.load(getClass().getResource("DrawerLayout.fxml")));
        Color white = Color.WHITE;
        actionBar.addTab(new TabTitle(new MaterialText("Sera Düzenle", white)), FXMLLoader.load(getClass().getResource("Content1.fxml")));
        actionBar.addTab(new TabTitle(new MaterialText("Sera Bağlantı", white)), FXMLLoader.load(getClass().getResource("Content2.fxml")));
       actionBar.addTab(new TabTitle(new MaterialText("Geliştirenler", white)), FXMLLoader.load(getClass().getResource("Content3.fxml")));

       
        MaterialRootLayout root = new MaterialRootLayout(actionBar, drawerLayout);
        primaryStage.setTitle("AKILLI SERA");
        primaryStage.setScene(new Scene(root, 600, 650));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
    

