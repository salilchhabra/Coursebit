package com.example.salil.coursebit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class starting extends AppCompatActivity {
public void register(View view)
{
    Intent intent=new Intent(getApplicationContext(),register.class);
    startActivity(intent);
}
    public void login(View view)
    {
        Intent intent=new Intent(getApplicationContext(),login.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
    }
}
