package br.edu.ceub.desenvolvimentosistemas.pratica01;
public class Aluno {
 private String nome;
 private String curso;
 private int semestre;
 public Aluno(String nome, String curso, int semestre) {
 this.nome = nome;
 this.semestre = semestre;
 this.curso = curso;
 }
 public String getNome() {
 return nome;
 }
 public String getCurso() {
 return curso;	 
 }
 public int getSemestre() {
 return semestre;
 }
 public String resumo() {
 return nome + " - " + curso + " - " + semestre + "º semestre";
 }
}