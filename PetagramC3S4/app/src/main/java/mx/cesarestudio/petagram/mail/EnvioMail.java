package mx.cesarestudio.petagram.mail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mx.cesarestudio.petagram.mail.Configuracion;

/**
 * Created by cfvn0 on 12/10/2016.
 */

public class EnvioMail extends AsyncTask<Void,Void,Void> {
    private Context contexto;
    private Session sesion;
    private String email;
    private String nombre;
    private String mensaje;
    private ProgressDialog progreso;

    public EnvioMail(Context contexto, String email, String mensaje, String nombre) {
        this.contexto = contexto;
        this.email = email;
        this.mensaje = mensaje;
        this.nombre = nombre;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progreso = ProgressDialog.show(contexto,"Enviando Mensaje","Por favor espere...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progreso.dismiss();
        Toast.makeText(contexto,"Mensaje Enviado",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", Configuracion.EMAIL);
        props.setProperty("mail.smtp.auth", "false");
        sesion = Session.getDefaultInstance(props);
        try{
            MimeMessage mm = new MimeMessage(sesion);
            mm.setFrom(new InternetAddress(email));
            mm.addRecipient(Message.RecipientType.TO,new InternetAddress(Configuracion.EMAIL));
            mm.setSubject(nombre);
            mm.setText(mensaje);
            Transport t = sesion.getTransport("smtp");
            t.sendMessage(mm,mm.getAllRecipients());
            t.close();
        }
        catch (MessagingException me){
            me.printStackTrace();
        }
        return null;
    }

}
