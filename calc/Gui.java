import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    Gui(){
        setTitle("계산기");
        setSize(500,600);
        setLayout(new GridLayout(3,0));
        north();
        center();
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
        panel.add(persent);

        JButton clearEntry = new JButton("CE");
        panel.add(clearEntry);

        JButton clear = new JButton("C");
        panel.add(clear);

        JButton backSpace = new JButton("Backspace");
        panel.add(backSpace);

        JButton n7 = new JButton("7");
        panel.add(n7);

        JButton n8 = new JButton("8");
        panel.add(n8);

        JButton n9 = new JButton("9");
        panel.add(n9);

        JButton multiply = new JButton("X");
        panel.add(multiply);

        add(panel);
    }
}
