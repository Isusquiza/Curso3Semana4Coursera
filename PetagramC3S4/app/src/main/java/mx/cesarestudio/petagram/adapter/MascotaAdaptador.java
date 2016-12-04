package mx.cesarestudio.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import java.util.ArrayList;

import mx.cesarestudio.petagram.pojo.Mascota;
import mx.cesarestudio.petagram.R;

/**
 * Created by cfvn0 on 12/7/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    private ArrayList<Mascota> mascotas;
    Activity actividad;
    public MascotaAdaptador(Activity actividad,ArrayList<Mascota> mascotas){
        this.actividad = actividad;
        this.mascotas = mascotas;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mvh, int position) {
        Mascota mascota = mascotas.get(position);
        mvh.imgMascota.setImageResource(mascota.getImgMascota());
        mvh.tvNombre.setText(mascota.getNombre());
        mvh.tvLikes.setText(""+mascota.getNumLikes());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public  class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageView imgHuesoBlanco;
        public MascotaViewHolder(final View itemView) {
            super(itemView);
            imgMascota = (ImageView)itemView.findViewById(R.id.imgMascota);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombreMascota);
            tvLikes = (TextView)itemView.findViewById(R.id.tvlikes);
            imgHuesoBlanco= (ImageView)itemView.findViewById(R.id.imgHuesoBlanco);
            imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int auxNumLikes = Integer.parseInt(tvLikes.getText().toString());
                    tvLikes.setText(""+(auxNumLikes+1));
                    Toast.makeText(actividad,itemView.getResources().getString(R.string.MensajeLike)+tvNombre.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });

        }

    }
}
