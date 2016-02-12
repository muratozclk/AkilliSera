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
public class Sera {
    
    private String sera_adi;
    private  String sera_adres;
    private int port;
    private String IP;
    private String urun_cinsi;
    private int sicaklik;
    private int nem;

    /**
     * @return the sera_adi
     */
    public Sera (String ad,String adres,String ip,int port,String cinsi,int sicaklik,int nem){
        this.sera_adi=ad;
        this.sera_adres=adres;
        this.IP=ip;
        this.port=port;
        this.urun_cinsi=cinsi;
        this.sicaklik=sicaklik;
        this.nem=nem;
        
        
    }
    public Sera (){
    
    }
    public Sera (String ip,int port){
    this.IP=ip;
    this.port=port;
    
    }
   public void ekle(int port,String ip,String ad,String adres,String cinsi,int sicaklik,int nem){
    this.IP=ip;
    this.port=port;
    this.sera_adi=ad;
    this.sera_adres=adres;
    this.urun_cinsi=cinsi;
    this.sicaklik=sicaklik;
    this.nem=nem;
    
    }

    public String getSera_adi() {
        return sera_adi;
    }

    /**
     * @param sera_adi the sera_adi to set
     */
    public void setSera_adi(String sera_adi) {
        this.sera_adi = sera_adi;
    }

    /**
     * @return the sera_adres
     */
    public String getSera_adres() {
        return sera_adres;
    }

    /**
     * @param sera_adres the sera_adres to set
     */
    public void setSera_adres(String sera_adres) {
        this.sera_adres = sera_adres;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the IP
     */
    public String getIP() {
        return IP;
    }

    /**
     * @param IP the IP to set
     */
    public void setIP(String IP) {
        this.IP = IP;
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
    
    
    public Sera(String ad,String adres,String urun,int sicaklik,int nem){
        this.sera_adi=ad;
        this.sera_adres=adres;
        this.sicaklik=sicaklik;
        this.nem=nem;
        this.urun_cinsi=urun;      
    }
    
}
