package com.kubrahuseyinzehra.mobilproje.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPojo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kadi")
    @Expose
    private String kadi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

}