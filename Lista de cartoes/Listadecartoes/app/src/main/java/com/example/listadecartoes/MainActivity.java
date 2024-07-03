package com.example.listadecartoes;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    int[] listaIcones = {R.drawable.felpudo,R.drawable.fofura,R.drawable.lesmo,
            R.drawable.bugado,R.drawable.uruca,R.drawable.carrinho,
            R.drawable.ios,R.drawable.android,R.drawable.realidade_aumentada,
            R.drawable.sound_fx,R.drawable.max,R.drawable.games,};

    String[] listaTitulo = {"Felpudo", "Fofura", "Lesmo",
            "Bugado", "Uruca", "Racing",
            "IOS", "Android", "Realidade",
            "Sound FX", "3D Studio Max", "Games"};

    String[] listaDescricao = {"Felpudo descrição", "Fofura descrição", "Lesmo descrição",
            "Bugado descrição", "Uruca descrição", "Racing descrição",
            "IOS descrição", "Android descrição", "Realidade Aumentada descrição",
            "Sound FX descrição", "3D Studio Max descrição", "Games descrição"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayAdapter<String> meuAdaptador = new ArrayAdapter<String>(getApplicationContext(),
//                android.R.layout.simple_list_item_1, android.R.id.text1, listaNomes);
//
//        ListView minhaLista = findViewById(R.id.minhaLista);
//        minhaLista.setAdapter(meuAdaptador);
//
//        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
//                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
//            }
//        });

        ListView minhaLista = findViewById(R.id.minhaLista);

        MeuAdaptador meuAdaptador;
        meuAdaptador = new MeuAdaptador(getApplicationContext(), R.layout.minha_celula);


        for( int i=0; i < listaTitulo.length; i++){
            DadosPersonagem dadosPersonagem;
            dadosPersonagem = new DadosPersonagem(listaIcones[i], listaTitulo[i], listaDescricao[i]);
            meuAdaptador.add(dadosPersonagem);

        }

        minhaLista.setAdapter(meuAdaptador);

        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
               // Toast.makeText(MainActivity.this, " "+listaTitulo[i], Toast.LENGTH_SHORT).show();
                DadosPersonagem dadosPersonagem;
                dadosPersonagem = (DadosPersonagem) meuAdaptador.getItem(i);

                criaAlerta(dadosPersonagem);
            }
        });
    }

    void criaAlerta(DadosPersonagem dadosPersonagem){
        AlertDialog.Builder meuAlerta;
        meuAlerta = new AlertDialog.Builder(MainActivity.this);

        meuAlerta.setTitle(dadosPersonagem.getTitulo());
        meuAlerta.setMessage(dadosPersonagem.getDescricao());

        meuAlerta.setCancelable(true);
        meuAlerta.setIcon(dadosPersonagem.getIcone());

        meuAlerta.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Confirma!!", Toast.LENGTH_SHORT).show();
            }
        });

        meuAlerta.create();
        meuAlerta.show();

    }
}

class ViewPersonagem{
    ImageView icone;
    TextView titulo;
    TextView descricao;
}

class DadosPersonagem{
    private final int icone;
    private final String titulo;
    private final String descricao;

    public DadosPersonagem(int icone, String titulo, String descricao) {
        this.icone = icone;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getIcone() {
        return icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}

class MeuAdaptador extends ArrayAdapter{

    public MeuAdaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View minhaView;
        minhaView = convertView;
        ViewPersonagem viewPersonagem;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.minha_celula, parent, false);

            viewPersonagem = new ViewPersonagem();
            viewPersonagem.icone = (ImageView) minhaView.findViewById(R.id.meuIcone);
            viewPersonagem.titulo = (TextView) minhaView.findViewById(R.id.meuTitulo);
            viewPersonagem.descricao = (TextView) minhaView.findViewById(R.id.meuDescricao);

            minhaView.setTag(viewPersonagem);

        }else {
            viewPersonagem = (ViewPersonagem) minhaView.getTag();
        }

        DadosPersonagem dadosPersonagem;
        dadosPersonagem = (DadosPersonagem) this.getItem(position);

        viewPersonagem.icone.setImageResource(dadosPersonagem.getIcone());
        viewPersonagem.titulo.setText(dadosPersonagem.getTitulo());
        viewPersonagem.descricao.setText(dadosPersonagem.getDescricao());

        return minhaView;
    }
}