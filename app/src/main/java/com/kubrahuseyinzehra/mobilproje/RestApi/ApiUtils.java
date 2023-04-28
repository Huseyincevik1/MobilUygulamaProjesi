package com.kubrahuseyinzehra.mobilproje.RestApi;

import com.kubrahuseyinzehra.mobilproje.Models.LoginPojo;

import retrofit2.Call;

public class ApiUtils {
 private static ApiUtils ourInstance = new ApiUtils();

    public static final String BASE_URL = "https://kortizol.net/";

    public static RestApi getRestApiInterface(){
        return RetrofitClient.getClient(BASE_URL).create(RestApi.class);
    }
}
