package com.kubrahuseyinzehra.mobilproje.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.kubrahuseyinzehra.mobilproje.Models.IlanlarItem;
import com.kubrahuseyinzehra.mobilproje.R;
import com.kubrahuseyinzehra.mobilproje.TumIlanlarFragmentDirections;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IlanlarimAdapter extends RecyclerView.Adapter<IlanlarimAdapter.CardViewTasarimNesneTutucu> {
    public IlanlarimAdapter(Context mContext, List<IlanlarItem> IlanlarimPojoList) {
        this.mContext = mContext;
        this.IlanlarimPojoList = IlanlarimPojoList;
    }

    private Context mContext;
    private List<IlanlarItem> IlanlarimPojoList;

    @NonNull
    @Override
    public CardViewTasarimNesneTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ilanlarim_card,parent,false);
        return  new CardViewTasarimNesneTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneTutucu holder, int position) {
        IlanlarItem tumIlanPojo = IlanlarimPojoList.get(position);
        holder.textViewBaslik.setText(tumIlanPojo.getBaslik());
        holder.textViewFiyat.setText(tumIlanPojo.getFiyat());
        Picasso.get().load("https://kortizol.net/"+IlanlarimPojoList.get(position).getResim()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,"ilanlarim",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return IlanlarimPojoList.size();
    }


    public class CardViewTasarimNesneTutucu extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewBaslik;
        public TextView textViewAddress;
        public TextView textViewFiyat;
        public CardView cardView;


        public CardViewTasarimNesneTutucu(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageviewresim);
            textViewAddress = itemView.findViewById(R.id.textViewAdrdess);
            textViewFiyat = itemView.findViewById(R.id.textViewFiyat);
            textViewBaslik = itemView.findViewById(R.id.textViewBaslik);
            cardView = itemView.findViewById(R.id.cv);

        }
    }


}
