package ejer1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Ventana extends JFrame {
    private JButton btn1;
    private JButton btn2;
    private JLabel lbl1;
    String titulo = "Control de Ratón";
    int rojo = 237;
    int verde = 217;
    int azul = 223;
    int x;
    int y;

    public Ventana() {
        super();
        this.setTitle("Control de Ratón");
        this.setLayout(new FlowLayout());

        // componente 1: btn1

        btn1 = new JButton("Izquierda");
        btn1.addKeyListener(new TecladoEventos());
        btn1.addMouseMotionListener(new Coordenadas());
        this.add(btn1);

        // Componente 2: btn2

        btn2 = new JButton("Derecha");
        btn2.addMouseMotionListener(new Coordenadas());
        btn2.addKeyListener(new TecladoEventos());
        this.add(btn2);

        // componente 3: lbl1
        lbl1 = new JLabel("Teclas");
        this.add(lbl1);

        this.addWindowListener(new CierreVentana());
        this.getContentPane().addKeyListener(new TecladoEventos());
        this.getContentPane().addMouseMotionListener(new Coordenadas());
        this.getContentPane().addMouseListener(new MouseHandler());
    }

    // Para cerrar la ventan con un mensajito, por si le damos sin querer a la
    // x============================
    private class CierreVentana extends WindowAdapter {

        @Override
        public void windowClosing(final WindowEvent e) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres salir del programa?", "Cerrarlo todo",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.OK_OPTION) {
                e.getWindow().dispose();
            }
        }
    }

    // Raton=====================================================================================

    private class Coordenadas extends MouseAdapter {

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {

            if (e.getSource() != btn1 && e.getSource() != btn2) {
                Ventana.this.setTitle(String.format("%s - (X:%d, Y:%d)",Ventana.this.titulo, e.getX(), e.getY()));
                x = e.getX();
                y = e.getY();
            } else {
                Ventana.this.setTitle(String.format("%s - (X:%d, Y:%d)",Ventana.this.titulo, e.getX() + x, e.getY() + y));
            }

        }

    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {

            if (e.getButton() == 1) {
                // No me funciona e.getButton()==MouseEvent.BUTTON1
                Ventana.this.btn1.setBackground(new Color(rojo, verde, azul));
            }
            if (e.getButton() == 3) {
                // Se presiono el boton derecho
                Ventana.this.btn2.setBackground(new Color(rojo, verde, azul));
            }
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                // No me funciona e.getButton()==MouseEvent.BUTTON1
                Ventana.this.btn1.setBackground(null);
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                // Se presiono el boton derecho
                Ventana.this.btn2.setBackground(null);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {

            super.mouseExited(e);
            Ventana.this.setTitle(titulo);

        }
    }

    // TECLADO======================================================================================================================

    private class TecladoEventos extends KeyAdapter {
        @Override
        public void keyPressed(java.awt.event.KeyEvent eventoTeclado) {

            int i = eventoTeclado.getKeyCode();
            char letra = eventoTeclado.getKeyChar();
            if (eventoTeclado.getKeyCode() == KeyEvent.VK_C && eventoTeclado.isControlDown()) {
                VentanaSecundaria segundona = new VentanaSecundaria(Ventana.this);
                segundona.pack();
                segundona.setVisible(true);
                segundona.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            } else {
                Ventana.this.lbl1
                        .setText(String.format("La tecla pulsada es la :%s y su código de teclado es %d", letra, i));
            }
        }
    }

}