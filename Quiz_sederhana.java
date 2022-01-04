/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventHandler;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author LENOVO
 */

public class Quiz_sederhana extends JFrame implements MouseListener, ActionListener {

    JTextField firstValue = new JTextField();
    JTextField secondValue = new JTextField();
    JTextField userInput = new JTextField();
    JLabel resultText = new JLabel();
    JButton checkButton = new JButton("CHECK");

    int randomFirstValue = getNomorAcak(1, 100);
    int randomSecondValue = getNomorAcak(1, 200);

    Quiz_sederhana() {
        super("Quiz_sederhana");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // Register Event Listener
        userInput.addMouseListener(this);
        checkButton.addMouseListener(this);
        checkButton.addActionListener(this);
        userInput.addKeyListener(new Inputtan(userInput));

        // Buat Layout
        JPanel guessBoardPanel = new JPanel();
        guessBoardPanel.setLayout(new GridLayout(1, 1));
        guessBoardPanel.add(firstValue);
        guessBoardPanel.add(secondValue);
        guessBoardPanel.add(userInput);

        this.setLayout(new GridLayout(3, 2));
        this.add(guessBoardPanel);
        this.add(checkButton);
        this.add(resultText);

        //Inisialisasi
        firstValue.setText(Integer.toString(randomFirstValue));
        secondValue.setText(Integer.toString(randomSecondValue));
        firstValue.setEditable(false);
        secondValue.setEditable(false);
    }

    public int getNomorAcak(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public class Inputtan extends KeyAdapter {

        JTextField input;

        Inputtan(JTextField input) {
            this.input = input;
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (!"".equals(input.getText())) {
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
        int userInputValue = Integer.parseInt(userInput.getText());

        if (ae.getSource() == checkButton) {
            if (randomFirstValue + randomSecondValue == userInputValue) {
                resultText.setText("Selamat, jawaban anda benar !!");
                getContentPane().setBackground(Color.green);
            } else {
                resultText.setText("Maaf, jawaban anda salah !!");
                getContentPane().setBackground(Color.red);
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Quiz_sederhana kalkulator = new Quiz_sederhana();
    }

}