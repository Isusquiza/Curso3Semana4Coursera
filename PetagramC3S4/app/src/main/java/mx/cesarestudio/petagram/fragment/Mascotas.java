package mx.cesarestudio.petagram.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mx.cesarestudio.petagram.AcercaDe;
import mx.cesarestudio.petagram.Contacto;
import mx.cesarestudio.petagram.FavoritosActivity;
import mx.cesarestudio.petagram.MainActivity;
import mx.cesarestudio.petagram.R;
import mx.cesarestudio.petagram.adapter.MascotaAdaptador;
import mx.cesarestudio.petagram.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mascotas extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public Mascotas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        llenarListaMascotas();
        setHasOptionsMenu(true);
        listaMascotas = (RecyclerView)v.findViewById(R.id.listaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarAdaptador();

        return v;
    }
    public void llenarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.perro1,"Beetovhen",10));
        mascotas.add(new Mascota(R.drawable.perro2,"Hachiko",5));
        mascotas.add(new Mascota(R.drawable.perro3,"Laika",10));
        mascotas.add(new Mascota(R.drawable.perro4,"Pongo",25));
        mascotas.add(new Mascota(R.drawable.perro5,"Rex",2));
        mascotas.add(new Mascota(R.drawable.perro6,"Pluto",7));
        mascotas.add(new Mascota(R.drawable.perro7,"Odie",5));
        mascotas.add(new Mascota(R.drawable.perro8,"Snoopy",6));
        mascotas.add(new Mascota(R.drawable.perro9,"Niebla",15));
        mascotas.add(new Mascota(R.drawable.perro10,"Lassie",12));
        mascotas.add(new Mascota(R.drawable.perro11,"Goofy",0));

    }
    public void inicializarAdaptador(){
        MascotaAdaptador ma = new MascotaAdaptador(getActivity(),mascotas);
        listaMascotas.setAdapter(ma);
    }

}
