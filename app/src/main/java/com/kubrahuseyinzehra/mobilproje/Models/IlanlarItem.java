package com.kubrahuseyinzehra.mobilproje.Models;

public class IlanlarItem{
	private String banyoSayisi;
	private String il;
	private String odaSayisi;
	private String uyeId;
	private String fiyat;
	private String brutM2;
	private String isitmaTipi;
	private String cephe;
	private String binaKatSayisi;
	private String bulunduguKat;
	private String kullanimDurumu;
	private String ilanId;
	private String yapiDurum;
	private String resim;
	private String aciklama;
	private String konutSekli;
	private String ilce;
	private String mah;
	private String binaYasi;
	private String ilanDurum;
	private String esyaDurumu;
	private String baslik;
	private String netM2;
	private String sonGuncellenmeTarihi;

	public void setBanyoSayisi(String banyoSayisi){
		this.banyoSayisi = banyoSayisi;
	}

	public String getBanyoSayisi(){
		return banyoSayisi;
	}

	public void setIl(String il){
		this.il = il;
	}

	public String getIl(){
		return il;
	}

	public void setOdaSayisi(String odaSayisi){
		this.odaSayisi = odaSayisi;
	}

	public String getOdaSayisi(){
		return odaSayisi;
	}

	public void setUyeId(String uyeId){
		this.uyeId = uyeId;
	}

	public String getUyeId(){
		return uyeId;
	}

	public void setFiyat(String fiyat){
		this.fiyat = fiyat;
	}

	public String getFiyat(){
		return fiyat;
	}

	public void setBrutM2(String brutM2){
		this.brutM2 = brutM2;
	}

	public String getBrutM2(){
		return brutM2;
	}

	public void setIsitmaTipi(String isitmaTipi){
		this.isitmaTipi = isitmaTipi;
	}

	public String getIsitmaTipi(){
		return isitmaTipi;
	}

	public void setCephe(String cephe){
		this.cephe = cephe;
	}

	public String getCephe(){
		return cephe;
	}

	public void setBinaKatSayisi(String binaKatSayisi){
		this.binaKatSayisi = binaKatSayisi;
	}

	public String getBinaKatSayisi(){
		return binaKatSayisi;
	}

	public void setBulunduguKat(String bulunduguKat){
		this.bulunduguKat = bulunduguKat;
	}

	public String getBulunduguKat(){
		return bulunduguKat;
	}

	public void setKullanimDurumu(String kullanimDurumu){
		this.kullanimDurumu = kullanimDurumu;
	}

	public String getKullanimDurumu(){
		return kullanimDurumu;
	}

	public void setIlanId(String ilanId){
		this.ilanId = ilanId;
	}

	public String getIlanId(){
		return ilanId;
	}

	public void setYapiDurum(String yapiDurum){
		this.yapiDurum = yapiDurum;
	}

	public String getYapiDurum(){
		return yapiDurum;
	}

	public void setResim(String resim){
		this.resim = resim;
	}

	public String getResim(){
		return resim;
	}

	public void setAciklama(String aciklama){
		this.aciklama = aciklama;
	}

	public String getAciklama(){
		return aciklama;
	}

	public void setKonutSekli(String konutSekli){
		this.konutSekli = konutSekli;
	}

	public String getKonutSekli(){
		return konutSekli;
	}

	public void setIlce(String ilce){
		this.ilce = ilce;
	}

	public String getIlce(){
		return ilce;
	}

	public void setMah(String mah){
		this.mah = mah;
	}

	public String getMah(){
		return mah;
	}

	public void setBinaYasi(String binaYasi){
		this.binaYasi = binaYasi;
	}

	public String getBinaYasi(){
		return binaYasi;
	}

	public void setIlanDurum(String ilanDurum){
		this.ilanDurum = ilanDurum;
	}

	public String getIlanDurum(){
		return ilanDurum;
	}

	public void setEsyaDurumu(String esyaDurumu){
		this.esyaDurumu = esyaDurumu;
	}

	public String getEsyaDurumu(){
		return esyaDurumu;
	}

	public void setBaslik(String baslik){
		this.baslik = baslik;
	}

	public String getBaslik(){
		return baslik;
	}

	public void setNetM2(String netM2){
		this.netM2 = netM2;
	}

	public String getNetM2(){
		return netM2;
	}

	public void setSonGuncellenmeTarihi(String sonGuncellenmeTarihi){
		this.sonGuncellenmeTarihi = sonGuncellenmeTarihi;
	}

	public String getSonGuncellenmeTarihi(){
		return sonGuncellenmeTarihi;
	}

	@Override
	public String toString(){
		return
				"IlanDetayPoJo{" +
						"banyo_sayisi = '" + banyoSayisi + '\'' +
						",il = '" + il + '\'' +
						",oda_sayisi = '" + odaSayisi + '\'' +
						",uye_id = '" + uyeId + '\'' +
						",fiyat = '" + fiyat + '\'' +
						",brut_m2 = '" + brutM2 + '\'' +
						",isitma_tipi = '" + isitmaTipi + '\'' +
						",cephe = '" + cephe + '\'' +
						",bina_kat_sayisi = '" + binaKatSayisi + '\'' +
						",bulundugu_kat = '" + bulunduguKat + '\'' +
						",kullanim_durumu = '" + kullanimDurumu + '\'' +
						",ilan_id = '" + ilanId + '\'' +
						",yapi_durum = '" + yapiDurum + '\'' +
						",resim = '" + resim + '\'' +
						",aciklama = '" + aciklama + '\'' +
						",konut_sekli = '" + konutSekli + '\'' +
						",ilce = '" + ilce + '\'' +
						",mah = '" + mah + '\'' +
						",bina_yasi = '" + binaYasi + '\'' +
						",ilan_durum = '" + ilanDurum + '\'' +
						",esya_durumu = '" + esyaDurumu + '\'' +
						",baslik = '" + baslik + '\'' +
						",net_m2 = '" + netM2 + '\'' +
						",son_guncellenme_tarihi = '" + sonGuncellenmeTarihi + '\'' +
						"}";
	}
}
