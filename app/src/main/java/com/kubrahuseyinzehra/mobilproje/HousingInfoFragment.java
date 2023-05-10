package com.kubrahuseyinzehra.mobilproje;

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
import android.widget.Spinner;
import android.widget.Toast;

import com.kubrahuseyinzehra.mobilproje.Models.HousingPojo;
import com.kubrahuseyinzehra.mobilproje.Models.LoginPojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HousingInfoFragment extends Fragment {
    Spinner durumspinner, spinneresya;
    private AppCompatButton btnhi;
    private EditText brutm2, byas, bks, odas, bulunk,bans,isti,netm2,konsekli, kulldur;


    private RestApi restApi;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_housing_info, container, false);
       btnhi = tasarim.findViewById(R.id.buttonhouseinfogo);
        brutm2=tasarim.findViewById(R.id.editTextbrütm2Info);
        byas=tasarim.findViewById(R.id.editTextbinayasInfo);
        bks =tasarim.findViewById(R.id.editTextbinakatsayiInfo);
        odas =tasarim.findViewById(R.id.editTextodasayiInfo);
        bulunk =tasarim.findViewById(R.id.editTextbulundugukatInfo);
        bans =tasarim.findViewById(R.id.editTextbanyoInfo);
        isti =tasarim.findViewById(R.id.editTextisitma);
        netm2 =tasarim.findViewById(R.id.editTextnetm2);
        konsekli =tasarim.findViewById(R.id.editTextkonsek);
        kulldur =tasarim.findViewById(R.id.editTextkuldur);
        spinneresya=tasarim.findViewById(R.id.spinneresya);
        durumspinner = tasarim.findViewById(R.id.spinnerilandurumu);



        btnhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                Log.i("try",brutm2.getText().toString());
                Log.i("try",byas.getText().toString());
                Log.i("try",bks.getText().toString());
                Log.i("try",odas.getText().toString());
                Log.i("try",bulunk.getText().toString());
                Log.i("try",bans.getText().toString());
                Log.i("try",isti.getText().toString());
                Log.i("try",netm2.getText().toString());
                Log.i("try",konsekli.getText().toString());
                Log.i("try",kulldur.getText().toString());
                Log.i("try",spinneresya.getSelectedItem().toString());
                Log.i("try",durumspinner.getSelectedItem().toString());
                HousingPojo.setBrut_metrekare(brutm2.getText().toString());
                HousingPojo.setBina_yasi(byas.getText().toString());
                HousingPojo.setBina_kat_sayisi(bks.getText().toString());
                HousingPojo.setOda_sayisi(odas.getText().toString());
                HousingPojo.setBulundugu_kat(bulunk.getText().toString());
                HousingPojo.setBanyo_sayisi(bans.getText().toString());
                HousingPojo.setIsitma_tipi(isti.getText().toString());
                HousingPojo.setNet_metrekare(netm2.getText().toString());
                HousingPojo.setKonut_sekli(konsekli.getText().toString());
                HousingPojo.setKullanim_durumu(kulldur.getText().toString());
                HousingPojo.setKullanim_durumu(spinneresya.getSelectedItem().toString());
                HousingPojo.setKullanim_durumu(durumspinner.getSelectedItem().toString());}
                catch(Exception e) {Log.e("err","hata");
                }
                    Navigation.findNavController(view).navigate(R.id.hiden_extraya);
                    //  Log.e("deneme","buuton nav son onclick");

            }
        });
        return  tasarim;


    }
}
