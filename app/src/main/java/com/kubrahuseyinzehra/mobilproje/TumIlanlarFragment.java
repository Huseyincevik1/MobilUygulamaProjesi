package com.kubrahuseyinzehra.mobilproje;

import android.os.Bundle;

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

public class TumIlanlarFragment extends Fragment {
    RecyclerView recyclerView;
    IlanlarimAdapter adapter;
    List<IlanlarItem> ilanlarimPojos;

    private RestApi restApi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tasarim= inflater.inflate(R.layout.fragment_tum_ilanlar, container, false);
        recyclerView = tasarim.findViewById(R.id.rvTum);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);
        restApi = ApiUtils.getRestApiInterface();
        tunilanlargoruntule();
        return tasarim;
    }

    private void tunilanlargoruntule() {
        restApi.tumilanlar().enqueue(new Callback<IlanlarimPojo>() {
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

            }
        });
    }
}