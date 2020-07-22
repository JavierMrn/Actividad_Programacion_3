package Interface;

import Bibioteca.Estudiante;
import Bibioteca.Carrera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VnEstudiante extends JFrame implements ActionListener {
    
    private JLabel lbNombreEstu, lbCedula, lbGenero, lbCarrera;
    private JTextField tfNombreEstu, tfCedula;
    private JComboBox cbGenero, cbCarrera;
    private JButton btAceptar, btAtras;
    private VnInicio target;
    
    public VnEstudiante() {
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Nombre
        lbNombreEstu = new JLabel("Nombre del Estudiante: ");
        lbNombreEstu.setBounds(20, 30, 200, 30);
        add(lbNombreEstu);
        
        tfNombreEstu = new JTextField();
        tfNombreEstu.setBounds(20, 65, 200, 30);
        add(tfNombreEstu);

        //Cédula
        lbCedula = new JLabel("Cédula del Estudiante: ");
        lbCedula.setBounds(250, 30, 200, 30);
        add(lbCedula);
        
        tfCedula = new JTextField();
        tfCedula.setBounds(250, 65, 200, 30);
        add(tfCedula);

        //genero
        lbGenero = new JLabel("Genero del Estudiante: ");
        lbGenero.setBounds(20, 180, 200, 30);
        add(lbGenero);
        
        cbGenero = new JComboBox();
        cbGenero.setBounds(20, 210, 200, 30);
        cbGenero.addItem("");
        cbGenero.addItem("Masculino");
        cbGenero.addItem("Femenino");
        add(cbGenero);

        //Carrera
        lbCarrera = new JLabel("Carrera del Estudiante: ");
        lbCarrera.setBounds(250, 180, 200, 30);
        add(lbCarrera);
        
        cbCarrera = new JComboBox();
        cbCarrera.setBounds(250, 210, 200, 30);
        cbCarrera.addItem("");
        add(cbCarrera);

        //Aceptar
        btAceptar = new JButton("Aceptar");
        btAceptar.setBounds(300, 400, 100, 30);
        btAceptar.addActionListener(this);
        add(btAceptar);

        //Atras
        btAtras = new JButton("Atras");
        btAtras.setBounds(90, 400, 100, 30);
        btAtras.addActionListener(this);
        add(btAtras);
    }
    
    public void setTarget(VnInicio target) {
        this.target = target;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAceptar) {
            Estudiante nEstudiante = new Estudiante();
            nEstudiante.setNombre(tfNombreEstu.getText());
            nEstudiante.setCedula(tfCedula.getText());
            nEstudiante.setGenero(cbGenero.getSelectedItem().toString());
            
            Carrera nCarrera = new Carrera();
            nCarrera.addStudent(nEstudiante);
            
            JOptionPane.showMessageDialog(null, "Estudiante guardado exitosamente");
        } else if (e.getSource() == btAtras) {
            target.setVisible(true);
            this.setVisible(false);
        }
    }
}
