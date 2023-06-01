package com.kubrahuseyinzehra.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.kubrahuseyinzehra.mobilproje.LoginFragmentDirections;
import com.kubrahuseyinzehra.mobilproje.Models.LoginPojo;
import com.kubrahuseyinzehra.mobilproje.RegisterFragmentDirections;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {

    private AppCompatButton buttonLogin;

    private AppCompatButton buttonRegister;
    private EditText editTextMailLogin;
    private EditText editTextPasswordLogin;
    SharedPreferences sharedPreferences;
    private RestApi restApi;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_login, container, false);
        buttonLogin = tasarim.findViewById(R.id.buttonLogin);
        editTextMailLogin=tasarim.findViewById(R.id.editTextMailLogin);
        editTextPasswordLogin=tasarim.findViewById(R.id.editTextPasswordLogin);
        buttonRegister = tasarim.findViewById(R.id.buttonRegister);
        restApi = ApiUtils.getRestApiInterface();
         buttonLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String ad = editTextMailLogin.getText().toString();
                 String sifre = editTextPasswordLogin.getText().toString();

                 login(ad,sifre,view);

             }

         });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.loginsignupgecis);
            }
        });
        return tasarim;
    }
    public void login (String ad, String sifre,View view){
       restApi.control(ad,sifre).enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
                if(response.body() != null) {
                    if(response.body().getId() != null && response.body().getKadi() !=null) {
                        sharedPreferences = getContext().getSharedPreferences("giris",0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("uye_id",response.body().getId());
                        editor.putString("kullaniciadi",response.body().getKadi());
                        editor.commit();

                        Log.e("*******", "*******");
                        Log.e("kişi id", response.body().getId());
                        Log.e("kişi ad", response.body().getKadi());
                        Log.e("*******", "*******");
                        LoginFragmentDirections.LogindenAnasyfayaGecis gecis = LoginFragmentDirections.logindenAnasyfayaGecis(response.body().getId());
                        Navigation.findNavController(view).navigate(gecis);
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

            }
        });
    }

}
