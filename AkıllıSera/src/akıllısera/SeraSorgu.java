/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Halil
 */
public class SeraSorgu extends Baglanti {
    
    public String mesaj;
    
    public void seraKaydet(Sera sera)throws SQLException{
        baglan();
        try {
            
            
            PreparedStatement kaydet=baglanti.prepareStatement("insert into sera values"+"(?,?,?,?,?,?,?)");
            kaydet.setString(3, sera.getSera_adi());
            kaydet.setString(4, sera.getSera_adres());
            kaydet.setString(2, sera.getIP());
            kaydet.setInt(1, sera.getPort());
            kaydet.setString(5, sera.getUrun_cinsi());
            kaydet.setInt(6, sera.getSicaklik());
            kaydet.setInt(7, sera.getNem());
            kaydet.executeUpdate();
            kaydet.close();
            
            
            
        } catch (Exception e) {
            mesaj=e.getMessage();
            System.out.println(mesaj);
            
        }
        finally{
        baglantiKes();
        }
    
    
    }
    public ObservableList<String> seraAd(){
    ObservableList<String> sonuc=FXCollections.observableArrayList();
    baglan();
        try {
            
            PreparedStatement adGetir=baglanti.prepareStatement("select sera_ad from sera");
            ResultSet rs=adGetir.executeQuery();
            while (rs.next()) {                
                sonuc.add(rs.getString("sera_ad"));
            }
            
        } catch (Exception e) {
            mesaj=e.getMessage();
            System.out.println(mesaj);
            
        }
    
        return sonuc;
        
    }
    
    public Sera bilgileriGetir(String gelen) throws SQLException{
    Sera sera=new Sera();
    
        try {
            baglan();
            PreparedStatement getir=baglanti.prepareStatement("select * from sera where sera_ad=?");
            getir.setString(1,gelen);
            ResultSet rs=getir.executeQuery();
            while (rs.next()) {                
              sera.ekle(rs.getInt("port"), rs.getString("IP"), rs.getString("sera_ad"), rs.getString("sera_adres"), rs.getString("urun_cinsi"), rs.getInt("sera_sicaklik"), rs.getInt("sera_nem"));
            }
               
            }
            
            
         catch (Exception e) {
            mesaj=e.getMessage();
            System.out.println("Düzenle hatas:"+mesaj);
        }
        finally{
    baglantiKes();
    }

   
    
    
    
    return sera;
    }
    public void seraDegistir(Sera sera){
        try{
            baglan();
            PreparedStatement guncelle=baglanti.prepareStatement("update sera set"
                    + " port=?, IP=?, sera_adres=?,urun_cinsi=?,sera_sicaklik=?,sera_nem=? where sera_Ad=?");
            guncelle.setInt(1, sera.getPort());
            guncelle.setString(2, sera.getIP());
            
            guncelle.setString(3, sera.getSera_adres());
            guncelle.setString(4, sera.getUrun_cinsi());
            guncelle.setInt(5, sera.getSicaklik());
            guncelle.setInt(6, sera.getNem());
            guncelle.setString(7, sera.getSera_adi());
            guncelle.executeUpdate();
            guncelle.close();
        }
        catch(Exception e){
            mesaj=e.getMessage();
            System.out.println(e.getMessage());
        }
        finally{
            baglantiKes();
        }
    }
    public String sicaklikGetir(String ad){
    String sicaklik = null;
    
        try {
            baglan();
            
            PreparedStatement getir=baglanti.prepareStatement("select sera_sicaklik from sera where sera_Ad=?");
            getir.setString(1, ad);
           
            ResultSet rs=getir.executeQuery();
            
            while (rs.next()) {                
                sicaklik=rs.getString("sera_sicaklik");
            }
            
        } catch (Exception e) {
            mesaj=e.getMessage();
            System.out.println(e.getMessage());
        }
        finally{
        baglantiKes();
        }
    
    
    return sicaklik;
    }
    public void sicaklikArtir(Sera sera){
        int sayi=sera.getSicaklik()+1;
        try {
            baglan();
            PreparedStatement arttir=baglanti.prepareStatement("update sera set" +" sera_sicaklik=? where sera_ad=?");
            arttir.setInt(1, sayi);
            arttir.setString(2, sera.getSera_adi());
            arttir.executeUpdate();
            baglanti.close();
            arttir.close();
            
        } catch (Exception e) {
            mesaj=e.getMessage();
            System.out.println(mesaj);
        }
        finally{
        baglantiKes();
        }
    }
    public Sera ipGetir(String gelen){
        Sera sera = null;
        String ip;
        int port;
        
        try {
            
            baglan();
            PreparedStatement getir=baglanti.prepareStatement("Select IP,port from sera where sera_ad=?");
            getir.setString(1, gelen);
            ResultSet rs=getir.executeQuery();
            while (rs.next()) {
                ip=rs.getString("IP");
                port=rs.getInt("port");
                sera=new Sera(ip, port);
                
                
                
            }
            
        } catch (Exception e) {
            System.out.println("Hata Sebebi:"+e.getMessage());
        }
        finally{
        baglantiKes();
        }
    
    
    
    
    return sera;
    }
    }

    

    
    
    

