package com.example.applist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chk1,chk2,chk3,chk4;
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);
        txt1 =findViewById(R.id.txt1);
        txt2 =findViewById(R.id.txt2);
        txt3 =findViewById(R.id.txt3);
        txt4 =findViewById(R.id.txt4);
        txt5 =findViewById(R.id.txt5);
        txt6 =findViewById(R.id.txt6);
        txt7 =findViewById(R.id.txt7);
        txt8 =findViewById(R.id.txt8);
        txt9 =findViewById(R.id.txt9);

        chk1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(chk1.isChecked()){
                    txt1.setTextColor(getColor(R.color.chkbackground));
                    txt2.setTextColor(getColor(R.color.chkbackground));
                    txt3.setTextColor(getColor(R.color.chkbackground));
                }else{

                    txt1.setTextColor(getColor(R.color.black));
                    txt2.setTextColor(getColor(R.color.black));
                    txt3.setTextColor(getColor(R.color.black));
                }

            }
        });
        chk2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(chk2.isChecked()){
                    txt1.setTextColor(getColor(R.color.chkbackground));
                    txt2.setTextColor(getColor(R.color.chkbackground));
                    txt3.setTextColor(getColor(R.color.chkbackground));
                }else{

                    txt1.setTextColor(getColor(R.color.black));
                    txt2.setTextColor(getColor(R.color.black));
                    txt3.setTextColor(getColor(R.color.black));
                }

            }
        });
        chk3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(chk3.isChecked()){
                    txt1.setTextColor(getColor(R.color.chkbackground));
                    txt2.setTextColor(getColor(R.color.chkbackground));
                    txt3.setTextColor(getColor(R.color.chkbackground));
                }else{

                    txt1.setTextColor(getColor(R.color.black));
                    txt2.setTextColor(getColor(R.color.black));
                    txt3.setTextColor(getColor(R.color.black));
                }

            }
        });
        chk4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(chk4.isChecked()){
                    chk4.setTextColor(getColor(R.color.chkbackground));
                }else{

                    chk4.setTextColor(getColor(R.color.black));

                }

            }
        });

    }
}