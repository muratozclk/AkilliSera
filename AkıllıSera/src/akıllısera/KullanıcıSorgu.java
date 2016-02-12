/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.security.rsa.RSACore;

/**
 *
 * @author Halil
 */
public class KullanıcıSorgu extends Baglanti{
        public boolean kontrol;
        public String mesaj;
     public void kullanici_kayit(Kullanıcı kul){
        
        try {
            kontrol=true;
            baglan();
  PreparedStatement kaydet=baglanti.prepareStatement("insert into kullanici values"+"(?,?)");
      kaydet.setString(1, kul.getKullanici_ad());
      kaydet.setString(2, kul.getKullanici_psw());
      kaydet.executeUpdate();
      kaydet.close();
      
          
        } catch (Exception e) {
            kontrol=false;
            mesaj=e.getMessage();
            System.out.println(e.getMessage());
             System.out.println("SQL syntax hatası..Kullancı kaydedilemedii");
             
        }
        finally{
            baglantiKes();
        
        }                
    }
     
     public ObservableList<String> AdGetir(){
         ObservableList<String> sonuc=FXCollections.observableArrayList();
         
         try {
             baglan();
             PreparedStatement getir=baglanti.prepareStatement("select ad from kullanici");
             ResultSet rs=getir.executeQuery();
                while (rs.next()) {
                    
                  
                     
                     sonuc.add(rs.getString("ad"));
                     
                 
             }
                getir.close();
                rs.close();
                baglanti.close();
             
         } catch (Exception e) {
         }
     
        
            return sonuc;
     }
     public boolean parolaGetir(Kullanıcı kul) throws SQLException{
           baglan();
         PreparedStatement getir=baglanti.prepareStatement("select * from kullanici where ad=? and parola=?");
         ResultSet rs = null;
         try {
           
           
           getir.setString(1, kul.getKullanici_ad());
           getir.setString(2, kul.getKullanici_psw());
            
             rs=getir.executeQuery();
            
           if(rs.next())
               return true;
           else 
               return false;                                                                                 
         } catch (Exception e) {
             mesaj=e.getMessage();
             return false ;
         }
             finally{
             baglanti.close();
         getir.close();
         rs.close();
         }
         }
        
         
     
     
    
}
