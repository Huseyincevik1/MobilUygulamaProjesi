package com.kubrahuseyinzehra.mobilproje;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kubrahuseyinzehra.mobilproje.Adapters.IlanlarimAdapter;
import com.kubrahuseyinzehra.mobilproje.Models.IlanlarItem;
import com.kubrahuseyinzehra.mobilproje.Models.IlanlarimPojo;
import com.kubrahuseyinzehra.mobilproje.RestApi.ApiUtils;
import com.kubrahuseyinzehra.mobilproje.RestApi.RestApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IlanlarimFragment extends Fragment {
    RecyclerView recyclerView;
    IlanlarimAdapter adapter;
    List<IlanlarItem> ilanlarimPojos;
    String uyeid;
    private RestApi restApi;


    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_ilanlarim, container, false);
        recyclerView = tasarim.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        restApi = ApiUtils.getRestApiInterface();
        ilanlarimgoruntule("2");
        return tasarim;
    }

    public void ilanlarimgoruntule(String uyeid){
        restApi.ilanlarim("2").enqueue(new Callback<IlanlarimPojo>() {
            @Override
            public void onResponse(Call<IlanlarimPojo> call, Response<IlanlarimPojo> response) {
                if(response.isSuccessful()){
                    Log.e("ilanlarim","görüntüle");
                    ilanlarimPojos = response.body().getIlanlar();
                    Log.e("ilamlarim",ilanlarimPojos.toString());
                    adapter = new IlanlarimAdapter(requireContext(),ilanlarimPojos); //getAplicationcontext
                    Log.e("ilanlarim","görüntüle2");
                    recyclerView.setAdapter(adapter);
                    Log.e("ilanlarim","görüntüle3");
                }

            }

            @Override
            public void onFailure(Call<IlanlarimPojo> call, Throwable t) {
                // Hata durumunda işlemler
            }
        });
    }
}