import java.awt.*;
import javax.swing.*;


public class Gui extends JFrame{
    Gui(){
        setTitle("계산기");
        setSize(500,600);
        setLayout(new GridLayout(3,0));

        north();
        center();
        south();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void north(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JPanel panel = new JPanel();
        JButton option = new JButton("설정");
        JLabel basic = new JLabel("표준");
        panel.add(option);
        panel.add(basic);
        mainPanel.add("North", panel);

        JTextArea text = new JTextArea();
        text.setEnabled(false);
        mainPanel.add(text);

        add(mainPanel);
    }

    void center(){
        JPanel panel = new JPanel(new GridLayout(0,4));

        JButton persent = new JButton("%");
        persent.setBackground(Color.LIGHT_GRAY);
        panel.add(persent);

        JButton clearEntry = new JButton("CE");
        clearEntry.setBackground(Color.LIGHT_GRAY);
        panel.add(clearEntry);

        JButton clear = new JButton("C");
        clear.setBackground(Color.LIGHT_GRAY);
        panel.add(clear);

        JButton backSpace = new JButton("Backspace");
        backSpace.setBackground(Color.LIGHT_GRAY);
        panel.add(backSpace);

        JButton n7 = new JButton("7");
        n7.setBackground(Color.white);
        panel.add(n7);

        JButton n8 = new JButton("8");
        n8.setBackground(Color.white);
        panel.add(n8);

        JButton n9 = new JButton("9");
        n9.setBackground(Color.white);
        panel.add(n9);

        JButton multiply = new JButton("X");
        multiply.setBackground(Color.LIGHT_GRAY);
        panel.add(multiply);

        add(panel);
    }

    void south(){
        JPanel panel = new JPanel(new GridLayout(0,4));

        JButton n4= new JButton("4");
        n4.setBackground(Color.white);
        panel.add(n4);

        JButton n5 = new JButton("5");
        n5.setBackground(Color.white);
        panel.add(n5);

        JButton n6 = new JButton("6");
        n6.setBackground(Color.white);
        panel.add(n6);

        JButton minus = new JButton("-");
        minus.setBackground(Color.LIGHT_GRAY);
        panel.add(minus);

        JButton n1 = new JButton("1");
        n1.setBackground(Color.white);
        panel.add(n1);

        JButton n2 = new JButton("2");
        n2.setBackground(Color.white);
        panel.add(n2);

        JButton n3 = new JButton("3");
        n3.setBackground(Color.white);
        panel.add(n3);

        JButton plus = new JButton("+");
        plus.setBackground(Color.LIGHT_GRAY);
        panel.add(plus);

        JButton plusMinus = new JButton("±");
        plusMinus.setBackground(Color.white);
        panel.add(plusMinus);

        JButton n0 = new JButton("0");
        n0.setBackground(Color.white);
        panel.add(n0);

        JButton dot = new JButton(".");
        dot.setBackground(Color.white);
        panel.add(dot);

        JButton equal = new JButton("=");
        equal.setBackground(Color.blue);
        equal.setForeground(Color.white);
        panel.add(equal);

        add(panel);
    }
}

