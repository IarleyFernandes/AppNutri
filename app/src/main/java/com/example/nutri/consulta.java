package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.nutri.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class consulta extends AppCompatActivity {
    private ImageView home, Consulta, cronograma, aval;
    private consulta.Imagem imagemAtualLigada = Imagem.CONSULTA; // Imagem de consulta é a inicial

    private enum Imagem {
        HOME, CONSULTA, CRONOGRAMA, AVALIACAO
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta);

        // Inicialize os ImageViews
        home = findViewById(R.id.home);
        Consulta = findViewById(R.id.Consulta);
        cronograma = findViewById(R.id.cronograma);
        aval = findViewById(R.id.aval);
        // Defina a imagem de consulta como ligada automaticamente ao iniciar
        Consulta.setImageResource(R.drawable.calendario_ligado); // Mudar a imagem para o estado "ligado"

        // Defina os onClickListeners para as imagens
        home.setOnClickListener(v -> alternarImagem(consulta.Imagem.HOME));
        Consulta.setOnClickListener(v -> alternarImagem(consulta.Imagem.CONSULTA));
        cronograma.setOnClickListener(v -> alternarImagem(consulta.Imagem.CRONOGRAMA));
        aval.setOnClickListener(v -> alternarImagem(consulta.Imagem.AVALIACAO));
    }
    private void alternarImagem(consulta.Imagem imagemSelecionada) {
        if (imagemAtualLigada != null) {
            desativarImagem(imagemAtualLigada);
        }
        ligarImagem(imagemSelecionada);
        imagemAtualLigada = imagemSelecionada;
    }

    private void ligarImagem(consulta.Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home_ligado);
                trocarTela(landingPage.class);
                break;
            case CONSULTA:
                Consulta.setImageResource(R.drawable.calendario_ligado);
                break;
            case CRONOGRAMA:
                cronograma.setImageResource(R.drawable.tempo_ligado);
                trocarTela(layout_cronograma.class);
                break;
            case AVALIACAO:
                aval.setImageResource(R.drawable.estrela_ligado);
                trocarTela(activ_tela_avaliacao.class);
                break;
        }
    }

    private void desativarImagem(consulta.Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home);
                break;
            case CONSULTA:
                Consulta.setImageResource(R.drawable.calendario);
                break;
            case CRONOGRAMA:
                cronograma.setImageResource(R.drawable.tempo);
                break;
            case AVALIACAO:
                aval.setImageResource(R.drawable.estrela);
                break;
        }
    }

    // Método genérico para trocar de tela
    private void trocarTela(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}