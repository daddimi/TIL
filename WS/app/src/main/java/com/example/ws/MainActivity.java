package com.example.ws;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txid,txpwd;
    HttpAsync httpAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txid = findViewById(R.id.txid);
        txpwd = findViewById(R.id.txpwd);
    }

    public void loginck (View v) {
        String id = txid.getText().toString();
        String pwd = txpwd.getText().toString();
        String url  = "http://192.168.0.3/android/login.jsp";
        url += "?id="+id+"&pwd="+pwd;
        //Toast.makeText(MainActivity.this, url, Toast.LENGTH_LONG).show();

        httpAsync = new HttpAsync();
        httpAsync.execute(url);
    }

    class HttpAsync extends AsyncTask<String,String,String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Login...");
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
            if(result.equals("1")) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Login Failed");
                dialog.setMessage("Check your id or pwd and retry.");
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