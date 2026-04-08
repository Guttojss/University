package gestsaude.menu;

import javax.swing.*;

import poo.util.RelogioSimulado;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Uma janela que apresenta o relógio simulado e permite manipular esse mesmo
 * relógio.
 * Não será necessário alterar esta classe.
 */
public class RelogioDialog extends JDialog {

    private LocalTime tempo;
    private int velocidade = 1;
    private JLabel labelRelogio;
    private Timer timer;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public RelogioDialog(Frame owner, Point pos) {
        super(owner, "Relógio Simulado", false);
        tempo = RelogioSimulado.getTempoAtual().toLocalTime();

        setupAspeto();
        iniciarTimer();
        setSize(200, 100);
        setLocation(pos);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void definirHora() {
        // ComboBox horas de agora até às 23
        LocalTime tempo = RelogioSimulado.getTempoAtual().toLocalTime();
        int horaInicial = tempo.getHour();
        Integer[] horas = new Integer[24 - horaInicial];
        for (int i = 0; i < horas.length; i++)
            horas[i] = i + horaInicial;
        JComboBox<Integer> comboHoras = new JComboBox<>(horas);
        comboHoras.setSelectedItem(tempo.getHour());

        // ComboBox minutos 0-55 de 5 em 5
        Integer[] minutos = { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 };
        JComboBox<Integer> comboMinutos = new JComboBox<>(minutos);
        comboMinutos.setSelectedItem((tempo.getMinute() / 5) * 5);

        JPanel painel = new JPanel(new GridLayout(2, 2, 5, 5));
        painel.add(new JLabel("Horas:"));
        painel.add(comboHoras);
        painel.add(new JLabel("Minutos:"));
        painel.add(comboMinutos);

        int resultado = JOptionPane.showConfirmDialog(this, painel, "Definir Hora",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (resultado == JOptionPane.OK_OPTION) {
            int h = (Integer) comboHoras.getSelectedItem();
            int m = (Integer) comboMinutos.getSelectedItem();
            LocalDateTime novaData = LocalDateTime.of(LocalDate.now(), LocalTime.of(h, m));
            if (novaData.isAfter(RelogioSimulado.getTempoAtual()))
                RelogioSimulado.getRelogioSimulado().setTempoAtual(novaData);
            else
                JOptionPane.showMessageDialog(this, "A hora definida não pode ser inferior à atual", "Hora INválida",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    private void definirVelocidade() {
        Integer[] velocidades = { 1, 2, 5, 10, 20, 60, 300 };
        JComboBox<Integer> comboVelocidade = new JComboBox<>(velocidades);
        comboVelocidade.setSelectedItem(velocidade);

        JPanel painel = new JPanel(new FlowLayout());
        painel.add(new JLabel("Velocidade (segundos por segundo):"));
        painel.add(comboVelocidade);

        int resultado = JOptionPane.showConfirmDialog(this, painel, "Definir Velocidade",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (resultado == JOptionPane.OK_OPTION) {
            velocidade = (Integer) comboVelocidade.getSelectedItem();
            RelogioSimulado.getRelogioSimulado().setTicksPorSegundo(velocidade);
        }
    }

    @Override
    public void dispose() {
        if (timer != null) {
            timer.stop();
        }
        super.dispose();
    }

    private void setupAspeto() {
        setLayout(new BorderLayout(10, 10));
        RelogioSimulado.getRelogioSimulado().setTempoAtual(LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0)));

        // Label do relógio
        labelRelogio = new JLabel(tempo.format(formatter), SwingConstants.CENTER);
        labelRelogio.setFont(new Font("Monospaced", Font.BOLD, 24));
        add(labelRelogio, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));

        JButton btnDefinirHora = new JButton("Hora");
        btnDefinirHora.addActionListener(e -> definirHora());

        JButton btnDefinirVelocidade = new JButton("Velocidade");
        btnDefinirVelocidade.addActionListener(e -> definirVelocidade());

        painelBotoes.add(btnDefinirHora);
        painelBotoes.add(btnDefinirVelocidade);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void iniciarTimer() {
        timer = new Timer(1000, e -> {
            LocalTime tempo = RelogioSimulado.getTempoAtual().toLocalTime();
            labelRelogio.setText(tempo.format(formatter));
        });
        timer.start();
    }
}