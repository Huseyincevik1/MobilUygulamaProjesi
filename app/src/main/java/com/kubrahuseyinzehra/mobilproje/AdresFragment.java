package com.kubrahuseyinzehra.mobilproje;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kubrahuseyinzehra.mobilproje.Models.HousingPojo;

public class AdresFragment extends Fragment {
    EditText il,ilce,mah;

    private AppCompatButton btnGo;
    @Override
    public View  onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View tasarim =  inflater.inflate(R.layout.fragment_adres, container, false);

        btnGo=tasarim.findViewById(R.id.buttonaddress);
        il=tasarim.findViewById(R.id.editTextil);
        ilce=tasarim.findViewById(R.id.editTextilce);
        mah=tasarim.findViewById(R.id.editTextmah);
        btnGo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.i("try",il.getText().toString());
                Log.i("try",ilce.getText().toString());
                Log.i("try",mah.getText().toString());
                HousingPojo.setIl(il.getText().toString());
                HousingPojo.setIlce(ilce.getText().toString());
                HousingPojo.setMahalle(mah.getText().toString());
                Navigation.findNavController(view).navigate(R.id.adresten_hiye);
              //  Log.e("deneme","buuton nav son onclick");
            }
        });
        return  tasarim;


    }
}