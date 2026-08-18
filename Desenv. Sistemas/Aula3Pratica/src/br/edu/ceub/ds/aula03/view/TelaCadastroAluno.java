package br.edu.ceub.ds.aula03.view;

import javax.swing.*;
import java.awt.*;

import br.edu.ceub.ds.aula03.model.Aluno;
import br.edu.ceub.ds.aula03.service.CadastroAlunos;

public class TelaCadastroAluno extends JFrame {

    private JTextField campoNome;
    private JTextField campoCurso;
    private JTextField campoSemestre;
    private JTextArea areaResultado;

    private CadastroAlunos cadastro;

    public TelaCadastroAluno() {

        cadastro = new CadastroAlunos();

        setTitle("Cadastro de Alunos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        criarComponentes();
    }

    private void criarComponentes() {

        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        campoNome = new JTextField();
        campoCurso = new JTextField();
        campoSemestre = new JTextField();

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoListar = new JButton("Listar");
        JButton botaoBuscar = new JButton("Buscar por nome");
        JButton botaoLimpar = new JButton("Limpar campos");

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

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        botaoCadastrar.addActionListener(e -> cadastrarAluno());
        botaoListar.addActionListener(e -> listarAlunos());
        botaoBuscar.addActionListener(e -> buscarAluno());
        botaoLimpar.addActionListener(e -> limparCampos());
    }

    private void cadastrarAluno() {

        String nome = campoNome.getText().trim();
        String curso = campoCurso.getText().trim();
        String textoSemestre = campoSemestre.getText().trim();

        if (nome.isEmpty() || curso.isEmpty() || textoSemestre.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Preencha todos os campos."
            );

            return;
        }

        int semestre = Integer.parseInt(textoSemestre);

        Aluno aluno = new Aluno(nome, semestre, curso);

        cadastro.adicionar(aluno);

        areaResultado.setText(
            "Aluno cadastrado: " + aluno.gerarResumo()
        );

        limparCampos();
    }

    private void listarAlunos() {

        StringBuilder texto = new StringBuilder();

        for (Aluno aluno : cadastro.listarTodos()) {

            texto.append(aluno.gerarResumo()).append("\n");
        }

        areaResultado.setText(texto.toString());
    }

    private void buscarAluno() {

        String nome = campoNome.getText().trim();

        Aluno encontrado = cadastro.buscarPorNome(nome);

        if (encontrado == null) {

            areaResultado.setText("Aluno não encontrado.");

        } else {

            areaResultado.setText(
                "Encontrado: " + encontrado.gerarResumo()
            );
        }
    }

    private void limparCampos() {

        campoNome.setText("");
        campoCurso.setText("");
        campoSemestre.setText("");

        campoNome.requestFocus();
    }
}
