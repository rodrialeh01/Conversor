package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboPopup;

public class Principal extends JFrame implements ActionListener {
    //Declaracion de Colores
    Color color_fondo_azul = new Color(44, 51, 130);
    Color color_boton = new Color(5, 86, 161);

    //Declaracion de componentes
    JLabel titulo, descripcion, creditos;
    JComboBox opciones;
    JButton boton;

    public Principal (){
        String[] opciones_combobox = {"Divisas","Temperatura", "Longitud", "Masa"};

        //Label de titulo
        titulo = new JLabel("Conversor");
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(150,20,200,30);
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 35));
        this.add(titulo);

        //Label de Descripcion
        descripcion = new JLabel("Selecciona la conversion que quieres realizar");
        descripcion.setForeground(Color.WHITE);
        descripcion.setBounds(20,70,500,30);
        descripcion.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        this.add(descripcion);

        //Combobox de Opciones
        opciones = new JComboBox();
        opciones.setForeground(Color.BLACK);
        opciones.setBounds(60,120,350,40);
        opciones.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        opciones.setOpaque(false);

        for(int i = 0; i < opciones_combobox.length; i++){
            opciones.addItem(opciones_combobox[i]);
        }
        this.add(opciones);

        //Boton de confirmación
        boton = new JButton("Continuar");
        boton.setForeground(Color.WHITE);
        boton.setBorderPainted(false);
        boton.setBackground(color_boton);
        boton.setBounds(155,180,150,40);
        boton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        boton.addActionListener(this);
        this.add(boton);

        //Label de creditos
        creditos = new JLabel("Creado por: @rodrialeh01");
        creditos.setForeground(Color.WHITE);
        creditos.setBounds(10,230,500,20);
        creditos.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        this.add(creditos);

        //Diseño de la ventana
        this.setTitle("Conversor");
        this.setBounds(400, 200, 500,300);
        this.getContentPane().setBackground(color_fondo_azul);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            System.out.println(opciones.getSelectedIndex());
            Conversor c = new Conversor(opciones.getSelectedIndex());
            c.setVisible(true);
            this.dispose();
        }
    }
}
