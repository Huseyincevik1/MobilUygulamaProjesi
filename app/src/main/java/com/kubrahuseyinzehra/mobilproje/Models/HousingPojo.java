package com.kubrahuseyinzehra.mobilproje.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HousingPojo
{

    static String baslik ;
    static String  uye_id ;
//resim = $_POST['id'];
    static String aciklama ;
    static String  il ;
    static String ilce ;
    static String mahalle;
    static String ilan_durumu;
    static String  brut_metrekare;
    static String  net_metrekare ;
    static String bina_yasi;
    static String bina_kat_sayisi;
    static String  oda_sayisi ;
    static String  bulundugu_kat;
    static String banyo_sayisi ;
    static String isitma_tipi;
    static String  son_gun_tarihi;
    static String konut_sekli;

    static String  esya_durumu ;

    static String yapi_durumu;
    static String kullanim_durumu;

    static String  cephe ;

    public static String getUye_id() {
        return uye_id;
    }

    public static void setUye_id(String uye_id) {
        HousingPojo.uye_id = uye_id;
    }

    public static String getBaslik() {
        return baslik;
    }

    public static void setBaslik(String baslik) {
        HousingPojo.baslik = baslik;
    }

    public static String getAciklama() {
        return aciklama;
    }

    public static void setAciklama(String aciklama) {
        HousingPojo.aciklama = aciklama;
    }

    public static String getIl() {
        return il;
    }

    public static void setIl(String il) {
        HousingPojo.il = il;
    }

    public static String getIlce() {
        return ilce;
    }

    public static void setIlce(String ilce) {
        HousingPojo.ilce = ilce;
    }

    public static String getMahalle() {
        return mahalle;
    }

    public static void setMahalle(String mahalle) {
        HousingPojo.mahalle = mahalle;
    }

    public static String getIlan_durumu() {
        return ilan_durumu;
    }

    public static void setIlan_durumu(String ilan_durumu) {
        HousingPojo.ilan_durumu = ilan_durumu;
    }

    public static String getBrut_metrekare() {
        return brut_metrekare;
    }

    public static void setBrut_metrekare(String brut_metrekare) {
        HousingPojo.brut_metrekare = brut_metrekare;
    }

    public static String getNet_metrekare() {
        return net_metrekare;
    }

    public static void setNet_metrekare(String net_metrekare) {
        HousingPojo.net_metrekare = net_metrekare;
    }

    public static String getBina_yasi() {
        return bina_yasi;
    }

    public static void setBina_yasi(String bina_yasi) {
        HousingPojo.bina_yasi = bina_yasi;
    }

    public static String getKullanim_durumu() {
        return kullanim_durumu;
    }

    public static void setKullanim_durumu(String kullanim_durumu) {
        HousingPojo.kullanim_durumu = kullanim_durumu;
    }

    public static String getBina_kat_sayisi() {
        return bina_kat_sayisi;
    }

    public static void setBina_kat_sayisi(String bina_kat_sayisi) {
        HousingPojo.bina_kat_sayisi = bina_kat_sayisi;
    }

    public static String getOda_sayisi() {
        return oda_sayisi;
    }

    public static void setOda_sayisi(String oda_sayisi) {
        HousingPojo.oda_sayisi = oda_sayisi;
    }

    public static String getBulundugu_kat() {
        return bulundugu_kat;
    }

    public static void setBulundugu_kat(String bulundugu_kat) {
        HousingPojo.bulundugu_kat = bulundugu_kat;
    }

    public static String getBanyo_sayisi() {
        return banyo_sayisi;
    }

    public static void setBanyo_sayisi(String banyo_sayisi) {
        HousingPojo.banyo_sayisi = banyo_sayisi;
    }

    public static String getIsitma_tipi() {
        return isitma_tipi;
    }

    public static void setIsitma_tipi(String isitma_tipi) {
        HousingPojo.isitma_tipi = isitma_tipi;
    }

    public static String getSon_gun_tarihi() {
        return son_gun_tarihi;
    }

    public static void setSon_gun_tarihi(String son_gun_tarihi) {
        HousingPojo.son_gun_tarihi = son_gun_tarihi;
    }

    public static String getKonut_sekli() {
        return konut_sekli;
    }

    public static void setKonut_sekli(String konut_sekli) {
        HousingPojo.konut_sekli = konut_sekli;
    }

}
