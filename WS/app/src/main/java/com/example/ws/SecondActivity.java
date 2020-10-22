package com.example.ws;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView inputdate,txbooking;
    ListView milist;
    ConstraintLayout mlayout,blayout;
    ArrayList<Movie> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        inputdate = findViewById(R.id.inputdate);
        milist = findViewById(R.id.milist);
        mlayout = findViewById(R.id.mlayout);
        list = new ArrayList<>();
    }

    public void mick(View v) {

        getData();
    }

    public void getData() {
        String date = inputdate.getText().toString();
        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt="+date;
        MiAsync miAsync = new MiAsync();
        miAsync.execute(url);

    }
    class MiAsync extends AsyncTask<String,Void,String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(SecondActivity.this);
            progressDialog.setTitle("Get Movie Info");
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
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            JSONArray ja = null;
            JSONObject jo = null;
            try {
                jo = new JSONObject(s);
                JSONObject jo1 = jo.getJSONObject("boxOfficeResult");
                ja = jo1.getJSONArray("dailyBoxOfficeList");
                for(int i=0; i<ja.length(); i++) {
                    JSONObject jb = ja.getJSONObject(i);
                    String rank = jb.getString("rank");
                    String name = jb.getString("movieNm");
                    String date = jb.getString("openDt");
                    String audi = jb.getString("audiAcc");
                    Movie movie = new Movie(rank, name, date, audi);
                    list.add(movie);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            MovieAdapter movieAdapter = new MovieAdapter();
            milist.setAdapter(movieAdapter);
            milist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                    builder.setTitle("상영 정보");
                    builder.setMessage("개봉일 :  "+list.get(position).getOpenDt()+"  "+"예매하시겠습니까?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),Booking.class);
                            intent.putExtra("str","예매 페이지");
                            startActivity(intent);

                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
                    builder.show();
                }
            });

        }
    }

    class MovieAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View miView = null;
            LayoutInflater inflater= (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            miView = inflater.inflate(R.layout.list_item,mlayout,true);

            TextView txrank = miView.findViewById(R.id.txrank);
            TextView txname = miView.findViewById(R.id.txname);
            TextView txaudi = miView.findViewById(R.id.txaudi);

            txrank.setText("박스오피스 순위 :  "+list.get(position).getRank()+" 위");
            txname.setText("영화 제목 :  "+list.get(position).getMovieNm()+" ");
            txaudi.setText("누적 관객수 :  "+list.get(position).getAudiAcc()+" 명");

            return miView;
        }
    }



}
