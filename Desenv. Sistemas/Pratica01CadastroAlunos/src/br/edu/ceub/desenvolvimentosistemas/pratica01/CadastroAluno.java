package br.edu.ceub.desenvolvimentosistemas.pratica01;
import javax.swing.JOptionPane;
public class CadastroAluno {
 public static void main(String[] args) {
 Aluno aluno1 = new Aluno("Maria","Ciencia da computação", 7);
 Aluno aluno2 = new Aluno("Lucas","Analise de sistemas", 3);
 Aluno aluno3 = new Aluno("Mateus","Engenharia de Software",8);
 System.out.println(aluno1.resumo());
 System.out.println(aluno2.resumo());
 System.out.println(aluno3.resumo());
 String mensagem = aluno1.resumo()
		 + "\n" + aluno2.resumo()
		 + "\n" + aluno3.resumo();
		JOptionPane.showMessageDialog(
		 null,
		 mensagem,
		 "Cadastro de alunos",
		 JOptionPane.INFORMATION_MESSAGE
		);
 }
}