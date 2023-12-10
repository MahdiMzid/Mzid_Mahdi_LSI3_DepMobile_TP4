package com.example.mzid_mahdi_lsi3_mesure_glycemie_10.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mzid_mahdi_lsi3_mesure_glycemie_10.R;

public class ConsultActivity extends AppCompatActivity {
    TextView tvReponse;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();
        Bundle params = getIntent().getExtras();
        tvReponse.setText(getIntent().getStringExtra("result"));

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultActivity.this, MainActivity.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void init(){
        tvReponse=findViewById(R.id.tvReponse);
        btnReturn=findViewById(R.id.btnReturn);
    }
}