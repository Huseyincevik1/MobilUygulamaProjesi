package com.kubrahuseyinzehra.mobilproje;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kubrahuseyinzehra.mobilproje.Models.RegisterPojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment {
    private Button buttonR;
    private EditText email;
    private EditText password;
    private RestApi restApi;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View tasarim= inflater.inflate(R.layout.fragment_register, container, false);
        buttonR = tasarim.findViewById(R.id.buttonSignup);
        email = tasarim.findViewById(R.id.editTextMailSignup);
        password = tasarim.findViewById(R.id.editTextPasswordSignup);
        restApi = ApiUtils.getRestApiInterface();
        // Inflate the layout for this fragment
        buttonR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                register(Email, Password,v);

            }
        });
        return tasarim;

    }
    public void register(String ad, String sifre,View view) {
        restApi.kayitol(ad, sifre).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if (response.body() != null) {
                    String Email = email.getText().toString();
                    if (response.body().isTf()) {
                      //  Intent intent = new Intent(RegisterActivity.this, DogrulamaActivity.class);
                        RegisterFragmentDirections.Signupdogrulamagecis gecis = RegisterFragmentDirections.signupdogrulamagecis();
                        gecis.setDogrulamakodu(response.body().getDogrulamakodu());
                        gecis.setKullanciadi(Email);
                        Navigation.findNavController(view).navigate(gecis);
                       /* intent.putExtra("email", Email);
                        intent.putExtra("kod", response.body().getDogrulamakodu());
                        startActivity(intent);*/
                    } else {
                        Toast.makeText(requireContext(), response.body().getResult(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {

            }
        });
    }
}