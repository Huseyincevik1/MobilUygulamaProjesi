package com.kubrahuseyinzehra.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kubrahuseyinzehra.mobilproje.DogrulamaFragmentDirections;
import com.kubrahuseyinzehra.mobilproje.Models.DogrulamaPojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogrulamaFragment extends Fragment {
    private Button buttonR;
    private EditText mail;
    private EditText dogkod;
    String dogrulamakodu;
    String email;

    private RestApi restApi;

    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_dogrulama, container, false);
        buttonR = tasarim.findViewById(R.id.buttonDogrula);
        mail = tasarim.findViewById(R.id.editTextMailDogrulama);
        dogkod = tasarim.findViewById(R.id.editTextDogkod);
        restApi = ApiUtils.getRestApiInterface();
        // Inflate the layout for this fragment

        DogrulamaFragmentArgs bundle = DogrulamaFragmentArgs.fromBundle(getArguments());
        dogrulamakodu = String.valueOf(bundle.getDogrulamakodu());
        email = bundle.getKullanciadi();
        Toast.makeText(requireContext(),dogrulamakodu,Toast.LENGTH_LONG).show();
      /*  Bundle bundle = getIntent().getExtras();
        dogrulamakodu =String.valueOf(bundle.getInt("kod"));
        email = bundle.getString("email");
        Toast.makeText(getApplicationContext(),dogrulamakodu,Toast.LENGTH_LONG).show();
*/
        mail.setText(email);

        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dogrula(email,String.valueOf(dogrulamakodu),v);

            }
        });
        return tasarim;
    }
    public void dogrula (String ad, String kod,View view){
        restApi.dogrulama(ad, kod).enqueue(new Callback<DogrulamaPojo>() {
       @Override
       public void onResponse(Call<DogrulamaPojo> call, Response<DogrulamaPojo> response) {
           if(response.body().isTf()){
               String uye_id = response.body().getId().toString();
               String kullaniciadi = response.body().getKadi().toString();
               Log.e("deneme","shared öncesi");
               sharedPreferences =requireContext().getSharedPreferences("giris",0);
               SharedPreferences.Editor editor = sharedPreferences.edit();
               editor.putString("uye_id",uye_id);
               editor.putString("uye_KullaniciAdi",kullaniciadi);
               editor.commit();
               Log.e("deneme","shared sonrası");
             //  Intent intent = new Intent(DogrulamaActivity.this,AnaSayfaFragment.class);
             //  startActivity(intent);
               DogrulamaFragmentDirections.Dogrulamaanagecis gecis = DogrulamaFragmentDirections.dogrulamaanagecis(response.body().getId().toString());
               Navigation.findNavController(view).navigate(gecis);//R.id.dogrulamaanagecis
               Log.e("deneme","activity sonrası");
           }else
           {
               Toast.makeText(requireContext(),response.body().getResult(),Toast.LENGTH_LONG).show();
           }
       }

       @Override
       public void onFailure(Call<DogrulamaPojo> call, Throwable t) {

       }
   }


        );
    }
}