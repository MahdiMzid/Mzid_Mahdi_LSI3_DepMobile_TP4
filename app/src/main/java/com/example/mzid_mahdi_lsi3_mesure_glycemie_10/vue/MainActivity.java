package com.example.mzid_mahdi_lsi3_mesure_glycemie_10.vue;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mzid_mahdi_lsi3_mesure_glycemie_10.R;
import com.example.mzid_mahdi_lsi3_mesure_glycemie_10.controller.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int APPEL_ACTIVITY_B = 1;
    private EditText etValeur;
    private TextView tvAge;
    private SeekBar sbAge;
    private RadioButton rbIsFasting, rbIsNotFasting;
    private Button btnConsulter;
    private Controller controller = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                tvAge.setText("Votre âge : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Information", "button cliqué");
                int age;
                float valeurMesuree;
                boolean verifAge = false, verifValeur = false;
                if (sbAge.getProgress() != 0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre age !",
                            Toast.LENGTH_SHORT).show();
                if (!etValeur.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !",
                            Toast.LENGTH_LONG).show();
                if (verifAge && verifValeur) {
                    age = sbAge.getProgress();
                    valeurMesuree = Float.valueOf(etValeur.getText().toString());
                    //Flèche "User action" Vue --> Controller
                    controller.createPatient(age, valeurMesuree, rbIsFasting.isChecked());
                    //Flèche "Update" Controller --> vue
                    String Reponse = controller.getReponse();

                    Intent intent = new Intent(MainActivity.this, ConsultActivity.class);
                    intent.putExtra("result", Reponse);
                    //noinspection deprecation
                    startActivityForResult(intent, APPEL_ACTIVITY_B);
                    }
                }
            });
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        MainActivity.super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == APPEL_ACTIVITY_B) {
            if (resultCode == Activity.RESULT_CANCELED) {
                // Afficher un <link>Toast</link> d'erreur
                Toast.makeText(MainActivity.this, "Opération annulée", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void init() {
        sbAge = findViewById(R.id.sbAge);
        tvAge = findViewById(R.id.votreAge);
        etValeur = findViewById(R.id.vm);
        rbIsFasting = findViewById(R.id.rbtOui);
        rbIsNotFasting = findViewById(R.id.rbtNon);
        btnConsulter = findViewById(R.id.buttonConsult);


    }

}
