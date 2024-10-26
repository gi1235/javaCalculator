import java.awt.*;
import javax.swing.*;


public class Gui extends JFrame{
    Font fontTest = new Font("Simsun 보통", Font.PLAIN, 20);
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
        panel.setBackground(Color.lightGray);
        JButton option = new JButton("설정");
        JLabel basic = new JLabel("표준");
        panel.add(option);
        panel.add(basic);
        mainPanel.add("North", panel);

        JTextArea text = new JTextArea();
        text.setBackground(Color.lightGray);
        text.setEnabled(false);
        mainPanel.add(text);

        add(mainPanel);
    }

    void center(){
        JPanel panel = new JPanel(new GridLayout(0,4,2,2));
        panel.setBackground(Color.lightGray);

        JButton persent = new JButton("%");
        panel.add(setGray(persent));

        JButton clearEntry = new JButton("CE");
        panel.add(setGray(clearEntry));

        JButton clear = new JButton("C");
        panel.add(setGray(clear));

        JButton backSpace = new JButton("←");
        panel.add(setGray(backSpace));

        JButton reciprocal = new JButton("1/x");
        panel.add(setGray(reciprocal));

        JButton squared = new JButton("x^2");
        panel.add(setGray(squared));

        JButton root = new JButton("√x");
        panel.add(setGray(root));

        JButton division = new JButton("÷");
        panel.add(setGray(division));

        JButton n7 = new JButton("7");
        panel.add(setWhite(n7));

        JButton n8 = new JButton("8");
        panel.add(setWhite(n8));

        JButton n9 = new JButton("9");
        panel.add(setWhite(n9));

        JButton multiply = new JButton("×");
        panel.add(setGray(multiply));

        add(panel);
    }

    void south(){
        JPanel panel = new JPanel(new GridLayout(0,4,2,2));
        panel.setBackground(Color.lightGray);

        JButton n4= new JButton("4");
        panel.add(setWhite(n4));

        JButton n5 = new JButton("5");
        panel.add(setWhite(n5));

        JButton n6 = new JButton("6");
        panel.add(setWhite(n6));

        JButton minus = new JButton("-");
        panel.add(setGray(minus));

        JButton n1 = new JButton("1");
        panel.add(setWhite(n1));

        JButton n2 = new JButton("2");
        panel.add(setWhite(n2));

        JButton n3 = new JButton("3");
        panel.add(setWhite(n3));

        JButton plus = new JButton("+");
        panel.add(setGray(plus));

        JButton plusMinus = new JButton("±");
        panel.add(setWhite(plusMinus));

        JButton n0 = new JButton("0");
        panel.add(setWhite(n0));

        JButton dot = new JButton(".");
        panel.add(setWhite(dot));

        JButton equal = new JButton("=");
        equal.setBackground(Color.blue);
        equal.setForeground(Color.white);
        panel.add(equal);

        add(panel);
    }


    public JButton setWhite(JButton a){
        a.setFont(fontTest);
        a.setBackground(Color.white);
        return a;
    }

    public JButton setGray(JButton a){
        a.setFont(fontTest);
        a.setBackground(Color.lightGray);
        return a;
    }
}

