package com.kubrahuseyinzehra.mobilproje;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AnaSayfaFragment extends Fragment {

    private AppCompatButton buttonIlanver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_ana_sayfa, container, false);
        buttonIlanver=tasarim.findViewById(R.id.buttonIlanver);
        Log.e("deneme","buuton onclick");
        buttonIlanver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.e("deneme","buuton  nav ön onclick");
                Navigation.findNavController(view).navigate(R.id.mainden_adrese);
                Log.e("deneme","buuton nav son onclick");
            }
        });
        return  tasarim;
    }

}