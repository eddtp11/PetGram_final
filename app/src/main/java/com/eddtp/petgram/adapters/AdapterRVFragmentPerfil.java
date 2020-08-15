package com.eddtp.petgram.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddtp.petgram.POJO.Foto;
import com.eddtp.petgram.R;

import java.util.ArrayList;

public class AdapterRVFragmentPerfil extends RecyclerView.Adapter<AdapterRVFragmentPerfil.PerfilViewHolder> {

    private ArrayList<Foto> fotosperfil;

    public AdapterRVFragmentPerfil(ArrayList<Foto> fotos, Activity activity) {
        this.fotosperfil = fotos;
    }

    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotospet, parent, false);
        return new AdapterRVFragmentPerfil.PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder holder, int position) {
        Foto foto = fotosperfil.get(position);
        holder.fotopet.setImageResource(foto.getFotoPet());
        holder.numerolikes.setText(foto.getLike());
    }

    @Override
    public int getItemCount() {
        return fotosperfil.size();
    }

    public class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotopet;
        private TextView numerolikes;
        private ImageView imghueso;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            this.fotopet = (ImageView) itemView.findViewById(R.id.fotopet);
            this.numerolikes = (TextView) itemView.findViewById(R.id.numerolikes);
            this.imghueso = (ImageView) itemView.findViewById(R.id.imghueso);
        }
    }
}
