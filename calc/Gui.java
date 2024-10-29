import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class Gui extends JFrame{
    String result="";
    String output="";
    String inequality="";
    ArrayList<Integer> num1 = new ArrayList<>();
    ArrayList<Integer> num2 = new ArrayList<>();
    int num1Input = 0;

    JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
    JButton equal, plus, minus, division, squared, reciprocal;
    JButton clearEntry, clear, backSpace;

    JTextArea text;

    /*
     * @see https://m.blog.naver.com/10hsb04/221607286384
     * 글자의 폰트, 크기, 글꼴 조정
     */
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

    /*
     * 계산기의 윗부분 구현
     * 
     * @see chatgpt 를사용 setDisabledTextColor() 함수를 이용하여 변경불가능한 JTextArea 배경색 설정 
     */
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
        text.setForeground(getForeground());
        text.setDisabledTextColor(Color.black);
        text.setBackground(Color.lightGray);
        text.setEnabled(false);
        mainPanel.add(text);

        add(mainPanel);
    }

    /*
     * 계산기의 가운데 부분 구현
     */
    void center(){
        JPanel panel = new JPanel(new GridLayout(0,4,2,2));
        panel.setBackground(Color.lightGray);

        JButton persent = new JButton("%");
        panel.add(setGray(persent));

        clearEntry = new JButton("CE");
        panel.add(setGray(clearEntry));

        clear = new JButton("C");
        panel.add(setGray(clear));

        backSpace = new JButton("←");
        panel.add(setGray(backSpace));

        reciprocal = new JButton("1/x");
        panel.add(setGray(reciprocal));

        squared = new JButton("x^2");
        panel.add(setGray(squared));

        JButton root = new JButton("√x");
        panel.add(setGray(root));

        division = new JButton("÷");
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

    /*
     * 계산기의 아랫부분 구현
     */
    void south(){
        JPanel panel = new JPanel(new GridLayout(0,4,2,2));
        panel.setBackground(Color.lightGray);

        n4= new JButton("4");
        panel.add(setWhite(n4));

        n5 = new JButton("5");
        panel.add(setWhite(n5));

        n6 = new JButton("6");
        panel.add(setWhite(n6));

        minus = new JButton("-");
        panel.add(setGray(minus));

        n1 = new JButton("1");
        panel.add(setWhite(n1));

        n2 = new JButton("2");
        panel.add(setWhite(n2));

        n3 = new JButton("3");
        panel.add(setWhite(n3));

        plus = new JButton("+");
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

    /**
     * 입력된 버튼의 폰트, 배경색, 액션 리스너 추가
     * 
     * @param a 버튼을 입력받음
     * @return  버튼을 반환
     */
    public JButton setWhite(JButton a){
        a.setFont(fontTest);
        a.setBackground(Color.white);
        a.addActionListener(listenerButton);
        return a;
    }

    /**
     * 입력된 버튼의 폰트, 배경색, 액션 리스너 추가
     * 
     * @param a 버튼을 입력받음
     * @return  버튼을 반환
     */
    public JButton setGray(JButton a){
        a.setFont(fontTest);
        a.setBackground(Color.lightGray);
        a.addActionListener(listenerButton);
        return a;
    }

    /**
     * 액션리스너로 각각의 버튼을 누를때 알맞은 작동하도록 설계
     */
    ActionListener listenerButton = e ->{
        Object input = e.getSource();
        if (input==equal) {
            if(num1.isEmpty())  num1.add(0);
            if(num2.isEmpty())  num2.add(0);
            leftOutput();
            rightOutput();
            output+=" = ";
            output+=math(num1,num2,inequality);
            text.setText(output);
            num1 = new ArrayList<>();
            num1.add(Integer.parseInt(result));
        }

        else if(input == plus){
            num1Input=1;
            inequality="+";
            leftOutput();
            rightOutput();
            text.setText(output);
        }

        else if (input == minus){
            num1Input=1;
            inequality="-";
            leftOutput();
            rightOutput();
            text.setText(output);
        }

        else if(input == division){
            num1Input=1;
            inequality="÷";
            leftOutput();
            rightOutput();
            text.setText(output); 
        }

        else if (input == squared){
            num1Input=1;
            inequality="^";
            if(num2.isEmpty()) num2.add(2);
            leftOutput();
            rightOutput ();
            output+=" = ";
            output+=math(num1, num2, inequality);
            text.setText(output);
        }

        else if (input == reciprocal){
            inequality="1/x";
            output+="1/";
            for(int i=0;i<num1.size();i++) output+=num1.get(i);
            output+=" = ";
            output+=math(num1, num2, inequality);
            text.setText(output);
        }

        else if (input==clearEntry){
            if (num1Input==1){
                num2 = new ArrayList<>();
                leftOutput();
                rightOutput();
                text.setText(output);
            }
            else{
                num1 = new ArrayList<>();
                text.setText("0");
            }
        }

        else if (input == clear){
            num1Input=0;
            inequality="";
            num1 = new ArrayList<>();
            num2 = new ArrayList<>();
            text.setText("0");
        }

        else if (input == backSpace){
            if(num1Input==1 && !num2.isEmpty()){
                num2.remove(num2.size()-1);
                leftOutput();
                rightOutput();
                text.setText(output);
            }
            else if(num1Input==0 && !num1.isEmpty()){
                num1.remove(num1.size()-1);
                leftOutput();
            }
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
            else if (input==n0) num1.add(0);
            leftOutput();
            text.setText(output);
        }

        else if(num1Input == 1){
            if (input == n1) num2.add(1);
            else if (input==n2) num2.add(2);
            else if (input==n3) num2.add(3);
            else if (input==n4) num2.add(4);
            else if (input==n5) num2.add(5);
            else if (input==n6) num2.add(6);
            else if (input==n7) num2.add(7);
            else if (input==n8) num2.add(8);
            else if (input==n9) num2.add(9);
            else if (input==n0) num2.add(0);
            leftOutput();
            rightOutput();
            text.setText(output);
        }

    };
    
    /**
     * num1 과 num2 를 선택된 부등호를 사용하여 계산
     * 
     * @param num1  숫자로된 연결리스트
     * @param num2  숫자로된 연결리스트
     * @param inequality    문자열
     * @return  문자열로 된 계산결과 반환
     */
    String  math(ArrayList<Integer> num1, ArrayList<Integer> num2, String inequality){
        result="";
        String left = "";
        String right = "";
        for(int i=0;i<num1.size();i++) left+=num1.get(i);
        for(int i=0;i<num2.size();i++) right+=num2.get(i);
        if(inequality == "+"){
            result += Integer.parseInt(left) + Integer.parseInt(right);
            return result;
        }
        else if(inequality =="-"){
            result += Integer.parseInt(left) - Integer.parseInt(right);
            return result;
        }

        else if (inequality == "÷"){
            result += Float.parseFloat(left) /  Float.parseFloat(right);
            return result;
        }

        else if( inequality == "^"){
            result += Integer.parseInt(left) * Integer.parseInt(left);
            return result;
        }

        else if(inequality == "1/x"){
            result += 1/Float.parseFloat(left);
            return result;
        }
        return "0";
    }

    /**
     * 입력된 num1값을 출력하기 위한 함수
     */
    void leftOutput(){
        output="";
        if (num1.isEmpty())  output+="0";
        for(int i=0;i<num1.size();i++) output+=num1.get(i);
    }

    /**
     * 입력된 num2값을 출력해주기 위한 함수
     */
    void rightOutput(){
        output+=inequality;
        if(num2.isEmpty())  output+="0";
        for(int i=0;i<num2.size();i++) output+=num2.get(i);
    }
}

