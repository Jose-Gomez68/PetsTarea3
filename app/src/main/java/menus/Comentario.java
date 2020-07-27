package menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petstarea3.R;

import javaMail.JavaMailAPI;

public class Comentario extends AppCompatActivity {

    public EditText EtMail;
    public EditText Comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_comentario );

        EtMail = (EditText) findViewById ( R.id.Mail );
        Comentario = (EditText) findViewById ( R.id.TexArea );

    }

    public void enviarCorreo (View vista){

        String mail = EtMail.getText ().toString ().trim ();
        String mensaje = Comentario.getText ().toString ().trim ();
        String Subject = "COMENTARIO";

        //enviando el correo
        JavaMailAPI javaMailAPI = new JavaMailAPI ( this, mail, Subject, mensaje );
        javaMailAPI.execute ();
        Toast.makeText ( this, "ENVIANDO..", Toast.LENGTH_LONG ).show ();

    }

}
