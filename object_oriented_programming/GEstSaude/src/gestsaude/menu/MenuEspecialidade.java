package gestsaude.menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gestsaude.recurso.GEstSaude;
import gestsaude.recurso.Senha;
import gestsaude.recurso.Servico;
import gestsaude.recurso.Especialidade;

/**
 * Janela da aplicação instalada em cada especialidade
 *
 */
public class MenuEspecialidade extends JDialog {

	// constantes dos elementos usados na janela
	private static final Dimension tamanhoBt = new Dimension(170, 30);
	private static final DateTimeFormatter PADRAO_HH_MM = DateTimeFormatter.ofPattern("hh:mm");

	private Especialidade especial;
	private Senha senha;
	private GEstSaude gest;

	// elementos gráficos usados na interface
	private static final long serialVersionUID = 1L;
	private JPanel menusPanel;
	private CardLayout menusCard;
	private JButton chamarBt;
	private JLabel senhaLbl, utenteLbl;

	/**
	 * Construtor da janela de especialidade
	 * 
	 * @param pos  posição onde por a janela
	 * @param esp  qual a especialidade associada à janela
	 * @param gest o sistema a que a janela está ligada
	 */
	public MenuEspecialidade(JFrame owner, Point pos, Especialidade esp, GEstSaude gest) {
		super(owner);
		setLocation(pos);
		especial = esp;
		setupAspeto();
		atualizarInfo();
		this.gest = gest;
		setResizable(false);
	}

	/**
	 * Método que chama o próximo utente
	 * 
	 * @return true se tem próximo utente
	 */
	private boolean proximoUtente() {
		senha = especial.getProximaSenha();
		if (senha == null)
			return false;

		// TODO colocar a info nas variáveis
		String numero = "A1";
		String nomeUtente = "Um utente qualquer";

		senhaLbl.setText(numero);
		utenteLbl.setText(nomeUtente);
		return true;
	}

	/** chamado quando se pressiona o botão do utente estar ausente */
	private void ausenteUtente() {
		especial.rejeitaProximaSenha();
	}

	/** chamado quando se pressiona o botão para finalizar a consulta */
	private void finalizarConsulta() {
		especial.terminaConsulta(senha);
	}

	/**
	 * chamado quando se pressiona o botão para encaminhar o utente para outros
	 * serviços
	 */
	private void encaminhar() {
		Vector<String> serv = new Vector<String>();
		do {
			JList<String> lista = new JList<String>(serv);
			String res = JOptionPane.showInputDialog(this, lista, "Encaminhar para onde?", JOptionPane.PLAIN_MESSAGE);
			if (res == null || res.isEmpty())
				break;
			// TODO ver se o serviço existe
			Servico s = null;
			if (s == null)
				JOptionPane.showMessageDialog(this, "Esse serviço não existe!");
			else {
				// TODO associar o serviço à senha e a senha aos serviços
			}
		} while (true);
		finalizarConsulta();
	}

	/** lista as senhas em espera nesta especialidade */
	private void listarSenhas() {
		Vector<String> infoSenhas = new Vector<>();
		Collection<Senha> senhas = especial.getEmEspera();
		for (Senha s : senhas) {
			// TODO colocar a info certa nas variáveis
			String numeroSenha = "A101";
			String nomeUtente = "Alberto Berto";
			LocalTime hora = LocalTime.now();

			infoSenhas.add(numeroSenha + ": " + nomeUtente + " " + PADRAO_HH_MM.format(hora));
		}
		JList<String> list = new JList<String>(infoSenhas);
		JScrollPane scroll = new JScrollPane(list);
		JOptionPane.showMessageDialog(this, scroll, "Senhas no serviço", JOptionPane.PLAIN_MESSAGE);
	}

	/** Atualiza a janela, indicando quantos utentes estão em fila de espera */
	public void atualizarInfo() {
		// TODO colocar a info certa
		String idEspecialidade = "Ped1.";
		int nUtentes = especial.getEmEspera().size();

		setTitle(idEspecialidade + " utentes: " + nUtentes);
		chamarBt.setEnabled(nUtentes > 0);
	}

	// métodos relacionados com a interface gráfica. Não deve ser necessário alterar
	// nada nestes métodos
	/**
	 * Define o aspeto desta janela
	 */
	private void setupAspeto() {
		setLayout(new BorderLayout());
		setupInfoPanel();

		JPanel menuChamada = setupMenuChamada();
		JPanel menuConsulta = setupMenuConsulta();
		menusCard = new CardLayout();
		menusPanel = new JPanel(menusCard);
		menusPanel.add(menuChamada);
		menusPanel.add(menuConsulta);

		add(menusPanel, BorderLayout.CENTER);
		pack();
	}

	private void setupInfoPanel() {
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		senhaLbl = new JLabel("---", JLabel.CENTER);
		senhaLbl.setFont(new Font("Roman", Font.BOLD, 15));
		senhaLbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		info.add(senhaLbl);

		utenteLbl = new JLabel("---", JLabel.CENTER);
		utenteLbl.setFont(new Font("Roman", Font.BOLD, 10));
		utenteLbl.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		info.add(utenteLbl);

		JButton senhasBt = new JButton("Senhas");
		senhasBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listarSenhas();
			}
		});
		senhasBt.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		senhasBt.setMargin(new Insets(0, 0, 0, 0));
		info.add(senhasBt);

		add(info, BorderLayout.NORTH);
	}

	private JPanel setupMenuChamada() {
		JPanel menuChamada = new JPanel(new GridLayout(0, 1));
		chamarBt = new JButton("Chamar Utente");
		JButton ausenteBt = new JButton("Utente ausente");
		JButton validarBt = new JButton("Validar Consulta");

		chamarBt.setMinimumSize(tamanhoBt);
		chamarBt.setPreferredSize(tamanhoBt);
		chamarBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (proximoUtente()) {
					atualizarInfo();
					ausenteBt.setEnabled(true);
					validarBt.setEnabled(true);
				}
			}
		});
		menuChamada.add(chamarBt);

		ausenteBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				senhaLbl.setText("---");
				utenteLbl.setText("---");
				ausenteUtente();
				ausenteBt.setEnabled(false);
				validarBt.setEnabled(false);
			}
		});
		ausenteBt.setEnabled(false);
		menuChamada.add(ausenteBt);

		validarBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ausenteBt.setEnabled(false);
				validarBt.setEnabled(false);
				menusCard.next(menusPanel);
			}
		});
		validarBt.setEnabled(false);
		menuChamada.add(validarBt);

		return menuChamada;
	}

	private JPanel setupMenuConsulta() {
		JPanel menuConsulta = new JPanel(new GridLayout(0, 1));
		JButton finalizarBt = new JButton("Finalizar Consulta");
		finalizarBt.setMinimumSize(tamanhoBt);
		finalizarBt.setPreferredSize(tamanhoBt);
		finalizarBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizarConsulta();
				limpaInfo();
			}

		});
		menuConsulta.add(finalizarBt);

		JButton encaminharBt = new JButton("Encaminhar");
		encaminharBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				encaminhar();
				limpaInfo();
			}
		});
		menuConsulta.add(encaminharBt);

		return menuConsulta;
	}

	private void limpaInfo() {
		senhaLbl.setText("---");
		utenteLbl.setText("---");
		atualizarInfo();
		menusCard.next(menusPanel);
	}
}
