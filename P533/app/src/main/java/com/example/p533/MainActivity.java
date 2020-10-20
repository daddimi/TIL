package com.example.p533;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tx_id,tx_pwd;
    HttpAsync httpAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx_id = findViewById(R.id.tx_id);
        tx_pwd = findViewById(R.id.tx_pwd);
    }

    public void bt (View v) {
        String id = tx_id.getText().toString();
        String pwd = tx_pwd.getText().toString();
        String url = "http://192.168.0.3/android/login.jsp";
        url += "?id="+id+"&pwd="+pwd;
        Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();

        httpAsync = new HttpAsync();
        httpAsync.execute(url);
    }

    class HttpAsync extends AsyncTask<String,String,String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Login ...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0].toString();
            String result = HttpConnect.getString(url);
            return result;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {

            progressDialog.dismiss();
            String result = s.trim();
            if (result.equals("1")) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent);
            } else {
                androidx.appcompat.app.AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Failed");
                dialog.setMessage("Change id or pwd and retry.");
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dialog.show();
            }
        }
    }


}