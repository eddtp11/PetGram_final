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

import java.util.ArrayList;

public class AdapterMascotasMain extends RecyclerView.Adapter<AdapterMascotasMain.MascotasMViewHolder> {

    private ArrayList<Mascota> listaMascotas;
    private Activity activity;
    private String like;
    private int sumalikes;
    private boolean darlike;

    public AdapterMascotasMain(ArrayList<Mascota> listaMascotas, Activity activity){
        this.listaMascotas = listaMascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterMascotasMain.MascotasMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasMViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterMascotasMain.MascotasMViewHolder holder, int position) {

        final Mascota mascota = listaMascotas.get(position);
        holder.img_pets.setImageResource(mascota.getFotoMascota());
        holder.tv_nombre.setText(mascota.getNombre());
        holder.tv_likes.setText(mascota.getLikes());
        holder.imgBoneLike.setImageResource(mascota.getIconlikeblank());

        holder.imgBoneLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like = holder.tv_likes.getText().toString();
                sumalikes = Integer.parseInt(like);
                darlike = mascota.getEstaLike();

                if (!darlike){
                    sumalikes += 1;
                    holder.tv_likes.setText(String.format("%d", sumalikes));
                    Toast.makeText(activity.getApplicationContext(), "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                }
                else {
                    sumalikes -= 1;
                    holder.tv_likes.setText(String.format("%d", sumalikes));
                    Toast.makeText(activity.getApplicationContext(), mascota.getNombre() + "se ha eliminado de favoritos", Toast.LENGTH_SHORT).show();
                }
                darlike = !darlike;
                mascota.setLikes("" + sumalikes);
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