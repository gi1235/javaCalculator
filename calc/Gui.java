import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    Gui(){
        setTitle("계산기");
        setSize(400,600);
        setLayout(new GridLayout(3,0));
        north();

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
}
