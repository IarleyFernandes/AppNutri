package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class esqueci_senha_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.esqueci_senha_2);
    }
    public void esqueci(View view) {
        Intent troca_tela = new Intent(this, esqueci_senha_3.class);
        startActivity(troca_tela);
    }
}
