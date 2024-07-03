package com.example.listadetarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText meuTexto;
    private ListView minhaLista;
    private Button meuBotao;

    private SQLiteDatabase bancoDados;

    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<Integer> ids;
    private ArrayList<String> itens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuTexto = findViewById(R.id.meuTexto);
        minhaLista = findViewById(R.id.minhaLista);
        meuBotao = findViewById(R.id.meuBotao);

        carregaTarefas();

        minhaLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                alertaApagaTarefa(i);

                return false;
            }
        });

        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNovaTarefa(meuTexto.getText().toString());
            }


        });
    }

    private void carregaTarefas(){
        try {

            bancoDados = openOrCreateDatabase("ToDoList", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS minhastarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

//            String novaTarefa = meuTexto.getText().toString();
//            bancoDados.execSQL("INSERT INTO minhastarefas(tarefa) VALUES('"+novaTarefa+"')");

            Cursor cursor = bancoDados.rawQuery("SELECT * FROM minhastarefas ORDER BY id DESC", null);

            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            itens = new ArrayList<String >();
            ids = new ArrayList<Integer>();

            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    itens);

            minhaLista.setAdapter(itensAdaptador);

            cursor.moveToFirst();
            while (cursor != null){
                Log.i("logx", "ID: " + cursor.getString(indiceColunaId) + "Tarefa: " + cursor.getString(indiceColunaTarefa));
                itens.add(cursor.getString(indiceColunaTarefa));
                ids.add(Integer.parseInt(cursor.getString(indiceColunaId)));

                cursor.moveToNext();

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



    private void addNovaTarefa( String novaTarefa){
        try{
            if(novaTarefa.equals("")) {
                Toast.makeText(MainActivity.this, "Insira uma tarefa", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, " Tarefa "+novaTarefa+ " inserida", Toast.LENGTH_SHORT).show();
                meuTexto.setText("");
                bancoDados.execSQL("INSERT INTO minhastarefas(tarefa) VALUES('"+novaTarefa+"')");
                carregaTarefas();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void apagarTarefa(Integer id){

        try {

            bancoDados.execSQL("DELETE FROM minhastarefas WHERE id="+id);
            Toast.makeText(MainActivity.this, " Tarefa removida", Toast.LENGTH_SHORT).show();
            carregaTarefas();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void alertaApagaTarefa(Integer idSelecionado){
        String tarefaSelecionada = itens.get(idSelecionado);
        final Integer numeroId = idSelecionado;

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Aviso!")
                .setMessage("Deseja apagar"+tarefaSelecionada+"tarefa?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        apagarTarefa(ids.get(numeroId));
                    }
                }).setNegativeButton("Não", null).show();

    }

}