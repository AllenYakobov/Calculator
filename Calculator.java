import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame jf;
	JTextField tf;
	JButton[] nums = new JButton[10]; // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	JButton[] operators = new JButton[8]; // +, -, *, /, ., =, delete, clear 
	JButton add, sub, mult, div, decimal, equal, clear, delete; 
	Font font = new Font("Times New Roman", Font.BOLD, 35);
	JPanel pan;
	
	char operator;
	double x = 0, y = 0, answer = 0;
	
	Calculator(){
		
		// JFrame
		jf = new JFrame("Calculator App");
		jf.setSize(400, 550);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JTextField
		tf = new JTextField();
		tf.setBounds(50, 25, 300, 50);
		tf.setFont(font);
		tf.setEditable(false);
		
		//
		add = new JButton("+");
		sub = new JButton("-");
		mult = new JButton("*");
		div = new JButton("/");
		decimal = new JButton(".");
		equal = new JButton("=");
		delete = new JButton("Delete");
		clear = new JButton("Clear");
		
		operators[0] = add;
		operators[1] = sub;
		operators[2] = mult;
		operators[3] = div;
		operators[4] = decimal;
		operators[5] = equal;
		operators[6] = delete;
		operators[7] = clear; 
		
		for (int i = 0; i < 8; i++) {
			operators[i].addActionListener(this);
			operators[i].setFont(font);
			operators[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i++) {
			nums[i] = new JButton(String.valueOf(i));
			nums[i].addActionListener(this);
			nums[i].setFont(font);
			nums[i].setFocusable(false);
		}
		
		delete.setBounds(50, 430, 145, 50);
		clear.setBounds(205, 430, 145, 50);
		
		pan = new JPanel();
		pan.setBounds(50, 100, 300, 300);
		pan.setLayout(new GridLayout(4, 4, 10, 10));

		pan.add(nums[1]);
		pan.add(nums[2]);
		pan.add(nums[3]);
		pan.add(add);
		pan.add(nums[4]);
		pan.add(nums[5]);
		pan.add(nums[6]);
		pan.add(sub);
		pan.add(nums[7]);
		pan.add(nums[8]);
		pan.add(nums[9]);
		pan.add(mult);
		pan.add(decimal);
		pan.add(nums[0]);
		pan.add(equal);
		pan.add(div);
		
		jf.add(pan); 
		jf.add(delete);
		jf.add(clear);
		jf.add(tf);
		jf.setVisible(true);

	}
	//public static void main(String[] args) {
		
		//Calculator calc = new Calculator();
	//}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == nums[i]) {
				tf.setText(tf.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decimal) {
			tf.setText(tf.getText().concat("."));
		}
		if (e.getSource() == add) {
			x = Double.parseDouble(tf.getText());
			operator = '+';
			tf.setText("");
		}
		if (e.getSource() == sub) {
			x = Double.parseDouble(tf.getText());
			operator = '-';
			tf.setText("");
		}
		if (e.getSource() == mult) {
			x = Double.parseDouble(tf.getText());
			operator = '*';
			tf.setText("");
		}
		if (e.getSource() == div) {
			x = Double.parseDouble(tf.getText());
			operator = '/';
			tf.setText("");
		}
		if (e.getSource() == equal) {
			y = Double.parseDouble(tf.getText());
			
			switch(operator) {
			case'+':
				answer = x + y;
				break;
			case'-':
				answer = x - y;
				break;
			case'*':
				answer = x * y;
				break;
			case'/':
				answer = x / y;
				break;
			}
			tf.setText(String.valueOf(answer));
			x = answer;
		}
		if (e.getSource() == clear) {
			tf.setText("");
		}
		if (e.getSource() == delete) {
			String string = tf.getText();
			tf.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				tf.setText(tf.getText() + string.charAt(i));
			}
		}
	}
}
