package mx.cesarestudio.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.cesarestudio.petagram.R;
import mx.cesarestudio.petagram.pojo.Mascota;

/**
 * Created by cfvn0 on 03/12/2016.
 */

public class MiMascotaAdaptador extends RecyclerView.Adapter<MiMascotaAdaptador.MiMascotaViewHolder>{
    private ArrayList<Mascota> mascotas;
    Activity actividad;
    public MiMascotaAdaptador(Activity actividad,ArrayList<Mascota> mascotas){
        this.actividad = actividad;
        this.mascotas = mascotas;
    }
    @Override
    public MiMascotaAdaptador.MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mimascota,parent,false);
        return new MiMascotaAdaptador.MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaAdaptador.MiMascotaViewHolder mvh, int position) {
        Mascota mascota = mascotas.get(position);
        mvh.imgMascota.setImageResource(mascota.getImgMascota());
        mvh.tvLikes.setText(""+mascota.getNumLikes());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public  class MiMascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView tvLikes;
        public MiMascotaViewHolder(final View itemView) {
            super(itemView);
            imgMascota = (ImageView)itemView.findViewById(R.id.imgMasc);

            tvLikes = (TextView)itemView.findViewById(R.id.tvlike);


        }

    }
}
