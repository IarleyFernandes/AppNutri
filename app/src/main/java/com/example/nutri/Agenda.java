package com.example.nutri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Agenda extends AppCompatActivity {

    private ImageView home, consulta, agenda;
    private Imagem imagemAtualLigada = Imagem.AGENDA; // A imagem de agenda é a inicial

    private enum Imagem {
        HOME, CONSULTA, AGENDA
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agenda);

        // Configuração do Spinner de datas
        configurarSpinner();

        // Configuração das imagens para navegação
        configurarNavegacao();
    }

    private void configurarSpinner() {
        // Localizar o Spinner no layout
        Spinner spinner = findViewById(R.id.spinner_dates);

        // Gerar lista de datas
        List<String> dateList = generateDateList();

        // Configurar o ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                dateList
        );

        // Definir o layout para o dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associar o adapter ao Spinner
        spinner.setAdapter(adapter);
    }

    private List<String> generateDateList() {
        List<String> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        // Adicionar 7 dias à lista (ou quantos forem necessários)
        for (int i = 0; i < 7; i++) {
            dateList.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dateList;
    }

    private void configurarNavegacao() {
        // Inicialize os ImageViews
        home = findViewById(R.id.home);
        consulta = findViewById(R.id.consulta);
        agenda = findViewById(R.id.agenda);

        // Defina a imagem de agenda como ligada automaticamente ao iniciar
        agenda.setImageResource(R.drawable.tempo_ligado);

        // Defina os onClickListeners para as imagens
        home.setOnClickListener(v -> alternarImagem(Imagem.HOME));
        consulta.setOnClickListener(v -> alternarImagem(Imagem.CONSULTA));
        agenda.setOnClickListener(v -> alternarImagem(Imagem.AGENDA));
    }

    private void alternarImagem(Imagem imagemSelecionada) {
        if (imagemAtualLigada != null) {
            desativarImagem(imagemAtualLigada);
        }
        ligarImagem(imagemSelecionada);
        imagemAtualLigada = imagemSelecionada;
    }

    private void ligarImagem(Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home_ligado);
                trocarTela(landingpage_admin.class);
                break;
            case CONSULTA:
                consulta.setImageResource(R.drawable.calendario_ligado);
                trocarTela(activ_mypacientes.class);
                break;
            case AGENDA:
                agenda.setImageResource(R.drawable.tempo_ligado);
                break;
        }
    }

    private void desativarImagem(Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home);
                break;
            case CONSULTA:
                consulta.setImageResource(R.drawable.calendario);
                break;
            case AGENDA:
                agenda.setImageResource(R.drawable.tempo);
                break;
        }
    }

    // Método genérico para trocar de tela
    private void trocarTela(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
