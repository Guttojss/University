package gestsaude.menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gestsaude.recurso.Senha;
import gestsaude.recurso.Servico;

/**
 * Janela de interação reservada a cada serviço
 */
public class MenuServico extends JDialog {

	// dimensões dos botões
	// private static final Dimension tamanhoBt = new Dimension(35, 35);
	private static final ImageIcon saltaIco = getIconEscala("art/saltar.png");
	private static final ImageIcon chamarIco = getIconEscala("art/chamar.png");
	private static final ImageIcon terminarIco = getIconEscala("art/terminar.png");

	private Servico servico;
	private Senha senha;

	// elementos gráficos usados na interface
	private static final long serialVersionUID = 1L;
	private JButton chamarBt;
	private JLabel senhaLbl, utenteLbl;

	/**
	 * Construtor da janela de Serviço
	 * 
	 * @param pos posição onde por a janela
	 * @param s   qual o serviço associado à janela
	 */
	public MenuServico(JFrame owner, Point pos, Servico s) {
		super(owner);
		setLocation(pos);
		servico = s;
		setupAspeto();
		atualizarInfo();
		setResizable(false);
	}

	/**
	 * Verifica e chama o proximo utente, se o serviço tem utentes em espera
	 * 
	 * @return true se tem utente em espera
	 */
	private boolean temUtenteEspera() {
		// TODO ver qual a próxima senha
		senha = servico.getProximaSenha();
		if (senha == null)
			return false;

		// TODO colocar a info nas variáveis
		String numero = "A12";
		String nomeUtente = "Joana Ana";

		senhaLbl.setText(numero);
		utenteLbl.setText(nomeUtente);
		return true;
	}

	/** método chamado para rejeitar o utente */
	private void saltarUtente() {
		// TODO implementar o método

	}

	/** método chamado para terminar o serviço */
	private void terminarServico() {
		servico.terminaConsulta(senha);
	}

	/** Lista as senhas em espera neste serviço */
	private void listarSenhas() {
		Collection<Senha> senhas = servico.getEmEspera();
		Vector<String> infoSenhas = new Vector<>();
		for (Senha s : senhas) {
			// TODO colocar a informação nas variáveis
			String numeroSenha = "A11";
			String nomeUtente = "Vitor Virtual";

			infoSenhas.add(numeroSenha + ": " + nomeUtente);
		}
		JList<String> list = new JList<String>(infoSenhas);
		JScrollPane scroll = new JScrollPane(list);
		JOptionPane.showMessageDialog(this, scroll, "Senhas no serviço", JOptionPane.PLAIN_MESSAGE);
	}

	/** Atualiza título, indicando quantos utentes estão em fila de espera */
	public void atualizarInfo() {
		// TODO colocar a informação nas variáveis
		String idServico = "Rad.";
		int nUtentes = servico.getEmEspera().size();

		setTitle(idServico + " utentes: " + nUtentes);
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
		add(menuChamada, BorderLayout.CENTER);
		pack();
	}

	/**
	 * Configura o painel de informações
	 */
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

	/**
	 * Configur ao painel com os botões
	 * 
	 * @return o painel configurado
	 */
	private JPanel setupMenuChamada() {
		JPanel menuChamada = new JPanel(new GridLayout(1, 0));
		chamarBt = new JButton(chamarIco);
		JButton saltarBt = new JButton(/* "Saltar Utente" */ saltaIco);
		JButton terminarBt = new JButton(terminarIco);

		// chamarBt.setMinimumSize(tamanhoBt);
		// chamarBt.setPreferredSize(tamanhoBt);
		// chamarBt.setMaximumSize(tamanhoBt);
		chamarBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (temUtenteEspera()) {
					atualizarInfo();
					saltarBt.setEnabled(true);
					terminarBt.setEnabled(true);
				}
			}
		});
		menuChamada.add(chamarBt);

		saltarBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saltarUtente();
				limpaInfo();
				saltarBt.setEnabled(false);
				terminarBt.setEnabled(false);
			}
		});
		saltarBt.setEnabled(false);
		menuChamada.add(saltarBt);

		terminarBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				terminarServico();
				limpaInfo();
				saltarBt.setEnabled(false);
				terminarBt.setEnabled(false);
			}
		});
		terminarBt.setEnabled(false);
		menuChamada.add(terminarBt);

		return menuChamada;
	}

	/**
	 * limpa o painel de informações
	 */
	private void limpaInfo() {
		senhaLbl.setText("---");
		utenteLbl.setText("---");
		atualizarInfo();
	}

	/**
	 * carrega a imagem a usar para um icon de 32x32
	 * 
	 * @param file ficheiro onde está a imagem
	 * @return o icon na imagem
	 */
	private static ImageIcon getIconEscala(String file) {
		ImageIcon icone = new ImageIcon(file);
		Image is = icone.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		return new ImageIcon(is);
	}
}
