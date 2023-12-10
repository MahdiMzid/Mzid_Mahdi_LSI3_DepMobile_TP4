package com.example.mzid_mahdi_lsi3_mesure_glycemie_10.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mzid_mahdi_lsi3_mesure_glycemie_10.R;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Information", "button cliqué");
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init(){
        btnConsultation=findViewById(R.id.btnConsultation);
    }
}