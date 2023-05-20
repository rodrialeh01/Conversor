package GUI;

import Clases.Moneda;
import Clases.Temperatura;
import Controller.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conversor_Temperatura extends JPanel implements ActionListener {
    Color color_fondo = new Color(245, 123, 66);
    JLabel titulo, selec1, selec2, message;
    JComboBox opcion1, opcion2;
    JTextField numero_ingresado, numero_resultado;

    public Conversor_Temperatura(){
        //Label: Titulo
        titulo = new JLabel("Conversor de Temperatura");
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(40,20,500,50);
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 35));
        this.add(titulo);

        //Label: desc1
        selec1 = new JLabel("De:");
        selec1.setForeground(Color.BLACK);
        selec1.setBounds(10,100,400,30);
        selec1.setFont(new Font("Century Gothic", Font.BOLD, 15));
        this.add(selec1);

        //Combobox1
        Temperatura[] temperaturas = Temperatura.values();
        String[] strings = new String[temperaturas.length];
        for(int i = 0; i < temperaturas.length; i++){
            strings[i] = temperaturas[i].name();
        }

        opcion1 = new JComboBox();
        opcion1.setForeground(Color.BLACK);
        opcion1.setBounds(10,140,200,30);
        opcion1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        opcion1.setOpaque(false);
        for(int i = 0; i < strings.length; i++){
            opcion1.addItem(strings[i]);
        }
        opcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = numero_ingresado.getText();
                if(text.isEmpty()|| text.equals("-")){
                    numero_resultado.setText("");
                }
                Controller c = new Controller();
                String selectedValue1 = (String) opcion1.getSelectedItem();
                Temperatura temp1 = Temperatura.valueOf(selectedValue1);
                String selectedValue2 = (String) opcion2.getSelectedItem();
                Temperatura temp2 = Temperatura.valueOf(selectedValue2);
                numero_resultado.setText(c.Conversor_De_Temperatura(text, temp1,temp2).toString());
            }
        });
        this.add(opcion1);

        //TextField de ingreso
        numero_ingresado = new JTextField();
        numero_ingresado.setForeground(Color.BLACK);
        numero_ingresado.setBounds(10,190,200,50);
        numero_ingresado.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        AbstractDocument document = (AbstractDocument) numero_ingresado.getDocument();
        DocumentFilter documentFilter = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                StringBuilder sb = new StringBuilder();
                sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.insert(offset, text);

                if (isDecimal(sb.toString())) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                StringBuilder sb = new StringBuilder();
                sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.replace(offset, offset + length, text);

                if (isDecimal(sb.toString())) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                StringBuilder sb = new StringBuilder();
                sb.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
                sb.delete(offset, offset + length);

                if (isDecimal(sb.toString())) {
                    super.remove(fb, offset, length);
                }
            }

            private boolean isDecimal(String text) {
                return text.matches("^-?\\d*\\.?\\d*$"); // Permitir un signo negativo opcional
            }
        };

        document.setDocumentFilter(documentFilter);
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = numero_ingresado.getText();
                if(text.isEmpty()|| text.equals("-")){
                    numero_resultado.setText("");
                }
                Controller c = new Controller();
                String selectedValue1 = (String) opcion1.getSelectedItem();
                Temperatura temp1 = Temperatura.valueOf(selectedValue1);
                String selectedValue2 = (String) opcion2.getSelectedItem();
                Temperatura temp2 = Temperatura.valueOf(selectedValue2);
                numero_resultado.setText(c.Conversor_De_Temperatura(text, temp1,temp2).toString());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };
        numero_ingresado.getDocument().addDocumentListener(documentListener);
        this.add(numero_ingresado);

        //Label: desc2
        selec2 = new JLabel("a:");
        selec2.setForeground(Color.BLACK);
        selec2.setBounds(300,100,400,30);
        selec2.setFont(new Font("Century Gothic", Font.BOLD, 15));
        this.add(selec2);

        //Combobox2
        opcion2 = new JComboBox();
        opcion2.setForeground(Color.BLACK);
        opcion2.setBounds(300,140,200,30);
        opcion2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        opcion2.setOpaque(false);
        for(int i = strings.length-1; i >=0; i--){
            opcion2.addItem(strings[i]);
        }
        opcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = numero_ingresado.getText();
                if(text.equals("")){
                    numero_resultado.setText("");
                }
                Controller c = new Controller();
                String selectedValue1 = (String) opcion1.getSelectedItem();
                Temperatura temp1 = Temperatura.valueOf(selectedValue1);
                String selectedValue2 = (String) opcion2.getSelectedItem();
                Temperatura temp2 = Temperatura.valueOf(selectedValue2);
                numero_resultado.setText(c.Conversor_De_Temperatura(text, temp1,temp2).toString());
            }
        });
        this.add(opcion2);

        //TextField de respuesta
        numero_resultado = new JTextField();
        numero_resultado.setForeground(Color.BLACK);
        numero_resultado.setBounds(300,190,200,50);
        numero_resultado.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        numero_resultado.setEditable(false);
        this.add(numero_resultado);

        //PANEL
        this.setBounds(0,0, 600,400);
        this.setBackground(color_fondo);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
