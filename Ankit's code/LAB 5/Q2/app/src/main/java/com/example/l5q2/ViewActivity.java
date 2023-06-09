package com.example.l5q2;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity
{
    TextView tvSrc;
    TextView tvDst;
    TextView tvDate;
    TextView tvType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Intent i = getIntent();
        String src = getResources().getStringArray(R.array.places)[i.getIntExtra("src", 0)];
        String dst = getResources().getStringArray(R.array.places)[i.getIntExtra("dst", 0)];
        String date = i.getStringExtra("date");
        String type = !i.getBooleanExtra("type", false) ? "One way": "Return";

        tvType = findViewById(R.id.tv_type);
        tvSrc = findViewById(R.id.tv_src);
        tvDst = findViewById(R.id.tv_dst);
        tvDate = findViewById(R.id.tv_date);

        tvDate.append(date);
        tvDst.append(dst);
        tvSrc.append(src);
        tvType.append(type);
    }
}