package com.kubrahuseyinzehra.mobilproje;

import android.annotation.SuppressLint;
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
import com.kubrahuseyinzehra.mobilproje.Models.IlanSonucPojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HousingInfoFragment extends Fragment {
    Spinner durumspinner, spinneresya;
    private AppCompatButton btnhi;
    private EditText brutm2, byas, bks, odas, bulunk,bans,isti,netm2,konsekli, kulldur,baslik,aciklama;
    public static String ilan_id;


    private RestApi restApi;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_housing_info, container, false);
        baslik = tasarim.findViewById(R.id.baslikinfo);
        aciklama = tasarim.findViewById(R.id.aciklamaaa);
        btnhi = tasarim.findViewById(R.id.buttonhouseinfogo);
        brutm2=tasarim.findViewById(R.id.editTextbrütm2Info);
        byas=tasarim.findViewById(R.id.editTextbinayasInfo);
        bks =tasarim.findViewById(R.id.editTextbinakatsayiInfo);
        odas =tasarim.findViewById(R.id.editTextodasayiInfo);
        bulunk =tasarim.findViewById(R.id.top_textbulundugukatView);
        bans =tasarim.findViewById(R.id.editTextbanyoInfo);
        isti =tasarim.findViewById(R.id.editTextisitma);
        netm2 =tasarim.findViewById(R.id.editTextnetm2);
        konsekli =tasarim.findViewById(R.id.editTextkonsek);
        kulldur =tasarim.findViewById(R.id.editTextkuldur);
        spinneresya=tasarim.findViewById(R.id.spinneresya);
        durumspinner = tasarim.findViewById(R.id.spinnerilandurumu);

        restApi= ApiUtils.getRestApiInterface();



        btnhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


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

                    HousingPojo.setAciklama(aciklama.getText().toString());
                    HousingPojo.setBaslik(baslik.getText().toString());

                    ilanKaydet();
                    Navigation.findNavController(view).navigate(R.id.hiden_extraya);
                }
                catch(Exception e) {Log.e("err","hata");
                    Toast.makeText(requireContext(),"Kayıt başarısız",Toast.LENGTH_LONG).show();
                }

                //  Log.e("deneme","buuton nav son onclick");

            }

        });
        return  tasarim;

    }
    public void ilanKaydet(){
        Log.e("3a","selam");
        restApi.ilanver(HousingPojo.getBaslik(),HousingPojo.getUye_id(),HousingPojo.getAciklama(),HousingPojo.getIl(),HousingPojo.getIlce(),HousingPojo.getMahalle(),HousingPojo.getIlan_durumu(),HousingPojo.getBrut_metrekare(),HousingPojo.getNet_metrekare(),HousingPojo.getBina_yasi(),HousingPojo.getBina_kat_sayisi(),HousingPojo.getOda_sayisi(),HousingPojo.getBulundugu_kat(),HousingPojo.getBanyo_sayisi(),HousingPojo.getIsitma_tipi(),HousingPojo.getSon_gun_tarihi(),HousingPojo.getKonut_sekli(),"esyasız",HousingPojo.getKullanim_durumu(),"Ön").enqueue(new Callback<IlanSonucPojo>() {
            @Override
            public void onResponse(Call<IlanSonucPojo> call, Response<IlanSonucPojo> response) {
                if(response.body().isTf()){

                    ilan_id = response.body().getId();

                }
                else{
                    Toast.makeText(requireContext(),"Kayıt başarısız",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<IlanSonucPojo> call, Throwable t) {

            }
        });
    }
}
