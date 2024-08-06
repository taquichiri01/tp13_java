package ar.edu.et7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JTextField parametroA;
    private JTextField parametroB;
    private JTextField parametroC;
    private JButton botonCalcular;
    private JTextArea resultado;
    private Calculos calc;

    public MainWindow() {
        // Configuración de la ventana principal
        setTitle("Calculadora de Suma");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear los componentes
        parametroA = new JTextField(10);
        parametroB = new JTextField(10);
        parametroC = new JTextField(10);
        botonCalcular = new JButton("Calcular");
        resultado = new JTextArea(5, 20);
        resultado.setEditable(false);

        this.calc = new Calculos();
        
        // Panel para los inputs
        JPanel panelInputs = new JPanel();
        panelInputs.setLayout(new GridLayout(4, 2));
        panelInputs.add(new JLabel("Parámetro A:"));
        panelInputs.add(parametroA);
        panelInputs.add(new JLabel("Parámetro B:"));
        panelInputs.add(parametroB);
        panelInputs.add(new JLabel("Parámetro C:"));
        panelInputs.add(parametroC);
        panelInputs.add(new JLabel(""));  // Placeholder
        panelInputs.add(botonCalcular);

        // Panel para el resultado
        JPanel panelResultado = new JPanel();
        panelResultado.setLayout(new BorderLayout());
        panelResultado.add(new JLabel("Resultado:"), BorderLayout.NORTH);
        panelResultado.add(new JScrollPane(resultado), BorderLayout.CENTER);

        // Agregar los paneles a la ventana
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelInputs, BorderLayout.NORTH);
        getContentPane().add(panelResultado, BorderLayout.CENTER);

        // Configurar la acción del botón
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    private void calcular() {
        try {
            // Obtener los valores de los campos de texto
            int a = Integer.parseInt(parametroA.getText());
            int b = Integer.parseInt(parametroB.getText());
            int c = Integer.parseInt(parametroC.getText());

            // Calcular
     		int suma = calc.sumar(a, b, c);

            // Mostrar el resultado en el área de texto
            resultado.setText("Resultado: " + suma);
        } catch (NumberFormatException ex) {
            // Manejar el caso en que los inputs no sean números válidos
            resultado.setText("Por favor, ingrese números válidos.");
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
