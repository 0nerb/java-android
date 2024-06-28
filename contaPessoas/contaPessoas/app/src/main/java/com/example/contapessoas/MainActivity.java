package com.example.contapessoas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numeroHomem = 0;
    int numeroMulher = 0;
    int numeroPessoas= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView campoTexto = (TextView) findViewById(R.id.textoPessoas);

        final Button botaoHomem = (Button) findViewById(R.id.botaoHomem);
        final Button botaoMulher = (Button) findViewById(R.id.botaoMulher);
        final Button botaoReset = (Button) findViewById(R.id.botaoReset);

        botaoHomem.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                numeroHomem++;
                numeroPessoas++;
                String mensagem = Integer.toString(numeroPessoas);
                campoTexto.setText("Total: " + mensagem + " pessoas");
                botaoHomem.setText(Integer.toString(numeroHomem));

            }
        });
        botaoMulher.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                numeroMulher++;
                numeroPessoas++;

                String mensagem = Integer.toString(numeroPessoas);
                campoTexto.setText("Total: " + mensagem + " pessoas");
                botaoMulher.setText(Integer.toString(numeroMulher));
            }
        });

        botaoReset.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                numeroPessoas = 0;
                numeroMulher = 0;
                numeroHomem = 0;

                String mensagem = Integer.toString(numeroPessoas);
                campoTexto.setText("Total: "+ mensagem + " pessoas");
                botaoHomem.setText(Integer.toString(numeroHomem));
                botaoMulher.setText(Integer.toString(numeroMulher));

            }
        });

    }
}