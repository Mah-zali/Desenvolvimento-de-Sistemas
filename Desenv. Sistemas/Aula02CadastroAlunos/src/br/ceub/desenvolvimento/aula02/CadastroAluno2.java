package br.ceub.desenvolvimento.aula02;
import java.util.ArrayList;
public class CadastroAluno2 {
 private ArrayList<Aluno> alunos = new ArrayList<>();
 public void adicionar(Aluno aluno) {
 alunos.add(aluno);
 }
 public String listarTodos() {
 if (alunos.isEmpty()) {
 return "Nenhum aluno cadastrado.";
 }
 String resultado = "";
 for (Aluno aluno : alunos) {
 resultado += aluno.gerarResumo() + "\n";
 }
 return resultado;
 }
 public Aluno buscarPorNome(String nome) {
 for (Aluno aluno : alunos) {
 if (aluno.getNome().equalsIgnoreCase(nome)) {
 return aluno;
 }
 }
 return null;
 }
 public String buscarPorSemestre(int semestre) {

     String resultado = "";

     for (Aluno aluno : alunos) {

         if (aluno.getSemestre() == semestre) {
             resultado += aluno.gerarResumo() + "\n";
         }
     }

     if (resultado.isEmpty()) {
         return "Nenhum aluno encontrado no " + semestre + "º semestre.";
     }

     return resultado;
 }
 public int quantidade() {
 return alunos.size();
 }
}
