package franguerrero.marcadorbaloncesto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModificaMarcador extends AppCompatActivity {

    //elementos que recibimos
    private TextView local, visita;

    //elementos de la activity
    private EditText cmpLocal, cmpVisita;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_marcador);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Localizar los controles
        local = (TextView) findViewById(R.id.txtLocal);
        visita = (TextView) findViewById(R.id.txtVisita);

        //Recuperamos la información pasada en el intent
        Bundle b = this.getIntent().getExtras();


        //capturamos los elementos del layout
        cmpLocal = (EditText) findViewById(R.id.cmpLocal);
        cmpVisita = (EditText) findViewById(R.id.cmpVisita);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);


        //local.setText(b.getString("LOCAL")); //muestra el texto de la otra actividad

        //introducimos el texto original en los campos
        cmpLocal.setText(b.getString("LOCAL"));
        cmpVisita.setText(b.getString(b.getString("VISITA")));

    }

    private void editarLocal(EditText cmpLocal) {
        //local = b.getString("LOCAL");
    }

}
