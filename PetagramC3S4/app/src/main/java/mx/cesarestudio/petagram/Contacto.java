package mx.cesarestudio.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.cesarestudio.petagram.mail.EnvioMail;

public class Contacto extends AppCompatActivity {
    private EditText tietNombre;
    private EditText tietMensaje;
    private EditText tietCorreo;
    private Button boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        tietCorreo = (EditText)findViewById(R.id.tietCorreo);
        tietMensaje = (EditText)findViewById(R.id.tietMensaje);
        tietNombre = (EditText)findViewById(R.id.tietNombre);
        boton = (Button)findViewById(R.id.btnEnviarMsg);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMail();

            }
        });
    }
    public void enviarMail(){
        String email = tietCorreo.getText().toString().trim();
        String nombre = tietNombre.getText().toString().trim();
        String mensaje = tietMensaje.getText().toString().trim();
        EnvioMail em = new EnvioMail(this,email,nombre,mensaje);
        em.execute();


    }
}
