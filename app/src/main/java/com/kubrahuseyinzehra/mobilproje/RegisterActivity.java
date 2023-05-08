package com.kubrahuseyinzehra.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kubrahuseyinzehra.mobilproje.Models.RegisterPojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {
    private Button buttonR;
    private EditText email;
    private EditText password;
    private RestApi restApi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonR = findViewById(R.id.buttonSignup);
        email = findViewById(R.id.editTextMailSignup);
        password = findViewById(R.id.editTextPasswordSignup);
        restApi = ApiUtils.getRestApiInterface();

        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                register(Email, Password);

            }
        });

    }


    public void register(String ad, String sifre) {
        restApi.kayitol(ad, sifre).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if(response.body() != null) {
                    String Email = email.getText().toString();
                    if (response.body().isTf()) {
                        Intent intent = new Intent(RegisterActivity.this, DogrulamaActivity.class);
                        intent.putExtra("email", Email);
                        intent.putExtra("kod", response.body().getDogrulamakodu());
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getResult(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {

            }
        });

    }
}