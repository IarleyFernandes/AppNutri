package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class activ_tela_avaliacao extends AppCompatActivity {
    private ImageView home, consulta, cronograma, aval;
    private activ_tela_avaliacao.Imagem imagemAtualLigada = Imagem.AVALIACAO;

    private enum Imagem {
        HOME, CONSULTA, CRONOGRAMA, AVALIACAO
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_avaliacao);

        // Inicialize os ImageViews
        home = findViewById(R.id.home);
        consulta = findViewById(R.id.consulta);
        cronograma = findViewById(R.id.cronograma);
        aval = findViewById(R.id.aval);

        // Defina a imagem de consulta como ligada automaticamente ao iniciar
        aval.setImageResource(R.drawable.estrela_ligado); // Mudar a imagem para o estado "ligado"

        // Defina os onClickListeners para as imagens
        home.setOnClickListener(v -> alternarImagem(activ_tela_avaliacao.Imagem.HOME));
        consulta.setOnClickListener(v -> alternarImagem(activ_tela_avaliacao.Imagem.CONSULTA));
        cronograma.setOnClickListener(v -> alternarImagem(activ_tela_avaliacao.Imagem.CRONOGRAMA));
        aval.setOnClickListener(v -> alternarImagem(activ_tela_avaliacao.Imagem.AVALIACAO));
    }
    private void alternarImagem(activ_tela_avaliacao.Imagem imagemSelecionada) {
        if (imagemAtualLigada != null) {
            desativarImagem(imagemAtualLigada);
        }
        ligarImagem(imagemSelecionada);
        imagemAtualLigada = imagemSelecionada;
    }

    private void ligarImagem(activ_tela_avaliacao.Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home_ligado);
                trocarTela(landingPage.class);
                break;
            case CONSULTA:
                consulta.setImageResource(R.drawable.calendario_ligado);
                break;
            case CRONOGRAMA:
                cronograma.setImageResource(R.drawable.tempo_ligado);
                trocarTela(layout_cronograma.class);
                break;
            case AVALIACAO:
                aval.setImageResource(R.drawable.estrela_ligado);
                break;
        }
    }

    private void desativarImagem(activ_tela_avaliacao.Imagem imagem) {
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
