package com.example.nutri;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.nutri.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class layout_cronograma extends AppCompatActivity {

    private ImageView home, consulta, cronograma, aval;
    private layout_cronograma.Imagem imagemAtualLigada = Imagem.CRONOGRAMA; // Imagem de consulta é a inicial

    private enum Imagem {
        HOME, CONSULTA, CRONOGRAMA, AVALIACAO
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_cronograma);

        // Inicialize os ImageViews
        home = findViewById(R.id.home);
        consulta = findViewById(R.id.consulta);
        cronograma = findViewById(R.id.cronograma);
        aval = findViewById(R.id.aval);

        // Defina a imagem de consulta como ligada automaticamente ao iniciar
        cronograma.setImageResource(R.drawable.tempo_ligado); // Mudar a imagem para o estado "ligado"

        // Defina os onClickListeners para as imagens
        home.setOnClickListener(v -> alternarImagem(layout_cronograma.Imagem.HOME));
        consulta.setOnClickListener(v -> alternarImagem(layout_cronograma.Imagem.CONSULTA));
        cronograma.setOnClickListener(v -> alternarImagem(layout_cronograma.Imagem.CRONOGRAMA));
        aval.setOnClickListener(v -> alternarImagem(layout_cronograma.Imagem.AVALIACAO));
    }
    private void alternarImagem(layout_cronograma.Imagem imagemSelecionada) {
        if (imagemAtualLigada != null) {
            desativarImagem(imagemAtualLigada);
        }
        ligarImagem(imagemSelecionada);
        imagemAtualLigada = imagemSelecionada;
    }

    private void ligarImagem(layout_cronograma.Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home_ligado);
                trocarTela(landingPage.class);
                break;
            case CONSULTA:
                consulta.setImageResource(R.drawable.calendario_ligado); // Deixa a imagem de consulta ligada
                break;
            case CRONOGRAMA:
                cronograma.setImageResource(R.drawable.tempo_ligado);
                break;
            case AVALIACAO:
                aval.setImageResource(R.drawable.estrela_ligado);
                trocarTela(activ_tela_avaliacao.class);
                break;
        }
    }

    private void desativarImagem(layout_cronograma.Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home);
                break;
            case CONSULTA:
                consulta.setImageResource(R.drawable.calendario);
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
