package com.example.badro.iotflows.feature;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.botao);
        data = (TextView) findViewById(R.id.dados);
        lista = (ListView)findViewById(R.id.list);
        lista.setAdapter(new customAdapter(this));
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

class umaLinha {
    String Titulo;
    String Id;
    String UserID;
    String completed;

    umaLinha(String Title, String Id,  String UserID, String completed){
        this.Titulo = Title;
        this.Id = Id;
        this.UserID = UserID;
        this.completed = completed;
    }


}
class customAdapter extends BaseAdapter{
    ArrayList<umaLinha> lista;
    Context c;
    public static String dados;
    String uI= "";
    String II= "";
    String T= "";
    String C= "";
    customAdapter(Context context){
        c = context;
        lista = new ArrayList<umaLinha>();
        buscaDados processo = new buscaDados();
        processo.execute();
        try{
            JSONArray JA = new JSONArray(dados);
            for(int i = 0; i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                uI = uI + JO.get("userId");
                II = II + JO.get("id");
                T = T + JO.get("title");
                C = C + JO.get("userId");
                lista.add(new umaLinha(uI,II,T,C));
            }
          }catch(JSONException e){
            e.printStackTrace();
          }

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = layoutInflater.inflate(R.layout.linhalista,parent,false);

        TextView title = (TextView) row.findViewById(R.id.title);
        TextView idUsuario = (TextView) row.findViewById(R.id.idUsuario);
        TextView idnormal = (TextView) row.findViewById(R.id.idnormal);
        TextView completo = (TextView) row.findViewById(R.id.completo);

        umaLinha tmp = lista.get(position);
        title.setText(tmp.Titulo);
        idUsuario.setText(tmp.UserID);
        idnormal.setText(tmp.Id);
        if(tmp.completed == "true"){
            completo.setText("+");
        }
        else{
            completo.setText("-");
        }
        return row;
    }
}