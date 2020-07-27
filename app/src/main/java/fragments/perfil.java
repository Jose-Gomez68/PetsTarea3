package fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petstarea3.Lista2;
import com.example.petstarea3.ListaMascotas;
import com.example.petstarea3.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import adapter.AdapterDatos2;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class perfil extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recycler2;
    ArrayList<Lista2> lista;

    private CircularImageView img3;
    private TextView conta,conta2;
    private ImageView img4;


    public perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static perfil newInstance(String param1, String param2) {
        perfil fragment = new perfil ();
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
        View vista2 =inflater.inflate ( R.layout.fragment_perfil, container, false );

        img3 = (CircularImageView) vista2.findViewById ( R.id.ImgCirc );
        img4 = (ImageView) vista2.findViewById ( R.id.imgVer2 );
        conta = (TextView) vista2.findViewById ( R.id.NombrePerfil );
        conta2 = (TextView) vista2.findViewById ( R.id.ContadorLike2 );
        Bundle objetoPersonaje = getArguments ();
        ListaMascotas personaje=null;

        if (objetoPersonaje != null){
            personaje = (ListaMascotas) objetoPersonaje.getSerializable ( "objeto" );
                img3.setImageResource ( personaje.getImagenn () );
                conta.setText ( personaje.getContadorLike () );
        }

       /* recycler2 = (RecyclerView) vista2.findViewById ( R.id.recycler22 );
       lista = new ArrayList<> ();
        recycler2.setLayoutManager ( new GridLayoutManager ( getContext (),3 ) );
        llenar2();
        AdapterDatos2 adapter = new AdapterDatos2 ( lista );
        recycler2.setAdapter ( adapter );*/


        //String title = getActivity ().getIntent().getStringExtra("title");
        //Toast.makeText ( getContext (), "esto es:"+title, Toast.LENGTH_LONG ).show ();

        return vista2;
    }

    private void llenar2() {

        lista.add ( new Lista2 ( "6",R.drawable.perrito) );
        lista.add ( new Lista2 ( "5",R.drawable.gatito ) );


    }



}
