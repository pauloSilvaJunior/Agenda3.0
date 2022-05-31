package alura.com.br.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import alura.com.br.agenda.R;
import alura.com.br.agenda.dao.AlunoDAO;
import alura.com.br.agenda.modelo.Aluno;

public class FormularioAluno extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    final private AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        //pegando referencia do nosso botão.
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        //identificando o click do botão com setOnClickListener e implementando o metodo onClick atraves de classe anonima.
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno alunoCriado = criaAluno();
                salva(alunoCriado);
            }
        });
    }

    private void inicializacaoDosCampos() {
        //Pegando a referencia das EditText.
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salva(Aluno alunoCriado) {
        dao.salva(alunoCriado);
        finish();
    }

    @NonNull
    private Aluno criaAluno() {
        //usando o metodo getText que devolve um editable e para usarmos o texto toString.
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        //Apos criar a classe aluno teremos referenciamos ela a baixo.
        Aluno alunoCriado = new Aluno(nome, telefone, email);
        return alunoCriado;
    }
}