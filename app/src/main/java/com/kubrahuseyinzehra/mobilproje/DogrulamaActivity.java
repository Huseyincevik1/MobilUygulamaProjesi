package com.kubrahuseyinzehra.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kubrahuseyinzehra.mobilproje.Models.DogrulamaPojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DogrulamaActivity extends AppCompatActivity {

    //BUTIN KISIMLARI BEN YAPTIM DOĞRU MU GÖSTER.
    private Button buttonR;
    private EditText mail;
    private EditText dogkod;
    String dogrulamakodu;
    String email;

    private RestApi restApi;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogrulama);
        buttonR = findViewById(R.id.buttonDogrula);
        mail = findViewById(R.id.editTextMailDogrulama);
        dogkod = findViewById(R.id.editTextDogkod);
        restApi = ApiUtils.getRestApiInterface();



        Bundle bundle = getIntent().getExtras();
        dogrulamakodu =String.valueOf(bundle.getInt("kod"));
        email = bundle.getString("email");
        Toast.makeText(getApplicationContext(),dogrulamakodu,Toast.LENGTH_LONG).show();

        mail.setText(email);

        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dogrula(email,dogrulamakodu);
            }
        });
    }


    public void dogrula (String ad, String kod){
        restApi.dogrulama(ad, kod).enqueue(new Callback<DogrulamaPojo>() {
                                               @Override
                                               public void onResponse(Call<DogrulamaPojo> call, Response<DogrulamaPojo> response) {
                                                   if(response.body().isTf()){
                                                       String uye_id = response.body().getId().toString();
                                                       String kullaniciadi = response.body().getKadi().toString();
                                                       Log.e("deneme","shared öncesi");
                                                       sharedPreferences = getApplicationContext().getSharedPreferences("giris",0);
                                                       SharedPreferences.Editor editor = sharedPreferences.edit();
                                                       editor.putString("uye_id",uye_id);
                                                       editor.putString("uye_KullaniciAdi",kullaniciadi);
                                                       editor.commit();
                                                       Log.e("deneme","shared sonrası");
                                                       Intent intent = new Intent(DogrulamaActivity.this,AnaSayfaFragment.class);
                                                       startActivity(intent);
                                                       Log.e("deneme","activity sonrası");
                                                   }else
                                                   {
                                                       Toast.makeText(getApplicationContext(),response.body().getResult(),Toast.LENGTH_LONG).show();
                                                   }
                                               }

                                               @Override
                                               public void onFailure(Call<DogrulamaPojo> call, Throwable t) {

                                               }
                                           }


        );
    }
}