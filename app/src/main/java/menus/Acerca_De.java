package menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;

import com.example.petstarea3.R;

public class Acerca_De extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_acerca__de );

        Html.fromHtml(getString(R.string.Acerca));

        regreso();

    }

    private void regreso () {

        getSupportActionBar ().setTitle ( "Acerca De" ); //poner titulo a una activity
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true ); //Boton de regreso en la barra hay que activar a donde regreso en manifest

    }

}
