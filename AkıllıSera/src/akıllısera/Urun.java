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
public class Urun {
    
    private String urun_cinsi;
    private int sicaklik;
    private int nem;
    
    public Urun(String urun_ad,int sicaklik,int nem){
        this.nem=nem;
        this.sicaklik=sicaklik;
        this.urun_cinsi=urun_ad;
        
        
    }
    public Urun(String ad){
    this.urun_cinsi=ad;
    
    }

    /**
     * @return the urun_cinsi
     */
    public String getUrun_cinsi() {
        return urun_cinsi;
    }

    /**
     * @param urun_cinsi the urun_cinsi to set
     */
    public void setUrun_cinsi(String urun_cinsi) {
        this.urun_cinsi = urun_cinsi;
    }

    /**
     * @return the sicaklik
     */
    public int getSicaklik() {
        return sicaklik;
    }

    /**
     * @param sicaklik the sicaklik to set
     */
    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
    }

    /**
     * @return the nem
     */
    public int getNem() {
        return nem;
    }

    /**
     * @param nem the nem to set
     */
    public void setNem(int nem) {
        this.nem = nem;
    }
    
    
    
}
