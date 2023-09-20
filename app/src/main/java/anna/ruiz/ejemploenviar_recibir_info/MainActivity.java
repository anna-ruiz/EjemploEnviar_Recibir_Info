package anna.ruiz.ejemploenviar_recibir_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import anna.ruiz.ejemploenviar_recibir_info.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    private EditText txtEmail;
    private Button btnDesencriptar;
    private EditText txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();

        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = txtPassword.getText().toString();
                String email = txtEmail.getText().toString();

                if (password.isEmpty() || email.isEmpty()){
                    Toast.makeText(MainActivity.this,"Faltan Datos por rellenar.",Toast.LENGTH_LONG).show();
                }else {
                        //Enviar info a la segunda actividad
                    Intent intent = new Intent(MainActivity.this, DesencriptarActivity.class);
                        //Pasar la info
                    Bundle bundle = new Bundle(); //necesario, es dnd se guarda la info

                    /* EJEMPLO PASANDO INFO UNO A UNO */
                   // bundle.putString("PASS",password); //le añadimos id + info a pasar
                    //bundle.putString("EMAIL",email);

                    /* EJEMPLO PASANDO UN OBJETO */
                    bundle.putSerializable("USER", new Usuario(email,password));

                    intent.putExtras(bundle); //añadimos el bundle al intent, si no no funciona!!!!
                    //comenzar/lanzar la actividad
                    startActivity(intent);
                }

            }
        });

    }

    private void inicializarVista() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        btnDesencriptar = findViewById(R.id.btnDesencriptarMain);

    }
}