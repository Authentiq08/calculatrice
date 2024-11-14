import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] funtionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel;

    //Font myFont = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
    Font myFont=new Font("Fira Code",Font.PLAIN,20);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Main(){
        frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");


        funtionButtons[0] = addButton;
        funtionButtons[1] = subButton;
        funtionButtons[2] = mulButton;
        funtionButtons[3] = divButton;
        funtionButtons[4] = decButton;
        funtionButtons[5] = eqButton;
        funtionButtons[6] = delButton;
        funtionButtons[7] = clrButton;
        funtionButtons[8] = negButton;


        for(JButton bu : funtionButtons){
            bu.addActionListener(this);
            bu.setFont(myFont);
            bu.setFocusable(false);
        }

        for(int i = 0; i < 10; ++i){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        //panel.setBackground(Color.gray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);



        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Main calc = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource()==eqButton){
            try{
               num2=Double.parseDouble(textField.getText());
               switch (operator){
                   case '+':
                       result=num1+num2;
                       break;

                   case '-':
                       result=num1-num2;
                       break;

                   case '*':
                       result=num1*num2;
                       break;

                   case '/':
                       result=num1/num2;
                       break;
               }
               textField.setText(String.valueOf(result));
               num1=result;
            }catch (Exception er){
                textField.setText("MATH ERROR");
            }

        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }

        if(e.getSource()==delButton){
            String str = textField.getText();
            str = str.substring(0, str.length()-1);
            textField.setText(str);
        }

        if(e.getSource()==negButton){
           double temp = Double.parseDouble(textField.getText());
           temp *= -1;
           textField.setText(String.valueOf(temp));
        }
    }
}