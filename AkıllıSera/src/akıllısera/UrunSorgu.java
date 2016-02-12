/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;


import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetRow;
import java.sql.ResultSet;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Halil
 */
public class UrunSorgu extends Baglanti{
   
    
    
    public ObservableList<String>urunGetir(){
    ObservableList<String> sonuc=FXCollections.observableArrayList();
         
        try {
            baglan();
           PreparedStatement getir=(PreparedStatement) baglanti.prepareStatement("select urun_cinsi from uruntablosu");
          
            ResultSet rs= getir.executeQuery();
            
            while(rs.next()){
                
               sonuc.add(rs.getString("urun_cinsi"));
               
                
            
            }
            baglanti.close();
            rs.close();
            getir.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sonuc;
    
    
    
    }

  
    
}
