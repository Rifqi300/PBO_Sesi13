/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventHandler;

import java.lang.NumberFormatException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author LENOVO
 */

public class Arimatika_sederhana extends JFrame implements MouseListener, ActionListener {

    JTextField firstValueInput = new JTextField();
    JTextField secondValueInput = new JTextField();
    JLabel outputValue = new JLabel();

    JButton tambah = new JButton("+");
    JButton kurang = new JButton("-");
    JButton kali = new JButton("*");
    JButton bagi = new JButton("/");
    JButton modulo = new JButton("Modulus");

    Arimatika_sederhana() {
        super("Arimatika_sederhana");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.green);
        setLocationRelativeTo(null);

        // Register Event Listener
        firstValueInput.addMouseListener(this);
        secondValueInput.addMouseListener(this);
        outputValue.addMouseListener(this);

        firstValueInput.addKeyListener(new Bagian_Inputtan(firstValueInput));
        secondValueInput.addKeyListener(new Bagian_Inputtan(secondValueInput));

        tambah.addMouseListener(this);
        kurang.addMouseListener(this);
        kali.addMouseListener(this);
        bagi.addMouseListener(this);
        modulo.addMouseListener(this);

        tambah.addActionListener(this);
        kurang.addActionListener(this);
        kali.addActionListener(this);
        bagi.addActionListener(this);
        modulo.addActionListener(this);

        // Buat Layout
        JPanel inputOutputPanel = new JPanel();
        inputOutputPanel.setLayout(new GridLayout(1, 3));
        inputOutputPanel.add(firstValueInput);
        inputOutputPanel.add(secondValueInput);
        inputOutputPanel.add(outputValue);

        JPanel operatorPanel = new JPanel();
        operatorPanel.setLayout(new GridLayout(5, 1));
        operatorPanel.add(tambah);
        operatorPanel.add(kurang);
        operatorPanel.add(kali);
        operatorPanel.add(bagi);
        operatorPanel.add(modulo);

        this.setLayout(new GridLayout(2, 1));
        this.add(inputOutputPanel);
        this.add(operatorPanel);
    }

    public class Bagian_Inputtan extends KeyAdapter {

        JTextField input;

        Bagian_Inputtan(JTextField input) {
            this.input = input;
        }

        public void Tombol(KeyEvent ke) {
            if (input.getText() != "") {                
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == 8) {
                    input.setEditable(true);
                } else {
                    input.setEditable(false);

                }
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            int firstInputValue = Integer.parseInt(firstValueInput.getText());
            int secondInputValue = Integer.parseInt(secondValueInput.getText());

            if (ae.getSource() == tambah) {
                outputValue.setText(Integer.toString(firstInputValue + secondInputValue));
            }

            if (ae.getSource() == kurang) {
                outputValue.setText(Integer.toString(firstInputValue - secondInputValue));
            }

            if (ae.getSource() == kali) {
                outputValue.setText(Integer.toString(firstInputValue * secondInputValue));
            }

            if (ae.getSource() == bagi) {
                outputValue.setText(Integer.toString(firstInputValue / secondInputValue));
            }

            if (ae.getSource() == modulo) {
                outputValue.setText(Integer.toString(firstInputValue % secondInputValue));
            }

        } catch (NumberFormatException err) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Anda Harus Masukkan Angkah Terlebih Dahulu");
        }

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arimatika_sederhana kalkulator = new Arimatika_sederhana();
    }

}