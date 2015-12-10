package franguerrero.marcadorbaloncesto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton puntos3L, puntos2L, puntos1L, puntos3V, puntos2V, puntos1V, incrementoL, decrementoL, incrementoV, decrementoV, mascota;
    private TextView txtLocal, txtVisita, ptsLocal, ptsVisita;
    private int contadorLocal = 0;
    private int contadorVisita = 0;

    private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        puntos3L = (ImageButton) findViewById(R.id.puntos3L);
        puntos2L = (ImageButton) findViewById(R.id.puntos2L);
        puntos1L = (ImageButton) findViewById(R.id.puntos1L);

        puntos3V = (ImageButton) findViewById(R.id.puntos3V);
        puntos2V = (ImageButton) findViewById(R.id.puntos2V);
        puntos1V = (ImageButton) findViewById(R.id.puntos1V);

        incrementoL = (ImageButton) findViewById(R.id.incrementoL);
        decrementoL = (ImageButton) findViewById(R.id.decrementoL);
        incrementoV = (ImageButton) findViewById(R.id.incrementoV);
        decrementoV = (ImageButton) findViewById(R.id.decrementoV);

        mascota = (ImageButton) findViewById(R.id.mascota);

        txtLocal = (TextView) findViewById(R.id.txtLocal);
        txtVisita = (TextView) findViewById(R.id.txtVisita);
        ptsLocal = (TextView) findViewById(R.id.ptsLocal);
        ptsVisita = (TextView) findViewById(R.id.ptsVisita);


        mp = MediaPlayer.create (this, R.raw.charge);




        //iniciamos los marcadores a cero
        iniciaMarcador();


        /**
         * Establece 3 puntos para el equipo Local
         */
        puntos3L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorLocal += 3;
                ptsLocal.setText(Integer.toString(contadorLocal));
            }
        });


        /**
         * Establece 2 puntos para el equipo Local
         */
        puntos2L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorLocal += 2;
                ptsLocal.setText(Integer.toString(contadorLocal));
            }
        });


        /**
         * Establece 1 punto para el equipo Local
         */
        puntos1L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorLocal++;
                ptsLocal.setText(Integer.toString(contadorLocal));
            }
        });


        /**
         * Establece 3 puntos para el equipo Visitante
         */
        puntos3V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorVisita += 3;
                ptsVisita.setText(Integer.toString(contadorVisita));
            }
        });


        /**
         * Establece 2 puntos para el equipo Visitante
         */
        puntos2V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorVisita += 2;
                ptsVisita.setText(Integer.toString(contadorVisita));
            }
        });


        /**
         * Establece 1 punto para el equipo Visitante
         */
        puntos1V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorVisita++;
                ptsVisita.setText(Integer.toString(contadorVisita));
            }
        });

        /**
         * Incrementa en 1 el marcador del equipo Local
         */
        incrementoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorLocal++;
                ptsLocal.setText(Integer.toString(contadorLocal));
            }
        });


        /**
         * Decrementa en 1 el marcador del equipo Local
         */
        decrementoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contadorLocal > 0) {
                    contadorLocal--;
                    ptsLocal.setText(Integer.toString(contadorLocal));
                }
            }
        });


        /**
         * Incrementa en 1 el marcador del equipo Visitante
         */
        incrementoV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorVisita++;
                ptsVisita.setText(Integer.toString(contadorVisita));
            }
        });


        /**
         * Decrementa en 1 el marcador del equipo Visitante
         */
        decrementoV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contadorVisita > 0) {
                    contadorVisita--;
                    ptsVisita.setText(Integer.toString(contadorVisita));
                }
            }
        });


        /**
         * Reproduce un sonido al pulsar sobre la mascota
         */
        mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.modificar_marcador) {
            Intent intent = new Intent(MainActivity.this, ModificaMarcador.class);

            //Creamos la información a pasar entre actividades
            Bundle b = new Bundle(); //pasa la información a la otra actividad

            b.putString("LOCAL", txtLocal.getText().toString());
            b.putString("VISITA", txtVisita.getText().toString());

            //Añadimos la información al intent
            intent.putExtras(b);

            //Iniciamos la nueva actividad
            startActivity(intent);

            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.reset) {
            iniciaMarcador();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Inicia el marcador a cero
     */
    private void iniciaMarcador() {
        ptsLocal.setText(Integer.toString(contadorLocal));
        ptsVisita.setText(Integer.toString(contadorVisita));
    }


}
