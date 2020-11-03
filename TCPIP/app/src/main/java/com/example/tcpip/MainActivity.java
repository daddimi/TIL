package com.example.tcpip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.msg.Msg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView tx_list, tx_msg;
    EditText et_ip, et_msg;

    int port;
    String address;
    String id;
    Socket socket;
    Sender sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx_list = findViewById(R.id.tx_list);
        tx_msg = findViewById(R.id.tx_msg);
        et_ip = findViewById(R.id.et_ip);
        et_msg = findViewById(R.id.et_msg);

        port = 5555;
        address = "192.168.0.24";
        id = "[yeah]";
        new Thread(con).start();
        //getList();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            Msg msg = new Msg(null,id,"q");
            sender.setMsg(msg);
            new Thread(sender).start();
            if (socket != null) {
                socket.close();
            }
            finish();
            onDestroy();
        } catch (Exception e) {

        }
    }

    Runnable con  = new Runnable() {
        @Override
        public void run() {
            try {
                connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public void connect() throws IOException  {
        try {
            socket = new Socket(address, port);
        } catch (Exception e) {
            while(true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                System.out.println("Retry..");
                try {
                    socket = new Socket(address, port);
                    break;
                } catch (Exception e1) {
                    System.out.println("Retry...");
                }
            }
        }

        System.out.println("Connected Server: "+address);
        sender = new Sender(socket);
        new Receiver(socket).start();
        getList();
    }

    private void getList() {
        Msg msg = new Msg(null,"[yeah]","1");
        sender.setMsg(msg);
        new Thread(sender).start();
    }

    public void clickBt(View v) {
        String txip = et_ip.getText().toString();
        String txmsg = et_msg.getText().toString();
        Msg msg = null;
        if(txip == null || txip.equals("")) {
            msg = new Msg(id, txmsg);
        } else {
            ArrayList<String> ips = new ArrayList<>();
            ips.add(txip);
            msg = new Msg(ips,id,txmsg);
        }
        sender.setMsg(msg);
        new Thread(sender).start();

    }


    class Receiver extends Thread {
        ObjectInputStream oi;
        public Receiver(Socket socket) throws IOException {
            oi = new ObjectInputStream(socket.getInputStream());
        }
        @Override
        public void run() {
            while(oi != null) {
                Msg msg = null;
                try {
                    msg = (Msg) oi.readObject();
                    if(msg.getMaps() != null) {
                        HashMap<String,Msg> hm = msg.getMaps();
                        Set<String> keys = hm.keySet();
                        for(String k:keys) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String tx = tx_list.getText().toString();
                                    tx_list.setText(tx+k+"\n");
                                }
                            });
                            System.out.println(k);
                        }
                        continue;
                    }
                    final Msg finalMsg = msg;
                    Log.d("------------------------",finalMsg.getMsg());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String tx = tx_msg.getText().toString();
                            tx_msg.setText(tx+finalMsg.getId()+ finalMsg.getMsg()+"\n");
                        }
                    });
                    System.out.println(msg.getId()+msg.getMsg());
                } catch(Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
            try {
                if(oi != null) {
                    oi.close();
                }
                if(socket != null) {
                    socket.close();
                }
            } catch(Exception e) {

            }
        }


    }

    class Sender implements Runnable{
        Socket socket;
        ObjectOutputStream oo;
        Msg msg;
        public Sender(Socket socket) throws IOException {
            this.socket = socket;
            oo = new ObjectOutputStream(socket.getOutputStream());
        }
        public void setMsg(Msg msg) {
            this.msg = msg;
        }
        @Override
        public void run() {
            if(oo != null) {
                try {
                    oo.writeObject(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        if(socket != null) {
                            socket.close();
                        }
                    } catch(Exception e1) {
                        e1.printStackTrace();
                    }

                    try {
                        Thread.sleep(2000);
                        connect();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

    }

}