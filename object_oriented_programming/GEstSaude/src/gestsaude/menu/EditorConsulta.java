package gestsaude.menu;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.swing.*;

import gestsaude.recurso.*;

/**
 * Classe usada para apresentar a janela
 * de criação/edição de uma consulta
 */
public class EditorConsulta extends JDialog {
	// Constantes para a definição do período horário
	private static final int PRIMEIRA_HORA = 8;
	private static final int ULTIMA_HORA = 19;
	private static final int TEMPO_CONSULTA = 10;

	private GEstSaude gest;
	private Consulta consulta;
	private Utente utente;
	private Especialidade especialidade;
	private LocalDate data;
	private LocalTime hora;

	// consulta que vai resultar da edição ou criação
	private Consulta consultaRes;

	// elementos gráficos para a interface com o utilizador
	private static final long serialVersionUID = 1L;
	private JLabel avisosLbl;
	private JTextField snsUtenteTF, nomeUtente;
	private JComboBox<String> idEspecialidadeCB;
	private JTextField nomeServico;
	private JTextField dataText;
	private JComboBox<String> horaBox, minsBox;
	private Color corOk = new Color(0, 150, 0);
	private JButton okBt;

	/**
	 * cria a janela de edição para a criação de uma nova consulta
	 * 
	 * @param posicao ondo colocar a janela
	 * @param g       o sistema
	 */
	public EditorConsulta(Point posicao, GEstSaude g) {
		this(posicao, g, null, "Criar Nova Consulta");
	}

	/**
	 * Cria a janela de edição para a edição de uma consulta
	 * 
	 * @param posicao  onde colocar a janela
	 * @param g        o sistema
	 * @param consulta a consulta a editar
	 */
	public EditorConsulta(Point posicao, GEstSaude g, Consulta consulta) {
		this(posicao, g, consulta, "Editar Consulta");
		snsUtenteTF.setFocusable(false);
		idEspecialidadeCB.setFocusable(false);
	}

	/**
	 * Construtor que coloca o titulo na janela
	 * 
	 * @param posicao  onde colocar a janela
	 * @param g        o sistema
	 * @param consulta a consulta a editar (se for null é para criar uma nova)
	 * @param titulo   o título a usar na janela
	 */
	private EditorConsulta(Point posicao, GEstSaude g, Consulta consulta, String titulo) {
		setLocation(posicao);
		setTitle(titulo);
		this.consulta = consulta;
		this.gest = g;

		// TODO FEITO usar uma lista com os ids das especialidades
		setupAspeto(java.util.List.of(especialidade.getId(especialidade)));

		// se for uma consulta existente é preciso carregar os dados desta
		if (consulta != null) {
			// TODO  FEITO colocar os dados certos nas variáveis
			String snsUtente = consulta.getUtente(consulta).getSNS(utente);
			String idEspecialidade = consulta.getEspecialidade(consulta).getId(especialidade);
			data = LocalDate.now();
			hora = LocalTime.now();

			snsUtenteTF.setText(snsUtente);
			testaIdUtente();

			idEspecialidadeCB.setSelectedItem(idEspecialidade);
			testaIdServico();

			escreverData();
			escreverHora();
		}
		testaTudoOk();
	}

	/**
	 * retorna a consulta resultante
	 * 
	 * @return a consulta resultante, null se a operação tiver sido cancelada
	 */
	public Consulta getConsulta() {
		return consultaRes;
	}

	/**
	 * Chamado pela interface para saber se o sns utente é válido.
	 * Deve dar indicações de erro.
	 */
	protected void testaIdUtente() {
		// TODO FEITO ver se o utente existe
		if (utente.getSNS(utente) == null) {
			apresentarMensagem("Id do utente é inválido!", false);
			nomeUtente.setText("");
		} else {
			// TODO FEITO substituir texto pelo nome do utente
			nomeUtente.setText(utente.getNome(utente));
			testaTudoOk();
		}
	}

	/**
	 * Chamado pela interface para saber se o id da especialdiade é válido.
	 * Deve dar indicações de erro.
	 */
	protected void testaIdServico() {
		// TODO FEITO ver se o id da especialidade escolhida é válido
		String idEscolhido = (String) idEspecialidadeCB.getSelectedItem();

		if (especialidade.getId(especialidade) == null) {
			apresentarMensagem("Especialidade não reconhecida!", false);
			nomeServico.setText("");
		} else {
			// TODO FEITO substituir texto pela descrição da especialidade
			nomeServico.setText(especialidade.getDescricao(especialidade));
			testaTudoOk();
		}
	}

	/**
	 * Chamado pela interface para saber se todos os parâmetros
	 * estão corretos e se a consulta é aceitável. Dá indicações se está tudo ok
	 * ou se há algum erro, especificando o erro.
	 */
	private void testaTudoOk() {
		if (utente == null)
			apresentarMensagem("Falta definir o utente!", false);
		else if (especialidade == null)
			apresentarMensagem("Falta definir o serviço!", false);
		else if (data == null)
			apresentarMensagem("Falta definir a data!", false);
		else {
			// TODO criar a consulta e verificar se pode ser adicionada/alterada
			Consulta c = null;
			// ver se é criação ou uma alteração
			int res = consulta == null ? gest.podeAceitarConsulta(c) : gest.podeAlterarConsulta(consulta, c);
			switch (res) {
				case GEstSaude.CONSULTA_ACEITE:
					apresentarMensagem("Está tudo OK!", true);
					break;
				case GEstSaude.UTENTE_JA_TEM_CONSULTA:
					apresentarMensagem("Utente já tem consulta!", false);
					break;
				case GEstSaude.ESPECIALISTA_JA_TEM_CONSULTA:
					apresentarMensagem("Especialista já tem consulta!", false);
					break;
				case GEstSaude.DATA_JA_PASSOU:
					apresentarMensagem("Fora de prazo!", false);
					break;
				// esta nunca deve aparecer, mas vamos testar na mesma
				case GEstSaude.ALTERACAO_INVALIDA:
					apresentarMensagem("Alteração não permitida!", false);
					break;
			}
		}
	}

	/**
	 * Chamado quando o botão ok é premido
	 */
	protected void okPremido() {
		LocalDateTime quando = LocalDateTime.of(data, getHora());

		// TODO criar a consulta com os valores escolhidos
		consultaRes = null;
		setVisible(false);
	}

	/**
	 * Chamado quando o botão cancel é premido
	 * fazer aqui as considerações finais, se necessário
	 */
	protected void cancelPremido() {
		setVisible(false);
	}

	// métodos relacionados com a interface gráfica. Não deve ser necessário alterar
	// nada nestes métodos

	/**
	 * Devolve a hora escolhida pelo utilizador
	 * 
	 * @return a hora, em LocalTime, conforme definida pelo utilizador
	 */
	private LocalTime getHora() {
		int h = Integer.parseInt((String) horaBox.getSelectedItem());
		int m = Integer.parseInt((String) minsBox.getSelectedItem());
		return LocalTime.of(h, m);
	}

	/**
	 * Escreve uma mensagem no painel de informações
	 * 
	 * @param texto  texto a escrever no painel
	 * @param tudoOk se for true, texto aparece a verde, senão a vermelho
	 */
	private void apresentarMensagem(String texto, boolean tudoOk) {
		if (tudoOk)
			avisosLbl.setForeground(corOk);
		else
			avisosLbl.setForeground(Color.red);
		okBt.setEnabled(tudoOk);
		avisosLbl.setText(texto);
	}

	/**
	 * Transforma uma LocalDate numa string com a formatação portuguesa
	 */
	private void escreverData() {
		dataText.setText(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	/**
	 * Apresenta uma LocalTime nas combobox da interface
	 */
	private void escreverHora() {
		int idx = hora.getHour() - PRIMEIRA_HORA;
		horaBox.setSelectedIndex(idx);

		idx = hora.getMinute() / TEMPO_CONSULTA;
		minsBox.setSelectedIndex(idx);
	}

	/** Define o aspeto deste componente */
	private void setupAspeto(Collection<String> especialidadeIDs) {
		setModal(true);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weighty = 0.2;
		gbc.weightx = 1;
		setLayout(new GridBagLayout());
		JPanel utentePanel = new JPanel();
		utentePanel.setBorder(BorderFactory.createTitledBorder("Utente"));
		setupAreaCliente(utentePanel);
		add(utentePanel, gbc);

		JPanel especialPanel = new JPanel();
		especialPanel.setBorder(BorderFactory.createTitledBorder("Especialidade"));
		setupAreaServico(especialPanel, especialidadeIDs);
		add(especialPanel, gbc);

		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(BorderFactory.createTitledBorder("Data e hora"));
		setupAreaTempo(dataPanel);
		add(dataPanel, gbc);

		avisosLbl = new JLabel();
		avisosLbl.setBorder(BorderFactory.createTitledBorder("Mensagens"));
		avisosLbl.setPreferredSize(new Dimension(100, 80));
		gbc.weighty = 0.8;
		add(avisosLbl, gbc);

		JPanel okPanel = new JPanel();
		okPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		setupOkCancel(okPanel);
		gbc.weighty = 0;
		add(okPanel, gbc);
		pack();
	}

	private void setupOkCancel(JPanel okPanel) {
		okBt = new JButton("Ok");
		okBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				okPremido();
			}
		});
		okPanel.add(okBt);

		JButton cancelBt = new JButton("Cancelar");
		cancelBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelPremido();
			}
		});
		okPanel.add(cancelBt);
	}

	private void setupAreaCliente(JPanel utentePanel) {
		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		utentePanel.setLayout(gl);

		utentePanel.add(new JLabel("SNS:"), gbc);

		snsUtenteTF = new JTextField(8);
		snsUtenteTF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				testaIdUtente();
			}
		});
		snsUtenteTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testaIdUtente();
				transferFocus();
			}
		});

		gbc.weightx = 0.1;
		utentePanel.add(snsUtenteTF, gbc);

		gbc.weightx = 0;
		utentePanel.add(new JLabel("Nome:"), gbc);

		nomeUtente = new JTextField(40);
		nomeUtente.setFocusable(false);
		gbc.weightx = 0.9;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		utentePanel.add(nomeUtente, gbc);
	}

	private void setupAreaServico(JPanel servicoPanel, Collection<String> especialidadeIds) {
		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		servicoPanel.setLayout(gl);

		servicoPanel.add(new JLabel("ID: "), gbc);

		idEspecialidadeCB = new JComboBox<String>();
		for (String s : especialidadeIds)
			idEspecialidadeCB.addItem(s);
		idEspecialidadeCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				testaIdServico();
			}
		});
		idEspecialidadeCB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testaIdServico();
				transferFocus();
			}
		});

		gbc.weightx = 0.1;
		servicoPanel.add(idEspecialidadeCB, gbc);

		gbc.weightx = 0;
		servicoPanel.add(new JLabel("Especialidade: "), gbc);

		nomeServico = new JTextField(40);
		nomeServico.setFocusable(false);
		gbc.weightx = 0.9;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		servicoPanel.add(nomeServico, gbc);
	}

	private void setupAreaTempo(JPanel dataPanel) {
		dataPanel.add(new JLabel("Data: "));
		dataText = new JTextField(8);
		dataText.setFocusable(false);
		dataPanel.add(dataText);

		JButton pickBt = new JButton("...");
		pickBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DatePicker dp = new DatePicker(EditorConsulta.this, LocalDate.now(), LocalDate.now().plusDays(365));
				dp.setVisible(true);
				data = dp.getPickedDate();
				if (data != null) {
					escreverData();
					testaTudoOk();
				}
			}
		});
		dataPanel.add(pickBt);

		dataPanel.add(new JLabel("   Hora: "));
		String[] horas = new String[ULTIMA_HORA - PRIMEIRA_HORA + 1];
		for (int i = 0; i < horas.length; i++)
			horas[i] = "" + (i + PRIMEIRA_HORA);

		String[] minutos = new String[60 / TEMPO_CONSULTA];
		for (int i = 0; i < minutos.length; i++)
			minutos[i] = "" + (i * TEMPO_CONSULTA);

		horaBox = new JComboBox<String>(horas);
		horaBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testaTudoOk();
			}
		});
		minsBox = new JComboBox<String>(minutos);
		minsBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testaTudoOk();
			}
		});

		dataPanel.add(horaBox);
		dataPanel.add(minsBox);
	}

}
