package com.fju.water;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
EditText ed_month;
EditText ed_next;
Button ok;
int monthNum;
int nextNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    ed_month = findViewById(R.id.month);
    ed_next = findViewById(R.id.next);
    }
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            ed_month.setText("");
            ed_next.setText("");
        }
    };
    public void check(View view){
        String month = ed_month.getText().toString();
        String next = ed_next.getText().toString();
       double price=0;
        if(!TextUtils.isEmpty(month)){
            monthNum = Integer.valueOf(month);
            if(1<=monthNum&&monthNum<=10){
             price = monthNum*7.35;
            }if(11<=monthNum&&monthNum<=30){
                price = monthNum*9.45-24;
            }if(31<=monthNum&&monthNum<=50){
                price = monthNum*11.55-84;
            }if(monthNum>=51) {
                price = monthNum * 12.075-110.25;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("水費是: "+price)
                    .setTitle("計算結果")
                    .setPositiveButton("OK",listener)
                    .show();
        }else if(TextUtils.isEmpty(month)&&!TextUtils.isEmpty(next)){
            nextNum = Integer.valueOf(next);
            if(1<=nextNum&&nextNum<=20){
         price = monthNum*7.35;
            }if(21<=nextNum&&nextNum<=60){
                price = monthNum*9.45-42;
            }if(61<=nextNum&&nextNum<=100){
                price = monthNum*11.55-168;
            }if(nextNum>=101){
                price = monthNum*12.075-220.5;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("水費是: "+price)
                    .setTitle("計算結果")
                    .setPositiveButton("OK",listener)
                    .show();
        }else if (TextUtils.isEmpty(month)&&TextUtils.isEmpty(next)) {
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("無法計算")
                    .setTitle("警告")
                    .setPositiveButton("OK", null)
                    .show();

        }

    }
}
