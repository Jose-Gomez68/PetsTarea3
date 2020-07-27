package com.example.petstarea3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;

import adapter.AdapterDatos;
import fragments.IComunicaFragments;
import fragments.perfil;
import menus.Acerca_De;
import menus.Comentario;

public class MainActivity extends AppCompatActivity implements IComunicaFragments {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2;
    public PageAdapter pagerAdapter;
    private Object perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        tabLayout = findViewById ( R.id.tabmenu );
        tab1 = (TabItem) findViewById ( R.id.Tab1 );
        tab2 = (TabItem) findViewById ( R.id.Tab2 );
        viewPager = findViewById ( R.id.viewpager );

        pagerAdapter   = new PageAdapter ( getSupportFragmentManager (), tabLayout.getTabCount() );
        viewPager.setAdapter ( pagerAdapter );

        tabLayout.setOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
    // if para obtener la posicion a donde nos movemos en las tab y cargar el fragment
                //que corresponda
                viewPager.setCurrentItem ( tab.getPosition () );
                if (tab.getPosition () == 0){
                    pagerAdapter.notifyDataSetChanged ();
                }   else if (tab.getPosition () == 1){
                        pagerAdapter.notifyDataSetChanged ();
                    }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );

        viewPager.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( tabLayout ) );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate ( R.menu.menu_puntitos, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId ()){
            case R.id.Item1:
               // Toast.makeText ( this,"ranquet",Toast.LENGTH_SHORT ).show ();

                Intent iitem1 = new Intent(this, Comentario.class);
                this.startActivity(iitem1);
                break;

            case R.id.Item2:
                Intent i = new Intent(this, Acerca_De.class);
                this.startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected ( item );
        }
        return true;
    }

    @Override
    public void enviarPersonaje(ListaMascotas personaje) {

        perfil p = new perfil ();
        Bundle bundleEnvio = new Bundle ();
        bundleEnvio.putSerializable ( "objeto", (Serializable) personaje );
        p.setArguments(bundleEnvio);

        getSupportFragmentManager ().beginTransaction ().replace ( R.id.ContendorPrincipal, p ).addToBackStack ( null ).commit ();

    }
}
