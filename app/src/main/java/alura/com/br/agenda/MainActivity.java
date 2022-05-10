package alura.com.br.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    //Sobrescrevendo metodo onCreate da class Active.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //chamando o método setContentView() enviando a referência do arquivo estático de layout criado.
        setContentView(R.layout.activity_main);

        //Ciando uma lista que ira representar os alunos implementando um ArrayList para isto.
        List<String> alunos = new ArrayList<>(Arrays.asList("Paulo", "Isabela", "Alex"));

        //obtento as views para vincular os dados, usando o metodo findViewById para identificar as views pelo seu Id.
        TextView primeiroAluno = findViewById(R.id.textView);
        TextView segundoAluno = findViewById(R.id.textView2);
        TextView terceiroAluno = findViewById(R.id.textView3);

        //vinculando as views com a lista,
        primeiroAluno.setText(alunos.get(0));
        segundoAluno.setText(alunos.get(1));
        terceiroAluno.setText(alunos.get(2));
    }
}
