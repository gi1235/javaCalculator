import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class Gui extends JFrame{
    String result="";
    ArrayList<Integer> num1 = new ArrayList<>();
    ArrayList<Integer> num2 = new ArrayList<>();

    JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
    JButton equal;

    int num1Input = 0;

    JTextArea text;

    Font fontTest = new Font("Simsun 보통", Font.PLAIN, 20);
    //  https://m.blog.naver.com/10hsb04/221607286384 참조

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

        text = new JTextArea();
        text.setFont(fontTest);
        text.setText("0");
        text.setForeground(Color.red);
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

        n7 = new JButton("7");
        panel.add(setWhite(n7));

        n8 = new JButton("8");
        panel.add(setWhite(n8));

        n9 = new JButton("9");
        panel.add(setWhite(n9));

        JButton multiply = new JButton("×");
        panel.add(setGray(multiply));

        add(panel);
    }

    void south(){
        JPanel panel = new JPanel(new GridLayout(0,4,2,2));
        panel.setBackground(Color.lightGray);

        n4= new JButton("4");
        panel.add(setWhite(n4));

        n5 = new JButton("5");
        panel.add(setWhite(n5));

        n6 = new JButton("6");
        panel.add(setWhite(n6));

        JButton minus = new JButton("-");
        panel.add(setGray(minus));

        n1 = new JButton("1");
        panel.add(setWhite(n1));

        n2 = new JButton("2");
        panel.add(setWhite(n2));

        n3 = new JButton("3");
        panel.add(setWhite(n3));

        JButton plus = new JButton("+");
        panel.add(setGray(plus));

        JButton plusMinus = new JButton("+/-");
        panel.add(setWhite(plusMinus));

        n0 = new JButton("0");
        panel.add(setWhite(n0));

        JButton dot = new JButton(".");
        panel.add(setWhite(dot));

        equal = new JButton("=");
        equal.setBackground(Color.blue);
        equal.setForeground(Color.white);
        equal.addActionListener(listenerButton);
        panel.add(equal);

        add(panel);
    }


    public JButton setWhite(JButton a){
        a.setFont(fontTest);
        a.setBackground(Color.white);
        a.addActionListener(listenerButton);
        return a;
    }

    public JButton setGray(JButton a){
        a.setFont(fontTest);
        a.setBackground(Color.lightGray);
        a.addActionListener(listenerButton);
        return a;
    }

    ActionListener listenerButton = e ->{
        Object input = e.getSource();

        

        if (input==equal) {
            num1Input=1;
            for(int i=0;i<num1.size();i++) result+=num1.get(i);
            text.setText(result);
        }

        else if(num1Input==0){
            if (input == n1) num1.add(1);
            else if (input==n2) num1.add(2);
            else if (input==n3) num1.add(3);
            else if (input==n4) num1.add(4);
            else if (input==n5) num1.add(5);
            else if (input==n6) num1.add(6);
            else if (input==n7) num1.add(7);
            else if (input==n8) num1.add(8);
            else if (input==n9) num1.add(9);
            String outPut="";
            for(int i=0;i<num1.size();i++) outPut+=num1.get(i);
            text.setText(outPut);
        }

        else if(num1Input==1){

        }
    };

}

