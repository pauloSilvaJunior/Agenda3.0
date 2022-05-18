package alura.com.br.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import alura.com.br.agenda.R;
import alura.com.br.agenda.modelo.Aluno;

public class FormularioAluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        //Pegando a referencia das EditText.
        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);

        //pegando referencia do nosso botão.
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);

        //identificando o click do botão com setOnClickListener e implementando o metodo onClick atraves de classe anonima.
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //usando o metodo getText que devolve um editle e para usarmos o texto toString.
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                //Apos criar a classe aluno teremos referenciamos ela a baixo.
                Aluno alunoCriado = new Aluno(nome, telefone, email);

                Toast.makeText(FormularioAluno.this, alunoCriado.getNome() +
                        " - " + alunoCriado.getTelefone() +
                        " - " + alunoCriado.getEmail() , Toast.LENGTH_SHORT).show();

            }
        });
    }
}