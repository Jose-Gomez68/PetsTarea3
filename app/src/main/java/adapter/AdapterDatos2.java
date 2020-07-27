package adapter;

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

import com.example.petstarea3.Lista2;
import com.example.petstarea3.ListaMascotas;
import com.example.petstarea3.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import fragments.perfil;

public class AdapterDatos2 extends RecyclerView.Adapter<AdapterDatos2.ViewHolderDatos> {

    ArrayList<Lista2> lista;

    public AdapterDatos2(ArrayList<Lista2> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public AdapterDatos2.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.item_list,null,false );
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.cardview2,null,false );


        return new ViewHolderDatos ( view );
    }



    @Override
    public void onBindViewHolder(@NonNull final AdapterDatos2.ViewHolderDatos holder, final int position) {


        //holder.img.setImageResource ( lista.get ( position ).getImag2 () );
        holder.img2.setImageResource ( lista.get ( position ).getImag3 () );
        holder.contadorLike.setText ( lista.get ( position ).getContador () );

    }

    @Override
    public int getItemCount() {
        return lista.size ();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        CircularImageView img2;
        ImageView img;
        TextView contadorLike;
        ImageButton btnLike;
        TextView nom;


        public ViewHolderDatos(@NonNull View itemView) {
            super ( itemView );
            //dato = (TextView) itemView.findViewById ( R.id.idDato );
            img2 = (CircularImageView) itemView.findViewById ( R.id.ImgCirc);
            img = (ImageView) itemView.findViewById ( R.id.imgVer2 );
            contadorLike = (TextView) itemView.findViewById ( R.id.ContadorLike2 );
            btnLike = (ImageButton) itemView.findViewById ( R.id.ImgHuesoLike );
            //nom = (TextView) itemView.findViewById ( R.id. );

        }

    }
}
