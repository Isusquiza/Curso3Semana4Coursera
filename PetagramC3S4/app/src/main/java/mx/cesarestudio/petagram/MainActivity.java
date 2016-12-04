package mx.cesarestudio.petagram;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import java.util.ArrayList;

import mx.cesarestudio.petagram.adapter.MascotaAdaptador;
import mx.cesarestudio.petagram.adapter.PageAdapter;
import mx.cesarestudio.petagram.fragment.FotosMiMascota;
import mx.cesarestudio.petagram.fragment.Mascotas;
import mx.cesarestudio.petagram.pojo.Mascota;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbarMA);
        tabLayout = (TabLayout)findViewById(R.id.layoutTab);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);

        }



    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Mascotas());
        fragments.add(new FotosMiMascota());


        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(0).setIcon(R.drawable.profilepet);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.estrellaFav:
                Intent intento =new Intent(MainActivity.this,FavoritosActivity.class);
                startActivity(intento);
                break;
            case R.id.opcionAcercaDe:
                Intent inte=new Intent(MainActivity.this,AcercaDe.class);
                startActivity(inte);
                break;
            case R.id.opcionContacto:
                Intent i = new Intent(MainActivity.this,Contacto.class);
                startActivity(i);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
