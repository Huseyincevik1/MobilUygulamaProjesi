package com.kubrahuseyinzehra.mobilproje;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.kubrahuseyinzehra.mobilproje.Models.IlanDetay;
import com.kubrahuseyinzehra.mobilproje.Models.IlanlarItem;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IlanDetayFragment extends Fragment {

    private TextView fiyat, baslik, ilandurum, brutm2, bks, odas, bulunk,bans,isti,netm2,konsekli, kulldur, songuntar,esyad, yapid,cep, il, ilce, mah;
    private RestApi restApi;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_ilan_detay, container, false);

        brutm2=tasarim.findViewById(R.id.textViewBrutM2);
      //  byas=tasarim.findViewById(R.id.textViewbanyosayi);
        bks =tasarim.findViewById(R.id.textViewBinaKatSayisi);
        odas =tasarim.findViewById(R.id.textViewOdaSayisi);
        bulunk =tasarim.findViewById(R.id.textViewBukunduguKat);
        bans =tasarim.findViewById(R.id.textViewBanyoSayisi);
        isti =tasarim.findViewById(R.id.textViewIsitmaTipi);
        netm2 =tasarim.findViewById(R.id.textViewNet2);
        konsekli =tasarim.findViewById(R.id.textViewKonutSekli);
        kulldur =tasarim.findViewById(R.id.textViewKullanimDurumu);
        songuntar=tasarim.findViewById(R.id.textViewSongunTarih);
        esyad=tasarim.findViewById(R.id.textViewEsyaDurumu);
        yapid=tasarim.findViewById(R.id.textViewYapiDurumu);
        cep=tasarim.findViewById(R.id.textviewCephe);
        il=tasarim.findViewById(R.id.textViewIl);
        ilce=tasarim.findViewById(R.id.textViewIlce);
        mah=tasarim.findViewById(R.id.textViewMahalle);
        fiyat=tasarim.findViewById(R.id.textViewFiyat);
        baslik=tasarim.findViewById(R.id.textViewBaslik);
        ilandurum=tasarim.findViewById(R.id.textviewilanDurum);
        restApi = ApiUtils.getRestApiInterface();
        IlanDetayFragmentArgs bundle = IlanDetayFragmentArgs.fromBundle(getArguments());
        String ilan_id = bundle.getIlanlaritem().getIlanid();
      Log.e("ilan_id",ilan_id);

             ilandetaylar(ilan_id);
        // Inflate the layout for this fragment
        return tasarim;
    }


    public void ilandetaylar(String ilanId){
       restApi.ilandetay(ilanId).enqueue(new Callback<IlanDetay>() {
           @Override
           public void onResponse(Call<IlanDetay> call, Response<IlanDetay> response) {
               Log.e("eee", response.body().getBrutM2());
               brutm2.setText(response.body().getBrutM2());
           }

           @Override
           public void onFailure(Call<IlanDetay> call, Throwable t) {

           }
       });
    }
}