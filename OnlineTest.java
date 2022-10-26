package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.util.*;


public class OnlineTest extends JFrame implements  ActionListener{
    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnResult;
    ButtonGroup bg;
    int count = 0, x = 1, y = 1, i = 0;
    public static int[] current = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int m[] = new int[10];

    // create jFrame with radioButton and JButton
    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnNext.addActionListener(this);
        btnResult.addActionListener(this);
        add(btnNext);
        add(btnResult);
        set();
        label.setBounds(30, 40, 450, 20);
        //radioButton[0].setBounds(50, 80, 200, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(900, 650);
        getContentPane().setBackground(new Color(255,102,102));

        //adding logo
        ImageIcon img = new ImageIcon("img.png");
        setIconImage(img.getImage());

    }

    // handle all actions based on event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            i++;
            set();
            if (current[i] == current[current.length-1]) {
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            i++;
            JOptionPane.showMessageDialog(this, "correct answers= " + count + "\n Result =" + (count*10) + "%");

            System.exit(0);
        }
    }

    // SET Questions with options
    void set() {
        radioButton[4].setSelected(true);
        if (current[i] == 0) {
            label.setText("Que1:  What is value of a in following expression? \n int a = 10 + 4.867; ?");
            radioButton[0].setText("a = 10");
            radioButton[1].setText("a = 14.867");
            radioButton[2].setText("a = 14");
            radioButton[3].setText("a = 4");
        }
        if (current[i] == 1) {
            label.setText("Que2: Which among the following is a Conditional Operator in C ?");
            radioButton[0].setText("?:");
            radioButton[1].setText(":?");
            radioButton[2].setText("<=");
            radioButton[3].setText(">=");
        }
        if (current[i] == 2) {
            label.setText("Que3: What is the Format specifier used to print a character in C.?");
            radioButton[0].setText("%s");
            radioButton[1].setText("%c");
            radioButton[2].setText("%C");
            radioButton[3].setText("%w");
        }
        if (current[i] == 3) {
            label.setText("Que4: What will be the output of the following program? \nint main() { \nint a,b,c,d,e,f,g,h,k;\na=8, b=4, c=2, d=1, e=5, f=20;  \n printf(%d,a+b-(c+d)*3%e+f/9);  \nreturn 0; \n}");
            radioButton[0].setText("10");
            radioButton[1].setText("9");
            radioButton[2].setText("8");
            radioButton[3].setText("20");
        }
        if (current[i] == 4) {
            label.setText("Que5: Which one of the following is a valid C expression?");
            radioButton[0].setText("int my_number=1000;");
            radioButton[1].setText("int my-number=1000");
            radioButton[2].setText("int my@number=1000");
            radioButton[3].setText("int @mynumber=1000");
        }
        if (current[i] == 5) {
            label.setText("Que6: What inbuilt function should be used to return a value rounded up to the next higher integer ?");
            radioButton[0].setText("Floor");
            radioButton[1].setText("Malloc");
            radioButton[2].setText("Puts");
            radioButton[3].setText("ceil");
        }
        if (current[i] == 6) {
            label.setText("Que7:  Which storage class is called as default storage class ?");
            radioButton[0].setText("auto");
            radioButton[1].setText("register");
            radioButton[2].setText("static");
            radioButton[3].setText("extern");
        }
        if (current[i] == 7) {
            label.setText("Que8:  Which among the following is an exit controlled loop ?");
            radioButton[0].setText("For");
            radioButton[1].setText("While");
            radioButton[2].setText("do....while");
            radioButton[3].setText("if....else");
        }
        if (current[i] == 8) {
            label.setText("Que9: Which of the following operators takes only integer operands?");
            radioButton[0].setText("+");
            radioButton[1].setText("*");
            radioButton[2].setText("/");
            radioButton[3].setText("%");
        }
        if (current[i] == 9) {
            label.setText("Que10: What is the output of the program.?\n int main()\n     {\n     float a = 45;\n     printf('%f', a);\n     return 0;\n    }");
            radioButton[0].setText("45");
            radioButton[1].setText("45.0");
            radioButton[2].setText("45.000000000");
            radioButton[3].setText("0.000000");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    // declare right answers.
    boolean check() {
        if (current[i] == 0)
            return (radioButton[2].isSelected());
        if (current[i] == 1)
            return (radioButton[0].isSelected());
        if (current[i] == 2)
            return (radioButton[1].isSelected());
        if (current[i] == 3)
            return (radioButton[0].isSelected());
        if (current[i] == 4)
            return (radioButton[0].isSelected());
        if (current[i] == 5)
            return (radioButton[3].isSelected());
        if (current[i] == 6)
            return (radioButton[0].isSelected());
        if (current[i] == 7)
            return (radioButton[2].isSelected());
        if (current[i] == 8)
            return (radioButton[3].isSelected());
        if (current[i] == 9)
            return (radioButton[2].isSelected());
        return false;
    }

    public static void main(String s[]) {

        Random rand = new Random();
        try {
            for (int i = 0; i < current.length; i++) {
                int randomIndexToSwap = rand.nextInt(current.length);
                int temp = current[randomIndexToSwap];
                current[randomIndexToSwap] = current[i];
                current[i] = temp;
            }
        }catch (Exception e){
            System.out.println("An error has occurred");
        }

        new OnlineTest("QUIZBEE");
    }

}
