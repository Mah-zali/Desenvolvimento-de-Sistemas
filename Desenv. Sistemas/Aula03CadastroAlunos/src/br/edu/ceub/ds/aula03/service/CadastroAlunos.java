package br.edu.ceub.ds.aula03.service;

import java.util.ArrayList;
import java.util.List;
import br.edu.ceub.ds.aula03.model.Aluno;

public class CadastroAlunos {
    private List<Aluno> alunos = new ArrayList<>();

    public boolean adicionar(Aluno aluno) {

        if (!semestreValido(aluno.getSemestre())) {
            return false;
        }

        if (nomeDuplicado(aluno.getNome())) {
            return false;
        }

        alunos.add(aluno);
        return true;
    }

    public boolean semestreValido(int semestre) {

        return semestre >= 1 && semestre <= 10;
    }

    public boolean nomeDuplicado(String nome) {

        for (Aluno aluno : alunos) {

            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }

        return false;
    }

    public List<Aluno> listarTodos() {
        return alunos;
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