package com.example.badro.iotflows.feature;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by badro on 17/02/2019.
 */

public class buscaDados extends AsyncTask<Void, Void, Void> {
    String dado = "";
    String dadoparseados = "";
    String dparseado = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/");
            HttpURLConnection httpURLconexao = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLconexao.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String linhas = "";
            while(linhas != null){
                linhas = bufferedReader.readLine();
                dado = dado + linhas;
            }

            JSONArray JA = new JSONArray(dado);
            for(int i = 0; i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);

                dparseado = "Id do Usuario:  " + JO.get("userId") + "\n" +
                            "Id de Uso:  " + JO.get("id") + "\n" +
                            "Titulo:  " + JO.get("title") + "\n" +
                            "Foi completo?:  " + JO.get("completed") + "\n\n\n";
                dadoparseados = dadoparseados + dparseado;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }
        return null;

    }


    @Override
    protected void onPostExecute(Void aVoid) {

        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.dadoparseados);

    }
}
