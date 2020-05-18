package ejer1;

import javax.swing.JFrame;

public class MainClass {
    public static void main(String[] args) {
      
       
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setSize(1000, 200);
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
