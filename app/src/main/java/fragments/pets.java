package fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.petstarea3.ListaMascotas;
import com.example.petstarea3.R;

import java.util.ArrayList;

import adapter.AdapterDatos;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link pets#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pets extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recycler;
    ArrayList<ListaMascotas> listaDatos;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    private ImageButton btn_linke;

    public pets() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pets.
     */
    // TODO: Rename and change types and number of parameters
    public static pets newInstance(String param1, String param2) {
        pets fragment = new pets ();
        Bundle args = new Bundle ();
        args.putString ( ARG_PARAM1, param1 );
        args.putString ( ARG_PARAM2, param2 );
        fragment.setArguments ( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        if (getArguments () != null) {
            mParam1 = getArguments ().getString ( ARG_PARAM1 );
            mParam2 = getArguments ().getString ( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate ( R.layout.fragment_pets, container, false );
        // Inflate the layout for this fragment
        recycler = (RecyclerView) vista.findViewById ( R.id.mirecycle );
        listaDatos = new ArrayList<> ();
        btn_linke = (ImageButton) vista.findViewById ( R.id.ImgHuesoLike );

        recycler.setLayoutManager ( new GridLayoutManager ( getContext (),1 ) );

        llenarD ();

        AdapterDatos adapter = new AdapterDatos ( listaDatos );

        recycler.setAdapter ( adapter );

        adapter.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Diste like a a la lista"+ listaDatos.get ( recycler.getChildAdapterPosition ( v ) ).getNombre (),
                        Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarPersonaje ( listaDatos.get ( recycler.getChildAdapterPosition ( v ) ) );
            }
        } );

        return vista;
    }

    private void llenarD() {

        listaDatos.add ( new ListaMascotas ( "Perro", R.drawable.perrito, "1" ) );
        listaDatos.add ( new ListaMascotas ( "Gato", R.drawable.gatito, "6" ) );
        listaDatos.add ( new ListaMascotas ( "Ardilla", R.drawable.ardillita, "5" ) );
        listaDatos.add ( new ListaMascotas ( "Conejo", R.drawable.conejo, "1" ) );

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach ( context );

        if (context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments)this.activity;
        }

    }
}
