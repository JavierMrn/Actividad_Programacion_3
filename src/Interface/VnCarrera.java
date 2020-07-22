package Interface;

import Bibioteca.Estudiante;
import Bibioteca.Carrera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VnCarrera extends JFrame implements ActionListener {
    
    private JLabel lbNombreCarrera, lbNombreDirector, lbNumSemestres;
    private JTextField tfNombreCarrera, tfNombreDirector;
    private JComboBox cbNumSemestres;
    private JButton btAceptar, btAtras;
    private VnInicio target;
    
    public VnCarrera() {
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Nombre Carrera
        lbNombreCarrera = new JLabel("Nombre de la carrera: ");
        lbNombreCarrera.setBounds(20, 30, 200, 30);
        add(lbNombreCarrera);
        
        tfNombreCarrera = new JTextField();
        tfNombreCarrera.setBounds(20, 65, 200, 30);
        add(tfNombreCarrera);

        //Nombre del Director
        lbNombreDirector = new JLabel("Nombre del Director: ");
        lbNombreDirector.setBounds(250, 30, 200, 30);
        add(lbNombreDirector);
        
        tfNombreDirector = new JTextField();
        tfNombreDirector.setBounds(250, 65, 200, 30);
        add(tfNombreDirector);

        //Carrera
        lbNumSemestres = new JLabel("Número de Semestres: ");
        lbNumSemestres.setBounds(20, 180, 200, 30);
        add(lbNumSemestres);
        
        cbNumSemestres = new JComboBox();
        cbNumSemestres.setBounds(20, 210, 200, 30);
        cbNumSemestres.addItem("");
        for (int i = 2; i <= 12; i++) {
            cbNumSemestres.addItem(i + " Semestres");
        }
        add(cbNumSemestres);

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
            JOptionPane.showMessageDialog(null, "Estudiante guardado exitosamente");
        } else if (e.getSource() == btAtras) {
            target.setVisible(true);
            this.setVisible(false);
        }
    }
}
