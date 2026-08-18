package br.edu.ceub.ds.aula04.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ceub.ds.aula04.model.Aluno;

public class CadastroAlunos {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos);
    }

    public Aluno buscarPorNome(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
    public int contarAlunos() {
        return alunos.size();
    }
}
