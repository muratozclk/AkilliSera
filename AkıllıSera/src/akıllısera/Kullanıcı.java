/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akıllısera;

/**
 *
 * @author Halil
 */
public class Kullanıcı {
    
    private String kullanici_ad;
    private String kullanici_psw;
    
    
    public Kullanıcı(String ad,String psw){
        this.kullanici_ad=ad;
        this.kullanici_psw=psw;
    }

    /**
     * @return the kullanici_ad
     */
    public String getKullanici_ad() {
        return kullanici_ad;
    }

    /**
     * @param kullanici_ad the kullanici_ad to set
     */
    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    /**
     * @return the kullanici_psw
     */
    public String getKullanici_psw() {
        return kullanici_psw;
    }

    /**
     * @param kullanici_psw the kullanici_psw to set
     */
    public void setKullanici_psw(String kullanici_psw) {
        this.kullanici_psw = kullanici_psw;
    }
    
   
    public Kullanıcı (String ad){
        this.kullanici_ad=ad;
    }
    
   
     public void toString(String ad,String parola){
         System.out.println("ad:"+ad+" Parola:"+parola);
     
     }
    }
   
    

