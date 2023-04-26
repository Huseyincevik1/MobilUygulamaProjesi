package com.kubrahuseyinzehra.mobilproje;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LoginFragment extends Fragment {

    private AppCompatButton buttonLogin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_login, container, false);
        buttonLogin = tasarim.findViewById(R.id.buttonLogin);
         buttonLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Navigation.findNavController(view).navigate(R.id.logindenAnasyfayaGecis);
             }
         });
        return tasarim;
    }
}