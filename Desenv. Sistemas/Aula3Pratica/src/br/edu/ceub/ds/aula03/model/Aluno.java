package br.edu.ceub.ds.aula03.model;

public class Aluno {
    private String nome;
    private int semestre;
    private String curso;

    public Aluno(String nome, int semestre, String curso) {
        this.nome = nome;
        this.semestre = semestre;
        this.curso = curso;
    }

    public String getNome() { return nome; }
    public int getSemestre() { return semestre; }
    public String getCurso() { return curso; }

    public String gerarResumo() {
        return nome + " - " + curso + " - " + semestre + "º semestre";
    }
}
