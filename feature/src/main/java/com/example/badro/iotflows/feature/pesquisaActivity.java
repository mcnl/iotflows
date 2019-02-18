package com.example.badro.iotflows.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.badro.iotflows.feature.R.id.res;

public class pesquisaActivity extends AppCompatActivity {
    public static TextView data;
    public static TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        data = (TextView) findViewById(R.id.pesquisaa);
        res = (TextView) findViewById(R.id.res);
        pesquisaDados processo = new pesquisaDados();
        processo.execute();
    }
}
