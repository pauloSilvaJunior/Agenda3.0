package alura.com.br.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import alura.com.br.agenda.modelo.Aluno;

public class AlunoDAO {

    //Criando uma lista statica para salvar os dados.
    private final static List<Aluno> alunos = new ArrayList<>();

    //Quando usado este metodo ele salva na lista,
    //desta maneira teremos acesso aos nossos dados dentrodo app.
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }
    public List<Aluno> todos(){
        return new ArrayList<>(alunos);
    };

}
