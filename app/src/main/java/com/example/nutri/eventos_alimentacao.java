package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class eventos_alimentacao extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.eventos_alimentacao);
    }
    public void voltar(View view){
        Intent troca_tela = new Intent(this,landingPage.class);
        startActivity(troca_tela);
    }


}