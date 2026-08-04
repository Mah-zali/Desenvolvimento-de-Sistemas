package br.ceub.desenvolvimento.aula02;
import javax.swing.JOptionPane;
public class Principal {
 public static void main(String[] args) {
 CadastroAluno2 cadastro = new CadastroAluno2();
 int opcao = -1;
 while (opcao != 0) {
 String menu = "1 - Cadastrar aluno\n"
 + "2 - Listar alunos\n"
 + "3 - Buscar aluno por nome\n"
 + "4 - Buscar alunos por semestre\n"
 + "0 - Sair";
 opcao = lerInteiro(menu, 0, 4);
 if (opcao == 1) {
 String nome = lerTextoObrigatorio("Nome do aluno:");
 String curso = lerTextoObrigatorio("Curso:");
 int semestre = lerInteiro("Semestre:", 1, 10);
 Aluno aluno = new Aluno(nome, semestre, curso);
 cadastro.adicionar(aluno);
 mostrar("Aluno cadastrado com sucesso.");
 } else if (opcao == 2) {
 mostrar(cadastro.listarTodos());
 } else if (opcao == 3) {
 String nomeBusca = lerTextoObrigatorio("Nome para busca:");
 Aluno encontrado = cadastro.buscarPorNome(nomeBusca);
 if (encontrado == null) {
 mostrar("Aluno nao encontrado.");
 } else {
 mostrar(encontrado.gerarResumo());
 }
 } else if (opcao == 4) {

     int semestreBusca = lerInteiro(
             "Digite o semestre para busca:",
             1,
             10
     );

     mostrar(cadastro.buscarPorSemestre(semestreBusca));
 }
 }
 mostrar("Programa encerrado. Total de alunos: " + cadastro.quantidade());
 }
 private static String lerTextoObrigatorio(String mensagem) {
 String texto = "";
 while (texto == null || texto.trim().isEmpty()) {
 texto = JOptionPane.showInputDialog(mensagem);
 if (texto == null || texto.trim().isEmpty()) {
 mostrar("Campo obrigatorio.");
 }
 }
 return texto.trim();
 }
 private static int lerInteiro(String mensagem, int minimo, int maximo) {
 while (true) {
 try {
 String entrada = JOptionPane.showInputDialog(mensagem);
 int numero = Integer.parseInt(entrada);
 if (numero >= minimo && numero <= maximo) {
 return numero;
 }
 mostrar("Digite um numero entre " + minimo + " e " + maximo + ".");
 } catch (NumberFormatException erro) {
 mostrar("Digite apenas numeros.");
 }
 }
 }
 private static void mostrar(String mensagem) {
 JOptionPane.showMessageDialog(null, mensagem);
 }
}
