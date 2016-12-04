package mx.cesarestudio.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.cesarestudio.petagram.R;
import mx.cesarestudio.petagram.adapter.MascotaAdaptador;
import mx.cesarestudio.petagram.adapter.MiMascotaAdaptador;
import mx.cesarestudio.petagram.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class FotosMiMascota extends Fragment {
    private ArrayList<Mascota> miMascota;
    private RecyclerView listaMiMascota;

    public FotosMiMascota() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fotos_mi_mascota, container, false);
        llenarListaMascotas();
        setHasOptionsMenu(true);
        listaMiMascota = (RecyclerView)v.findViewById(R.id.listaMascotas2);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);

        listaMiMascota.setLayoutManager(glm);

        inicializarAdaptador();

        return v;
    }
    public void llenarListaMascotas(){
        miMascota = new ArrayList<>();
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",10));
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",8));
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",18));
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",30));
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",60));
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",12));
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",19));
        miMascota.add(new Mascota(R.drawable.perro1,"Beetovhen",25));
    }
    public void inicializarAdaptador(){
        MiMascotaAdaptador ma = new MiMascotaAdaptador(getActivity(),miMascota);
        listaMiMascota.setAdapter(ma);
    }

}
