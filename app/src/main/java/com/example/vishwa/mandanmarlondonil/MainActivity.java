package com.example.vishwa.mandanmarlondonil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Button btn_try = (Button) findViewById(R.id.btn_try_again);

        btn_try.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                startActivity(getIntent());
            }
        });

        boolean isConnected = Utill.checkConnectivity(getApplicationContext());
        if (isConnected == false) {


            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

            TextView myMsg = new TextView(this);
            myMsg.setText("Please connect to the internet" +"\n" + "and try again!");
            myMsg.setTextSize(20);
            myMsg.setTextColor(ContextCompat.getColor(this, R.color.white));

            myMsg.setGravity(Gravity.CENTER);
            myMsg.setPadding(0,80,0,0);
            builder1.setView(myMsg);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            btn_try.setVisibility(View.VISIBLE);
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();

            return;

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent (MainActivity.this, WebViewActivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIME_OUT);



    }
}
