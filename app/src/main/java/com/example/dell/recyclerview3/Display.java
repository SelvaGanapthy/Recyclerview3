package com.example.dell.recyclerview3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        t1=(TextView)findViewById(R.id.t1);
        Intent i=getIntent();
        String s=i.getStringExtra("pos");
        t1.setText(""+s);
    }
}
