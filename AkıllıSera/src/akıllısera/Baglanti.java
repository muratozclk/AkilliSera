/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Halil
 */
public class Baglanti {
    
    protected static final String SERVER="jdbc:mysql://localhost:3306/sera";
    protected static final String KULLANICIADI="root";
    protected static final String SIFRE="12345";
    protected Connection baglanti=null;
    
    protected void baglan(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            baglanti=(Connection) DriverManager.getConnection(SERVER,KULLANICIADI,SIFRE);//veri tabanına bağlandık.
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    protected void baglantiKes(){
       
        try {
             baglanti.close();//bağlantıyı kapatır.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
