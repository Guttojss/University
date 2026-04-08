package gestsaude.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import gestsaude.recurso.*;
import poo.util.RelogioSimulado;

/**
 * Interface reservada aos funcionários da secretaria.
 * Permite várias listagens das consultas, a criação, edição
 * e remoção de consultas e visualizar as senhas presentes no sistema
 */
public class MenuSecretaria extends JFrame {

	private static final DateTimeFormatter PADRAO_HH_MM = DateTimeFormatter.ofPattern("hh:mm");

	private GEstSaude gest; // o sistema

	/** elementos gráficos usados na interface gráfica */
	private static final long serialVersionUID = 1L;
	private java.util.List<Consulta> consultasListadas;
	private DefaultTableModel consultasModel;
	private JButton delBt = new JButton("x");
	private JButton editBt = new JButton("e");
	private ButtonGroup listagemGrp;
	private String titulo;

	// tipos de listagem que existem (em PDS seria um TODO para usar uma state)
	private static final int LISTAR_TODAS = 0;
	private static final int LISTAR_HOJE = 1;
	private static final int LISTAR_UTENTE = 2;
	private static final int LISTAR_ESPECIALIDADE = 3;
	private int listagem = LISTAR_TODAS;

	/**
	 * Cria a janela com o menu da secretaria
	 * 
	 * @param posicao onde colocar a janela
	 * @param titulo  título da janela
	 * @param gest    o sistema
	 */
	public MenuSecretaria(Point posicao, String titulo, GEstSaude gest) {
		this.gest = gest;
		this.titulo = titulo;
		setLocation(posicao);
		setupAspeto();
		listarTodas();
		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		atualizar();
	}

	/** lista todas as consultas */
	private void listarTodas() {
		// TODO: colocar a lista de todas as consultas
		listarConsultas(java.util.List.of());
		listagem = LISTAR_TODAS;
	}

	/** lista apenas as consultas de hoje */
	private void listarHoje() {
		LocalDateTime agora = RelogioSimulado.getRelogioSimulado().tempoAtual();
		// TODO listar as consulta do dia de hoje
		listarConsultas(java.util.List.of());
		listagem = LISTAR_HOJE;
	}

	/** lista todas as consultas de um utente */
	private void listarPorUtente() {
		// TODO completar este método
		String numSns = JOptionPane.showInputDialog(this, "Número de SNS do utente?");
		Utente u = null;
		if (u != null)
			listarConsultas(java.util.List.of());
		else {
			JOptionPane.showMessageDialog(this, "Utente inválido");
		}
		listagem = LISTAR_UTENTE;
	}

	/** lista todas as consultas de um serviço */
	private void listarPorEspecialidade() {
		// TODO completar este método
		String numServico = JOptionPane.showInputDialog(this, "Id da especialidade?");
		Especialidade esp = null;
		if (esp != null)
			listarConsultas(java.util.List.of());
		else {
			JOptionPane.showMessageDialog(this, "Especialidade inválida!");
		}
		listagem = LISTAR_ESPECIALIDADE;
	}

	/** Processa o carregar no botão de criar nova consulta */
	private void agendarNovaConsulta() {
		EditorConsulta ec = new EditorConsulta(getLocation(), gest);
		ec.setVisible(true);
		Consulta c = ec.getConsulta();
		if (c != null) {
			// TODO adicionar a consulta ao sistema

			listarTodas();
		}
	}

	/** Processa o carregar no botão de eliminar consulta */
	private void apagarConsulta(Consulta c) {
		int opcao = JOptionPane.showConfirmDialog(this, "Deseja mesmo apagar esta Consulta?", "Confimação",
				JOptionPane.YES_NO_OPTION);
		if (opcao == JOptionPane.NO_OPTION)
			return;

		// TODO remover a consulta do sistema
	}

	/** Processa o carregar no botão de editar consulta */
	private void editarConsulta(Consulta c) {
		EditorConsulta ec = new EditorConsulta(getLocation(), gest, c);
		ec.setVisible(true);
		Consulta nova = ec.getConsulta();
		if (nova != null) {
			// TODO alterar a consulta no sistema
			gest.alteraConsulta(c, nova);
			listarTodas();
		}
	}

	/** Lista todas as senhas na tabela */
	private void listarSenhas() {
		// TODO completar este método
		Collection<Senha> senhas = java.util.List.of();
		Vector<String> infoSenhas = new Vector<>();
		for (Senha s : senhas) {
			// TODO por a info nas variáveis
			String numeroSenha = "A123";
			// se estiver para ser atendido num serviço usar a descrição do serviço, senão
			// usar a descrição da expecialidade
			String descricao = s.servicoAtual() == null ? "Especialidade" : "Serviço";

			infoSenhas.add(numeroSenha + ": " + descricao);
		}
		JList<String> list = new JList<String>(infoSenhas);
		JScrollPane scroll = new JScrollPane(list);
		JOptionPane.showMessageDialog(this, scroll, "Senhas no sistema", JOptionPane.PLAIN_MESSAGE);
	}

	/** Lista todas as consultas numa lista */
	private void listarConsultas(java.util.Collection<Consulta> consultas) {
		consultasListadas = new ArrayList<>(consultas);
		consultasModel.setRowCount(0);
		for (Consulta c : consultas) {
			// TODO colocar a informação nas variáveis
			String snsUtente = "321";
			String nomeUtente = "Utente Exemplar";
			String idEspecialidade = "Esp1.";
			String descricaoEspecialidade = "Especialidade";
			String dataString = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String horaString = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));

			addLinhaTabela(snsUtente + " - " + nomeUtente, idEspecialidade + " - " + descricaoEspecialidade, dataString,
					horaString);
		}
	}

	/**
	 * Atualiza a janela
	 */
	public void atualizar() {
		String tempo = RelogioSimulado.getTempoAtual().toLocalTime().format(PADRAO_HH_MM);
		setTitle(titulo + "     " + tempo);
		switch (listagem) {
			case LISTAR_TODAS:
				listarTodas();
				break;
			case LISTAR_HOJE:
				listarHoje();
				break;
			case LISTAR_UTENTE:
				listarPorUtente();
				break;
			case LISTAR_ESPECIALIDADE:
				listarPorEspecialidade();
				break;
		}
	}

	/**
	 * Adiciona uma linha à tabela de consultas.
	 * 
	 * @param utente        string com o sns e nome do mutente
	 * @param especialidade string com id da especialidade e respetiva descrição
	 * @param data          string que representa a data da consulta
	 * @param hora          string que representa a hora da consulta
	 */
	private void addLinhaTabela(String utente, String especialidade, String data, String hora) {
		Object values[] = { utente, especialidade, data, hora, delBt, editBt };
		consultasModel.addRow(values);
	}

	// métodos relacionados com a interface gráfica. Não deve ser necessário alterar
	// nada nestes métodos
	/**
	 * Chamado quando é selecionada uma célula da tabela
	 */
	private void selecionadaCelula(JTable table) {
		int col = table.getSelectedColumn();
		int row = table.getSelectedRow();
		if (col < 4)
			return;
		if (row < 0)
			return;
		if (col == 4)
			apagarConsulta(consultasListadas.get(row));
		else
			editarConsulta(consultasListadas.get(row));
	}

	/**
	 * configura o aspeto visual da janela
	 */
	private void setupAspeto() {
		setLayout(new BorderLayout());

		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setupAspetoSuperior(top);
		add(top, BorderLayout.NORTH);

		String colunas[] = { "Utente", "Serviço", "Data", "Hora", "", "" };
		consultasModel = new DefaultTableModel(colunas, 0);

		delBt.setMargin(new Insets(0, 0, 0, 0));
		editBt.setMargin(new Insets(0, 0, 0, 0));
		@SuppressWarnings("serial")
		JTable table = new JTable(consultasModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionadaCelula(table);
			}
		});
		table.setShowGrid(false);
		table.setShowHorizontalLines(true);
		table.getTableHeader().setResizingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(180);
		table.getColumnModel().getColumn(2).setMinWidth(90);
		table.getColumnModel().getColumn(3).setMinWidth(80);
		table.getColumnModel().getColumn(4).setMaxWidth(50);
		table.getColumnModel().getColumn(5).setMaxWidth(50);
		table.getColumnModel().getColumn(4).setCellRenderer(new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus,
					int row, int column) {
				return (JButton) value;
			}
		});
		table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus,
					int row, int column) {
				return (JButton) value;
			}
		});

		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(600, 200));
		add(scroll, BorderLayout.CENTER);
		pack();
	}

	private void setupAspetoSuperior(JPanel top) {
		top.add(new JLabel("Listagem: "));

		listagemGrp = new ButtonGroup();
		JToggleButton todasBt = new JToggleButton("Todas");
		todasBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listarTodas();
			}
		});
		todasBt.setSelected(true);
		listagemGrp.add(todasBt);
		top.add(todasBt);

		JToggleButton hojeBt = new JToggleButton("Hoje");
		hojeBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listarHoje();
			}
		});
		listagemGrp.add(hojeBt);
		top.add(hojeBt);

		JToggleButton utenteBt = new JToggleButton("Utente");
		utenteBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listarPorUtente();
			}
		});
		listagemGrp.add(utenteBt);
		top.add(utenteBt);

		JToggleButton especialidadeBt = new JToggleButton("Especialidade");
		especialidadeBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listarPorEspecialidade();
			}
		});
		listagemGrp.add(especialidadeBt);
		top.add(especialidadeBt);

		top.add(new JLabel("   operações: "));

		JButton novaBt = new JButton("Nova Consulta");
		novaBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agendarNovaConsulta();
			}

		});
		top.add(novaBt);

		JButton senhasBt = new JButton("Ver Senhas");
		senhasBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listarSenhas();
			}
		});
		top.add(senhasBt);
	}
}
