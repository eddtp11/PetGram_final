package com.eddtp.petgram.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;

import java.util.ArrayList;

public class AdapterMascotasFavs extends RecyclerView.Adapter<AdapterMascotasFavs.MascotasFViewHolder> {

    private ArrayList<Mascota> listaMascotas;
    private Activity activity;

    public AdapterMascotasFavs(ArrayList<Mascota> listaMascotas, Activity activity){
        this.listaMascotas = listaMascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterMascotasFavs.MascotasFViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotasfavs, parent, false);
        return new MascotasFViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMascotasFavs.MascotasFViewHolder holder, int position) {
        Mascota mascota = listaMascotas.get(position);
        holder.img_pets_favs.setImageResource(mascota.getFotoMascota());
        holder.tv_nombre.setText(mascota.getNombre());
        holder.tv_likes.setText(mascota.getLikes() + "");
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public class MascotasFViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_pets_favs;
        private TextView tv_nombre;
        private ImageView img_favs;
        private TextView tv_likes;

        public MascotasFViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img_pets_favs = (ImageView) itemView.findViewById(R.id.img_pets_favs);
            this.tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            this.img_favs = (ImageView) itemView.findViewById(R.id.img_favs);
            this.tv_likes = (TextView) itemView.findViewById(R.id.tv_likes);
        }
    }
}