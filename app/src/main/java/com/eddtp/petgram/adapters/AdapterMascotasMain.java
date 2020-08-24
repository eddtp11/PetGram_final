package com.eddtp.petgram.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;
import com.eddtp.petgram.database.ConstructorMascotas;

import java.util.ArrayList;

public class AdapterMascotasMain extends RecyclerView.Adapter<AdapterMascotasMain.MascotasMViewHolder> {

    private ArrayList<Mascota> listaMascotas;
    private Activity activity;
    private boolean darlike;
    /*private String like;
    private int sumalikes;*/

    public AdapterMascotasMain(ArrayList<Mascota> listaMascotas, Activity activity){
        this.listaMascotas = listaMascotas;
        this.activity = activity;
    }

    public ArrayList<Mascota> getListaMascotas(){
        return listaMascotas;
    }

    @NonNull
    @Override
    public AdapterMascotasMain.MascotasMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasMViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotasMViewHolder holder, int position) {

        final Mascota mascota = listaMascotas.get(position);
        holder.img_pets.setImageResource(mascota.getFotoMascota());
        holder.tv_nombre.setText(mascota.getNombre());
        holder.tv_likes.setText(String.valueOf(mascota.getLikes()));
        holder.imgBoneLike.setImageResource(mascota.getIconlikeblank());

        holder.imgBoneLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                darlike = mascota.getEstaLike();

                if(!darlike){
                    Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                    constructorMascotas.darLikeMascota(mascota);
                    holder.tv_likes.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
                }
                darlike = !darlike;
                mascota.setEstalike(darlike);
                holder.imgBoneLike.setImageResource(mascota.cambiarImagen());
                mascota.setIconlikeblank(mascota.cambiarImagen());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public class MascotasMViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_pets;
        private ImageView imgBoneLike;
        private TextView tv_nombre;
        private TextView tv_likes;
        private ImageView img_hueso;

        public MascotasMViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img_pets = (ImageView) itemView.findViewById(R.id.img_pets);
            this.imgBoneLike = (ImageView) itemView.findViewById(R.id.imgBoneLike);
            this.tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            this.tv_likes = (TextView) itemView.findViewById(R.id.tv_likes);
            this.img_hueso = (ImageView) itemView.findViewById(R.id.img_hueso);
        }
    }
}