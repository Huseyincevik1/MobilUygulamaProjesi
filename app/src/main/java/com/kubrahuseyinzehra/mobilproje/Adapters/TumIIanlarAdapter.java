package com.kubrahuseyinzehra.mobilproje.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.kubrahuseyinzehra.mobilproje.Models.IlanlarItem;
import com.kubrahuseyinzehra.mobilproje.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TumIIanlarAdapter extends  RecyclerView.Adapter<TumIIanlarAdapter.CardViewTasarimNesneTutucu> {
    private Context mContext;
    private List<IlanlarItem> tumIlanPojoList;



    public TumIIanlarAdapter(Context mContext, List<IlanlarItem> tumIlanPojoList ) {
        this.mContext = mContext;
        this.tumIlanPojoList = tumIlanPojoList;

    }



    @NonNull
    @Override
    public CardViewTasarimNesneTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ilanlarim_card,parent,false);
        return  new CardViewTasarimNesneTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneTutucu holder, int position) {
        IlanlarItem tumIlanPojo = tumIlanPojoList.get(position);
        holder.textViewBaslik.setText(tumIlanPojo.getBaslik());

        StringBuilder builder = new StringBuilder();
        builder.append(tumIlanPojo.getIl()).append("//").append(tumIlanPojo.getIlce()).append(" ").append(tumIlanPojo.getMahalle());

        holder.textViewAddress.setText(builder.toString());
        holder.textViewFiyat.setText(tumIlanPojo.getFiyat());
        Picasso.get().load("https://kortizol.net/"+tumIlanPojoList.get(position).getResim()).into(holder.imageButton);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.tumilan_ilandetay);
                Toast.makeText(mContext,tumIlanPojo.getBaslik(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return tumIlanPojoList.size();
    }

    public class CardViewTasarimNesneTutucu extends RecyclerView.ViewHolder {
        public ImageView imageButton;
        public TextView textViewBaslik;
        public TextView textViewAddress;
        public TextView textViewFiyat;
        public CardView cardView;


        public CardViewTasarimNesneTutucu(View itemView ) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.imageviewresim);
            textViewAddress = itemView.findViewById(R.id.textViewAdrdess);
            textViewFiyat = itemView.findViewById(R.id.textViewFiyat);
            textViewBaslik = itemView.findViewById(R.id.textViewBaslik);
            cardView = itemView.findViewById(R.id.cv);

        }

    }
}
