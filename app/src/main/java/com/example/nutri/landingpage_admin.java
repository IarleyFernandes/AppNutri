package com.example.nutri;

import android.annotation.SuppressLint;
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

public class landingpage_admin extends AppCompatActivity {

    private ImageView home, consulta, agenda;
    private landingpage_admin.Imagem imagemAtualLigada = landingpage_admin.Imagem.HOME; // Enum para controle do estado da imagem
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private enum Imagem {
        HOME, CONSULTA, AGENDA
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_landingpage_admin);


        // Configurar a Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar o DrawerLayout e o NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Configurar o botão de menu na Toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        // Lidar com cliques nos itens do NavigationView
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_edit) {
                mostrarMensagem("Editar selecionado");
                trocarTela(editar_perfil.class);
            } else if (itemId == R.id.nav_money) {
                mostrarMensagem("Financeiro selecionado");
            } else if (itemId == R.id.nav_notifications) {
                mostrarMensagem("Notificações selecionadas");
            } else if (itemId == R.id.nav_logout) {
                mostrarMensagem("Sair selecionado");
                trocarTela(MainActivity.class);
                finish();
            }

            // Fechar o menu após a seleção
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // Inicialize os ImageViews
        home = findViewById(R.id.home);
        consulta = findViewById(R.id.consulta);
        agenda = findViewById(R.id.agenda);

        // Defina os onClickListeners para as imagens
        home.setOnClickListener(v -> alternarImagem(landingpage_admin.Imagem.HOME));
        consulta.setOnClickListener(v -> alternarImagem(landingpage_admin.Imagem.CONSULTA));
        agenda.setOnClickListener(v -> alternarImagem(landingpage_admin.Imagem.AGENDA));
    }

    private void alternarImagem(landingpage_admin.Imagem imagemSelecionada) {
        if (imagemAtualLigada != null) {
            desativarImagem(imagemAtualLigada);
        }
        ligarImagem(imagemSelecionada);
        imagemAtualLigada = imagemSelecionada;
    }

    private void ligarImagem(landingpage_admin.Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home_ligado);
                break;
            case CONSULTA:
                consulta.setImageResource(R.drawable.calendario_ligado);
                trocarTela(activ_mypacientes.class);
                break;
            case AGENDA:
                agenda.setImageResource(R.drawable.agenda_ligado);
                trocarTela(Agenda.class);
                break;
        }
    }

    private void desativarImagem(landingpage_admin.Imagem imagem) {
        switch (imagem) {
            case HOME:
                home.setImageResource(R.drawable.botao_home);
                break;
            case CONSULTA:
                consulta.setImageResource(R.drawable.calendario);
                break;
            case AGENDA:
                agenda.setImageResource(R.drawable.agenda);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // Fechar o menu lateral se estiver aberto ao pressionar "voltar"
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Método genérico para trocar de tela
    private void trocarTela(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    // Método para exibir mensagens
    private void mostrarMensagem(String mensagem) {
        Snackbar.make(drawerLayout, mensagem, Snackbar.LENGTH_SHORT).show();
    }
}
