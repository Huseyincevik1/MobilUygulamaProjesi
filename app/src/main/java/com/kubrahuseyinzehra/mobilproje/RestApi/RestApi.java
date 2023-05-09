package com.kubrahuseyinzehra.mobilproje.RestApi;

import com.kubrahuseyinzehra.mobilproje.Models.DogrulamaPojo;
import com.kubrahuseyinzehra.mobilproje.Models.LoginPojo;
import com.kubrahuseyinzehra.mobilproje.Models.RegisterPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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

}
