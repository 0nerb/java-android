package com.example.quizz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private TextView textoPergunta;
    private RadioGroup radioGroup;

    private RadioButton opcaoA;
    private RadioButton opcaoB;
    private RadioButton opcaoC;

    private Button botaoOk;

    String Perguntas[] = {"Primeira pergunta?",
                "Segunda pergunta?",
                "Terceira pergunta?",
                "Quarta pergunta?",
                "Quinta pergunta?"};

    String OpcaoA[] = {"Resposta A Primeira pergunta?",
            "Resposta A Segunda pergunta?",
            "Resposta A Terceira pergunta?",
            "Resposta A Quarta pergunta?",
            "Resposta A Quinta pergunta?"};

    String OpcaoB[] = {"Resposta B Primeira pergunta?",
            "Resposta B Segunda pergunta?",
            "Resposta B Terceira pergunta?",
            "Resposta B Quarta pergunta?",
            "Resposta B Quinta pergunta?"};

    String OpcaoC[] = {"Resposta C Primeira pergunta?",
            "Resposta C Segunda pergunta?",
            "Resposta C Terceira pergunta?",
            "Resposta C Quarta pergunta?",
            "Resposta C Quinta pergunta?"};

    int[] listaRespostas = new int [Perguntas.length];
    int listaGabarito[] = {1,2,3,1,2};
    int respostasCorretas = 0;
    int numeroPergunta = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoOk = findViewById(R.id.button);
        botaoOk.setEnabled(false);

        textoPergunta = findViewById(R.id.campoTexto);



        opcaoA = findViewById(R.id.opcaoA);
        opcaoB = findViewById(R.id.opcaoB);
        opcaoC = findViewById(R.id.opcaoC);





        radioGroup = findViewById(R.id.grupoRadio);
        clicaOk(botaoOk);

        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group,int checkdId ){
                if(checkdId == R.id.opcaoA){
                    Log.d("s", "Opção 1");
                    listaRespostas[numeroPergunta - 1] = 1;
                }
                else if(checkdId == R.id.opcaoB){
                    Log.d("s", "Opção 2");
                    listaRespostas[numeroPergunta - 1] = 2;
                }
                else if(checkdId == R.id.opcaoC){
                    Log.d("s", "Opção 3");
                    listaRespostas[numeroPergunta - 1] = 3;
                }
                botaoOk.setEnabled(true);

            }


        });

    }

    public void clicaOk(View view){

        if(numeroPergunta == Perguntas.length) {
            opcaoA.setEnabled(false);
            opcaoB.setEnabled(false);
            opcaoC.setEnabled(false);
            radioGroup.clearCheck();
            confereResultado();
        }else {
            textoPergunta.setText(Perguntas[numeroPergunta]);

            opcaoA.setText(OpcaoA[numeroPergunta]);
            opcaoB.setText(OpcaoB[numeroPergunta]);
            opcaoC.setText(OpcaoC[numeroPergunta]);

            numeroPergunta++;
            botaoOk.setEnabled(false);
            radioGroup.clearCheck();
        }

    }

    public void confereResultado(){
        int contadorLista = 0;
        for (int numero : listaRespostas) {
            System.out.println(numero);
            if(numero == listaGabarito[contadorLista]){
                respostasCorretas++;
                System.out.println("Resposta correta!!");
            }else{
                System.out.println("Resposta errada!!");
            }
            contadorLista++;
        }
        alertaResultado(botaoOk);
    }

    public void alertaResultado(View view){
        AlertDialog alertDialogl;
        alertDialogl = new AlertDialog.Builder(this).create();
        alertDialogl.setTitle("Resultado");
        alertDialogl.setMessage("Você acertou "+respostasCorretas+" perguntas!");
        alertDialogl.show();
        botaoOk.setEnabled(false);
    }


}