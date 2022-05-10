package alura.com.br.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        List<String> alunos = new ArrayList<>(Arrays.asList("Paulo", "Isabela", "Alex", "Kennan", "Kimberly"));

        //Utilizando o componente ListView para implementar a lista de alunos no layout.
        ListView listaDeAlunos = findViewById(R.id.ativity_main_lista_de_alunos);

        //Array Adapter faz esta implementação envia os argumentos via construtor, e ele já consegue fazer o vínculo dos dados
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));

    }
}
