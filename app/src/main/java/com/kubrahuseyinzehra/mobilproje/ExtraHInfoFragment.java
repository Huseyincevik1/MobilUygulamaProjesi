package com.kubrahuseyinzehra.mobilproje;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kubrahuseyinzehra.mobilproje.Models.ResimEklePojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExtraHInfoFragment extends Fragment {

    AppCompatButton resimsecbutton, resimeklebutton;
    ImageView secilenresimImageView;
    String uye_id, ilan_id, resim;
    private RestApi restApi;
    Bitmap bitmap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim = inflater.inflate(R.layout.fragment_extra_h_info, container, false);
        tanımla(tasarim);

        return tasarim;
    }

    ActivityResultLauncher<String> resimcercevesisecme = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    secilenresimImageView.setImageURI(result);
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(requireContext().getContentResolver(),result);
                        secilenresimImageView.setVisibility(View.VISIBLE);
                        secilenresimImageView.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            );

    public void resimyukle(){
        uye_id="2";
        ilan_id="20";
        resim = imageToString();
        restApi.resimyukle(uye_id,ilan_id,resim).enqueue(new Callback<ResimEklePojo>() {
            @Override
            public void onResponse(Call<ResimEklePojo> call, Response<ResimEklePojo> response) {
                if (response.body() != null) {
                    if (response.body().isTf()) {
                        Toast.makeText(requireContext(), response.body().getSonuc(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(requireContext(), response.body().getSonuc(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResimEklePojo> call, Throwable t) {

            }
        });
    }


    public void  tanımla(View tasarim){
        resimeklebutton = tasarim.findViewById(R.id.resimeklebutton);
        resimsecbutton =tasarim.findViewById(R.id.resimsecbuuton);
        secilenresimImageView = tasarim.findViewById(R.id.secilenresimImageView);

        restApi = ApiUtils.getRestApiInterface();
        resimsecbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resimcercevesisecme.launch("image/*");

                Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), secilenresimImageView.getId());


            }
        });
        resimeklebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("v","yükleme öncesi");

                resimyukle();

            }
        });
    }

  public String imageToString()
  {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte [] bytes = byteArrayOutputStream.toByteArray();

      String text= Base64.encodeToString(bytes,Base64.DEFAULT);

      return text;
  }
}