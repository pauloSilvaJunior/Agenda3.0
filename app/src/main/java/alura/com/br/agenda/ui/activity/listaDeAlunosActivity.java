package alura.com.br.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.com.br.agenda.R;
import alura.com.br.agenda.dao.AlunoDAO;

public class listaDeAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    final private AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        //chamando o método setContentView() enviando a referência do arquivo estático de layout criado.
        setContentView(R.layout.activity_lista_de_alunos);
        FloatingActionButton botaoNovoAluno = findViewById(R.id.active_lista_de_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAluno.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        //Utilizando o componente ListView para implementar a lista de alunos no layout.
        ListView listaDeAlunos = findViewById(R.id.ativity_main_lista_de_alunos);

        //Array Adapter faz esta implementação envia os argumentos via construtor, e ele já consegue fazer o vínculo dos dados
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
