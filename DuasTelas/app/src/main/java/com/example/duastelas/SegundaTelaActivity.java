package com.example.duastelas;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaTelaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela_activity);

        ImageView icone = findViewById(R.id.iconeSegundaTela);
        TextView nome = findViewById(R.id.tituloSegundaTela);
        TextView descricao = findViewById(R.id.descricaoSegundaTela);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String txtNome = extras.getString("nome");
            String txtDescricao = extras.getString("descricao");
            int iconeid = extras.getInt("icone");

            icone.setImageResource(iconeid);
            nome.setText(txtNome);
            descricao.setText(txtDescricao);
        }

    }
}
