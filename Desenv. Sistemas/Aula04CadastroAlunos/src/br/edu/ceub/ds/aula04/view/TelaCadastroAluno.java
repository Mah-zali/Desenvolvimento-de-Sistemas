package br.edu.ceub.ds.aula04.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import br.edu.ceub.ds.aula04.model.Aluno;
import br.edu.ceub.ds.aula04.service.CadastroAlunos;

public class TelaCadastroAluno extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField campoNome;
    private JTextField campoCurso;
    private JTextField campoSemestre;
    private JTextArea areaResultado;
    private CadastroAlunos cadastro;

    public TelaCadastroAluno() {
        cadastro = new CadastroAlunos();
        setTitle("Cadastro de Alunos - Aula 4");
        setSize(560, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        criarComponentes();
    }

    private void criarComponentes() {
        JPanel painel = new JPanel(new GridLayout(6, 2, 5, 5));
        campoNome = new JTextField();
        campoCurso = new JTextField();
        campoSemestre = new JTextField();
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoListar = new JButton("Listar");
        JButton botaoBuscar = new JButton("Buscar por nome");
        JButton botaoLimpar = new JButton("Limpar campos");
        JButton botaoTotal = new JButton("Total de alunos");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Curso:"));
        painel.add(campoCurso);
        painel.add(new JLabel("Semestre:"));
        painel.add(campoSemestre);
        painel.add(botaoCadastrar);
        painel.add(botaoListar);
        painel.add(botaoBuscar);
        painel.add(botaoLimpar);
        painel.add(botaoTotal);

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        botaoCadastrar.addActionListener(e -> cadastrarAluno());
        botaoListar.addActionListener(e -> listarAlunos());
        botaoBuscar.addActionListener(e -> buscarAluno());
        botaoLimpar.addActionListener(e -> limparCampos());
        botaoTotal.addActionListener(e -> mostrarTotalAlunos());
    }

    private void cadastrarAluno() {
        String nome = campoNome.getText().trim();
        String curso = campoCurso.getText().trim();
        String textoSemestre = campoSemestre.getText().trim();

        if (nome.isEmpty() || curso.isEmpty() || textoSemestre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        int semestre;
        try {
            semestre = Integer.parseInt(textoSemestre);
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "Digite um número válido para semestre.");
            return;
        }

        if (semestre < 1 || semestre > 10) {
            JOptionPane.showMessageDialog(this, "O semestre deve estar entre 1 e 10.");
            return;
        }

        Aluno aluno = new Aluno(nome, semestre, curso);
        cadastro.adicionar(aluno);
        areaResultado.setText("Aluno cadastrado: " + aluno.gerarResumo());
        limparCampos();
    }

    private void listarAlunos() {
        if (cadastro.listarTodos().isEmpty()) {
            areaResultado.setText("Nenhum aluno cadastrado.");
            return;
        }

        StringBuilder texto = new StringBuilder();
        for (Aluno aluno : cadastro.listarTodos()) {
            texto.append(aluno.gerarResumo()).append("\n");
        }
        areaResultado.setText(texto.toString());
    }

    private void buscarAluno() {
        String nome = campoNome.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome para busca.");
            return;
        }

        Aluno encontrado = cadastro.buscarPorNome(nome);
        if (encontrado == null) {
            areaResultado.setText("Aluno não encontrado.");
        } else {
            areaResultado.setText("Encontrado: " + encontrado.gerarResumo());
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCurso.setText("");
        campoSemestre.setText("");
        campoNome.requestFocus();
    }
    private void mostrarTotalAlunos() {

        areaResultado.setText(
            "Total de alunos: " + cadastro.contarAlunos()
        );
}
}
