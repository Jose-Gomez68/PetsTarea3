package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petstarea3.ListaMascotas;
import com.example.petstarea3.MainActivity;
import com.example.petstarea3.R;

import java.util.ArrayList;

import fragments.perfil;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener {

    ArrayList<ListaMascotas> listaDatos;
    private View.OnClickListener listener;

    public AdapterDatos(ArrayList<ListaMascotas> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.item_list,null,false );
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.cardviewrecycler,null,false );

            view.setOnClickListener ( this );

        return new ViewHolderDatos ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterDatos.ViewHolderDatos holder, final int position) {

        holder.btnLike.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                //Toast toast = new Toast.makeText (  , "Diste like a ", Toast.LENGTH_SHORT).show ();

                Toast.makeText(v.getContext(), "Diste like a "+ listaDatos.get ( position ).getNombre (),
                        Toast.LENGTH_SHORT).show();

            }
        } );

        /*holder.img.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent ( v.getContext (), perfil.class );
                //intent.putExtra ( "nombr", listaDatos.get ( position ).getNombre () );
                v.getContext ().startActivity(intent);
               // intent.putExtra ( "imagen", listaDatos.get ( position ).getImagenn ());

            }
        } );*/


        holder.nomb.setText ( listaDatos.get ( position ).getNombre () );
        holder.img.setImageResource ( listaDatos.get ( position ).getImagenn () );
        holder.contadorLike.setText ( listaDatos.get ( position ).getContadorLike () );

    }

    @Override
    public int getItemCount() {
        return listaDatos.size ();
    }

    public void setOnClickListener (View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick ( v );
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView nomb;
        ImageView img;
        TextView contadorLike;
        ImageButton btnLike;
        TextView tv;


        public ViewHolderDatos(@NonNull View itemView) {
            super ( itemView );
            //dato = (TextView) itemView.findViewById ( R.id.idDato );
            nomb = (TextView) itemView.findViewById ( R.id.TxV1 );
            img = (ImageView) itemView.findViewById ( R.id.imgVer );
            contadorLike = (TextView) itemView.findViewById ( R.id.ContadorLike );
            btnLike = (ImageButton) itemView.findViewById ( R.id.ImgHuesoLike );
            //tv = (TextView) itemView.findViewById ( R.id.TxV1 );

        }

    }

}
