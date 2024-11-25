package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class esqueci_senha_3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.esqueci_senha_3);
    }
    public void esqueci2(View view) {
        Intent troca_tela = new Intent(this, MainActivity.class);
        startActivity(troca_tela);

    }
}