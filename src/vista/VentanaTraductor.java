package vista;

import javax.swing.*;
import controlador.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTraductor extends JFrame {
    private JTextField txtPalabraConsulta;
    private JComboBox<String> comboIdiomaOrigen;
    private JComboBox<String> comboIdiomaDestino;
    private JTextField txtTraduccionResultado;
    private JTextField txtPalabraAgregar;
    private JTextField txtTraduccionAgregar;
    private JComboBox<String> comboIdiomaAgregar;
    private JLabel lblEstadisticas;
    private Controlador controlador;

    public VentanaTraductor() {
        initUI();
    }

    private void initUI() {
        setTitle("Traductor de Idiomas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Panel de consulta
        JPanel panelConsulta = new JPanel(new GridLayout(3, 2));
        panelConsulta.setBorder(BorderFactory.createTitledBorder("Consulta de Traducciones"));

        txtPalabraConsulta = new JTextField();
        comboIdiomaOrigen = new JComboBox<>(new String[]{"Español", "Inglés", "Francés", "Italiano"});
        comboIdiomaDestino = new JComboBox<>(new String[]{"Español", "Inglés", "Francés", "Italiano"});
        JButton btnTraducir = new JButton("Traducir");
        txtTraduccionResultado = new JTextField();
        txtTraduccionResultado.setEditable(false);

        panelConsulta.add(new JLabel("Palabra:"));
        panelConsulta.add(txtPalabraConsulta);
        panelConsulta.add(new JLabel("Idioma Origen:"));
        panelConsulta.add(comboIdiomaOrigen);
        panelConsulta.add(new JLabel("Idioma Destino:"));
        panelConsulta.add(comboIdiomaDestino);
        panelConsulta.add(btnTraducir);
        panelConsulta.add(txtTraduccionResultado);

        add(panelConsulta);

        // Panel para agregar traducciones
        JPanel panelAgregar = new JPanel(new GridLayout(4, 2));
        panelAgregar.setBorder(BorderFactory.createTitledBorder("Agregar Traducción"));

        txtPalabraAgregar = new JTextField();
        txtTraduccionAgregar = new JTextField();
        comboIdiomaAgregar = new JComboBox<>(new String[]{"Español-Inglés", "Español-Francés", "Español-Italiano", "Inglés-Español", "Francés-Español", "Italiano-Español"});
        JButton btnAgregar = new JButton("Agregar");

        panelAgregar.add(new JLabel("Palabra en Español:"));
        panelAgregar.add(txtPalabraAgregar);
        panelAgregar.add(new JLabel("Traducción:"));
        panelAgregar.add(txtTraduccionAgregar);
        panelAgregar.add(new JLabel("Idioma:"));
        panelAgregar.add(comboIdiomaAgregar);
        panelAgregar.add(btnAgregar);

        add(panelAgregar);

        // Panel de estadísticas
        JPanel panelEstadisticas = new JPanel(new BorderLayout());
        panelEstadisticas.setBorder(BorderFactory.createTitledBorder("Estadísticas"));

        lblEstadisticas = new JLabel("Número de traducciones: 0");
        panelEstadisticas.add(lblEstadisticas, BorderLayout.CENTER);

        add(panelEstadisticas);

        // Eventos
        btnTraducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = txtPalabraConsulta.getText();
                String idioma = comboIdiomaOrigen.getSelectedItem().toString().toLowerCase() + "-" +
                        comboIdiomaDestino.getSelectedItem().toString().toLowerCase();
                String resultado = controlador.traducirPalabra(palabra, idioma);
                txtTraduccionResultado.setText(resultado);
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = txtPalabraAgregar.getText();
                String traduccion = txtTraduccionAgregar.getText();
                String idioma = comboIdiomaAgregar.getSelectedItem().toString().toLowerCase();

                controlador.agregarTraduccion(palabra, traduccion, idioma);
                lblEstadisticas.setText("Número de traducciones: " + controlador.getNumeroTraducciones());
                JOptionPane.showMessageDialog(null, "Traducción agregada correctamente.");
            }
        });
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}

