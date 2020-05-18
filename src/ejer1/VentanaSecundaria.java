package ejer1;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.*;
import java.awt.FlowLayout;

public class VentanaSecundaria extends JDialog implements ActionListener, ItemListener {

    private JTextField titulo;
    private JLabel lbl1;
    private JRadioButton lily;
    private JRadioButton mischka;
    private JRadioButton opal;
    private JRadioButton mamba;
    ButtonGroup grupo;

    public VentanaSecundaria(Ventana principal) {
        super(principal, true);
        this.setLayout(new FlowLayout());
        this.setTitle("cambiar titulo y colores del principal");

        // Componente 1: textfield
        titulo = new JTextField(30);
        titulo.addActionListener(this);
        this.add(titulo);

        //Componente 2 label informativo
        lbl1 = new JLabel("Selecciona un color:");
        this.add(lbl1);
        // RdadioButtons
        lily = new JRadioButton("Lily");
        lily.addItemListener(this);
        this.add(lily);
       

        mischka = new JRadioButton("Mischka");
        mischka.addItemListener(this);
        this.add(mischka);
        

        opal = new JRadioButton("Opal");
        opal.addItemListener(this);
        this.add(opal);
   

        mamba = new JRadioButton("Mamba");
        mamba.addItemListener(this);
        this.add(mamba);
     
        grupo = new ButtonGroup();
        grupo.add(lily);
        grupo.add(mischka);
        grupo.add(opal);
        grupo.add(mamba);
        lily.setSelected(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ventana ventanaAnterior = (Ventana)this.getOwner();
        ventanaAnterior.setTitle(titulo.getText());
        ventanaAnterior.titulo = titulo.getText();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton rdb = (JRadioButton)e.getSource();
        Ventana ventanaAnterior = (Ventana)this.getOwner();
        if (rdb==lily || rdb==mischka) {
            if (rdb==lily) {
                ventanaAnterior.rojo =208;
                ventanaAnterior.verde=169;
                ventanaAnterior.azul=188;
            }else{
                ventanaAnterior.rojo =211;
                ventanaAnterior.verde=211;
                ventanaAnterior.azul=222;
            }
        }else{
            if (rdb==opal) {
                ventanaAnterior.rojo =161;
                ventanaAnterior.verde=188;
                ventanaAnterior.azul=194;
            }else{
                ventanaAnterior.rojo =152;
                ventanaAnterior.verde=129;
                ventanaAnterior.azul=157;
            }
        }
    }

}