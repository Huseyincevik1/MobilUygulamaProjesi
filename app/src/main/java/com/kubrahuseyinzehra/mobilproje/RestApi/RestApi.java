package com.kubrahuseyinzehra.mobilproje.RestApi;

import com.kubrahuseyinzehra.mobilproje.Models.DogrulamaPojo;
import com.kubrahuseyinzehra.mobilproje.Models.FavKontrol;
import com.kubrahuseyinzehra.mobilproje.Models.IlanDetay;
import com.kubrahuseyinzehra.mobilproje.Models.IlanSonucPojo;
import com.kubrahuseyinzehra.mobilproje.Models.IlanlarItem;
import com.kubrahuseyinzehra.mobilproje.Models.IlanlarimPojo;
import com.kubrahuseyinzehra.mobilproje.Models.LoginPojo;
import com.kubrahuseyinzehra.mobilproje.Models.RegisterPojo;
import com.kubrahuseyinzehra.mobilproje.Models.ResimEklePojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {

    @POST("login.php")
    @FormUrlEncoded
    Call<LoginPojo> control(@Field("ad") String ad, @Field("sifre") String sifre);

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterPojo> kayitol(@Field("kadi") String ad, @Field("sifre")String sifre);


    @FormUrlEncoded
    @POST("dogrulama.php")
    Call<DogrulamaPojo> dogrulama(@Field("kadi") String ad, @Field("kod")String kod);

    @POST("ilanlar.php")
    @FormUrlEncoded
    Call<IlanSonucPojo> control2(@Field("baslik") String baslik, @Field("uye_id") String uye_id, @Field("aciklama") String aciklama, @Field("il") String il, @Field("ilce") String ilce, @Field("mahalle") String mahalle, @Field("ilan_durumu") String ilan_durumu, @Field("brut_metrekare") String brut_metrekare, @Field("net_metrekare") String net_metrekare, @Field("bina_yasi") String bina_yasi, @Field("bina_kat_sayisi") String bina_kat_sayisi , @Field("oda_sayisi") String oda_sayisi, @Field("bulundugu_kat") String bulundugu_kat, @Field("banyo_sayisi") String banyo_sayisi , @Field("isitma_tipi") String isitma_tipi , @Field("son_gun_tarihi") String  son_gun_tarihi, @Field("konut_sekli") String konut_sekli , @Field("esya_durumu ") String esya_durumu  , @Field(" kullanım_durumu") String  kullanım_durumu , @Field("cephe") String cephe  ) ;
    @GET("/favori.php")
    Call<FavKontrol> getButonText(@Query("uye_id") String uye_id, @Query("ilan_id") String ilan_id);
   /* @GET("/favislem.php")
    Call<FavIslem> favIslem(@Query("uye_id") String uye_id, @Query("ilan_id") String ilan_id);*/


    @GET("ilanlarim.php")
    Call<IlanlarimPojo>ilanlarim(@Query("uyeid") String uyeid);

    @GET("tumilanlar.php")
    Call<IlanlarimPojo>tumilanlar();

    @POST("ilanresimler.php")
    @FormUrlEncoded
    Call<ResimEklePojo> resimyukle(@Field("uye_id") String uye_id, @Field("ilan_id") String ilan_id, @Field("resim") String base64StringResim);

    @GET("ilandetay.php")
    Call<IlanDetay>ilandetay(@Query("ilan_id") String ilan_id);
}
