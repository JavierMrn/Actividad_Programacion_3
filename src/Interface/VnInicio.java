package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VnInicio extends JFrame implements ActionListener {
    
    private JLabel lbPrincipal;
    private JTextField tfPrincipal;
    private JButton btAceptar, btNuevoEstudiante, btNuevoPrestamo, btInformacion, btNuevaCarrera;
    private JMenuBar mb;
    private JMenu mOpciones;
    private JMenuItem miNuevoEstudiante;
    private VnEstudiante vnEstudiante;
    private VnCarrera vnCarrera;
    
    public VnInicio(VnCarrera vnCarrera, VnEstudiante vnEstudiante) {
        this.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.vnCarrera = vnCarrera;
        this.vnEstudiante = vnEstudiante;
        
        lbPrincipal = new JLabel("Biblioteca Andrés Segovia");
        lbPrincipal.setBounds(80, 40, 350, 30);
        lbPrincipal.setFont(new Font("Bauhaus 93", 1, 26));
        add(lbPrincipal);
        
        btNuevoEstudiante = new JButton("Nuevo Estudiante");
        btNuevoEstudiante.setBounds(140, 100, 200, 30);
        btNuevoEstudiante.addActionListener(this);
        btNuevoEstudiante.setBackground(Color.CYAN);
        add(btNuevoEstudiante);
        
        btNuevoPrestamo = new JButton("Nuevo Prestamo");
        btNuevoPrestamo.setBounds(140, 150, 200, 30);
        btNuevoPrestamo.setBackground(Color.cyan);
        btNuevoPrestamo.addActionListener(this);
        add(btNuevoPrestamo);
        
        btNuevaCarrera = new JButton("Nueva Carrera");
        btNuevaCarrera.setBounds(140, 200, 200, 30);
        btNuevaCarrera.setBackground(Color.cyan);
        btNuevaCarrera.addActionListener(this);
        add(btNuevaCarrera);
        
        btInformacion = new JButton("Información");
        btInformacion.setBounds(140, 250, 200, 30);
        btInformacion.setBackground(Color.cyan);
        btInformacion.addActionListener(this);
        add(btInformacion);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btNuevoEstudiante) {
            vnEstudiante.setVisible(true);
            this.setVisible(false);
        }
        
        if (e.getSource() == btNuevaCarrera) {
            vnCarrera.setVisible(true);
            this.setVisible(false);
        }
    }
}
