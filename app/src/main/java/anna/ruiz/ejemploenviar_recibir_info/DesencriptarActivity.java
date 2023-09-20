package anna.ruiz.ejemploenviar_recibir_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import anna.ruiz.ejemploenviar_recibir_info.modelos.Usuario;

public class DesencriptarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);

        //Recibir información
        Intent intent = getIntent(); //le decimos q pille el intent q hemos mandado en el startActivity
        Bundle bundle = intent.getExtras();//guardamos toda la info del intent en el bundle

        if (bundle != null){
            /* EJEMPLO INFO UNO A UNO */
            //String email = bundle.getString("EMAIL");
            //String password = bundle.getString("PASS");
            //Usuario user = new Usuario(email,password);
           // Toast.makeText(this, "Email es "+ email + " La contraseña es: "+password, Toast.LENGTH_SHORT).show();

            /* EJEMPLO CON OBJETO */
            Usuario user = (Usuario) bundle.getSerializable("USER");
            Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();


        }


    }
}