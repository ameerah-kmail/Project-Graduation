

package com.example.a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adas);
    }

    public void next_acc(View v){
        Intent intent=new Intent(adas.this,acc.class);
        startActivity( intent );
    }

    public void  adas_To_manual(View v){
        Intent intent=new Intent(adas.this,MainActivity.class);
        startActivity( intent );
    }


}

