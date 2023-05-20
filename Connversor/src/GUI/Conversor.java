package GUI;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Conversor extends JFrame {

    private int type;

    public Conversor(int type){
        String tipo = "";
        switch(type){
            case 0:
                tipo = "Divisas";
                Conversor_Divisas conversorDivisas = new Conversor_Divisas();
                this.add(conversorDivisas);
                break;
            case 1:
                tipo = "Temperatura";
                Conversor_Temperatura conversorTemperatura = new Conversor_Temperatura();
                this.add(conversorTemperatura);
                break;
            case 2:
                tipo = "Longitud";
                Conversor_Longitud conversorLongitud = new Conversor_Longitud();
                this.add(conversorLongitud);
                break;
            case 3:
                tipo = "Masa";
                Conversor_Masa conversorMasa = new Conversor_Masa();
                this.add(conversorMasa);
                break;
        }

        //Diseño de la ventana
        this.setTitle("Conversor de " + tipo);
        this.setBounds(400, 200, 550,330);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                Principal p = new Principal();
                p.setVisible(true);
                dispose();
            }
        });
    }
}
