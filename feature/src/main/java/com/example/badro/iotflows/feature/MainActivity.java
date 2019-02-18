package com.example.badro.iotflows.feature;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView data;
    public static String searchedString = "Funcionouy";
    public static EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.botao);
        data = (TextView) findViewById(R.id.dados);
        search = (EditText) findViewById(R.id.pesquisa);


        buscaDados processo = new buscaDados();
        processo.execute();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchedString = search.getText().toString();
                startActivity(new Intent(MainActivity.this, pesquisaActivity.class));
            }
        });

    }
}


