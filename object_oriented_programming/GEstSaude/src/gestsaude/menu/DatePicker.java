package gestsaude.menu;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;

/**
 * Mostra uma janela onde se pode escolher uma data.
 * Código adaptado de https://roseindia.net/tutorial/java/swing/datePicker.html
 */
public class DatePicker extends JDialog {
	private static final long serialVersionUID = 1L;
	private int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	private int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	private JLabel l = new JLabel("", JLabel.CENTER);
	private String day = "";
	private JButton[] button = new JButton[49];
	private LocalDate inicio;
	private LocalDate fim;

	/**
	 * Cria um DatePicker, em que se pode escolher qualquer data
	 * 
	 * @param parent componente pai (serve para ficar centrado relativamente a este)
	 */
	public DatePicker(Component parent) {
		this(parent, null, null);
	}

	/**
	 * Cria um DatePicker, em que só se pode escolher datas entre inicio e fim.<br>
	 * Se inicio for null são aceites datas até fim. <br>
	 * Se fim for null são aceites a partir de inicio. <br>
	 * 
	 * @param parent componente pai (serve para ficar centrado relativamente a este)
	 * @param inicio data limite inicial (inclusive)
	 * @param fim    data limite final (inclusive)
	 */
	public DatePicker(Component parent, LocalDate inicio, LocalDate fim) {
		this.inicio = inicio;
		this.fim = fim;
		setupAspeto();
		setLocationRelativeTo(parent);
		displayDate();
	}

	/**
	 * devolve a data que foi escolhida
	 * 
	 * @return a data escolhida, ou null caso não tenha sido escolhida nenhuma data
	 */
	public LocalDate getPickedDate() {
		if (day.equals(""))
			return null;
		return LocalDate.of(year, month + 1, Integer.parseInt(day));
	}

	/** apresenta o painel de escolha de datas */
	public void displayDate() {
		for (int x = 7; x < button.length; x++) {
			button[x].setText("");
			button[x].setEnabled(false);
		}
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
			LocalDate dia = LocalDate.of(year, month + 1, day);
			button[x].setText("" + day);
			button[x].setEnabled(podeSerEscolhida(dia));
		}
		l.setText(sdf.format(cal.getTime()));
		setTitle("Escolha a data");
	}

	private boolean podeSerEscolhida(LocalDate d) {
		if (inicio != null && fim != null)
			return inicio.compareTo(d) <= 0 && fim.compareTo(d) >= 0;
		else if (inicio != null)
			return inicio.compareTo(d) <= 0;
		else if (fim != null)
			return fim.compareTo(d) >= 0;
		return true;
	}

	/** define o aspeto do componente */
	private void setupAspeto() {
		setModal(true);
		String[] header = { "Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Ant.");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month--;
				if (month < 0) {
					month = 11;
					year--;
				}
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Próx. >>");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				if (month > 11) {
					month = 0;
					year++;
				}
				displayDate();
			}
		});
		p2.add(next);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		pack();
	}

}
