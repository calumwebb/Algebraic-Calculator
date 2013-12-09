package main;

import java.awt.EventQueue;
import java.math.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;

@SuppressWarnings({ "serial", "unused" })
public class calculatorScreen extends JFrame {
	
	// console variables
	static String info = "[Information] ";
	static String a = ": ";
	
	
	// calculator variables
	private JPanel CalculatorPane;
	private JTextField ansField;
	private int clearField;
	private int addClick = 0, subClick = 0, multiClick = 0, divClick = 0, sinClick = 0, cosClick = 0, tanClick  = 0;
	private int xPowTwoClick = 0, xPowThreeClick = 0, xPowYClick = 0, overXClick = 0, exClick = 0, factClick = 0;
	private int eClick = 0, piClick = 0, tenXClick = 0, sqrtXClick = 0, logClick = 0, randClick = 0; 
	private static double num1, num2, ans;
	private static double plusMinus;
	private final JPanel panel = new JPanel();
	public static calculatorScreen calcframe = new calculatorScreen();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				init();
			}
		});
	}

	public static void init() {
		try {
			calcframe.setLocationRelativeTo(null);
			calcframe.setResizable(false);
			calcframe.setUndecorated(false);
			calcframe.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public calculatorScreen(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
		    public void windowClosing(WindowEvent we){
		        dispose();
		    }
		});
		setBounds(100, 100, 366, 348);
		CalculatorPane = new JPanel();
		CalculatorPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CalculatorPane);
		CalculatorPane.setLayout(null);
		
		ansField = new JTextField();
		ansField.setHorizontalAlignment(SwingConstants.RIGHT);
		ansField.setText("");
		ansField.setFont(new Font("Myriad Pro", Font.PLAIN, 26));
		ansField.setBounds(6, 6, 354, 56);
		CalculatorPane.add(ansField);
		ansField.setColumns(10);
		panel.setBounds(6, 62, 355, 264);
		CalculatorPane.add(panel);
		panel.setLayout(null);
		
		JButton sinButton = new JButton("Sin");
		sinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ansField.getText().equals("")) {
				} else {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					sinClick = 1;
					clearField = 1;
				}
			}
		});
		sinButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		sinButton.setBounds(6, 6, 48, 48);
		panel.add(sinButton);
		
		JButton cosButton = new JButton("Cos");
		cosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ansField.getText().equals("")) {
				} else {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					cosClick = 1;
					clearField = 1;
				}
			}
		});
		cosButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		cosButton.setBounds(55, 6, 48, 48);
		panel.add(cosButton);
		
		JButton tanButton = new JButton("Tan");
		tanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ansField.getText().equals("")) {
				} else {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					tanClick = 1;
					clearField = 1;
				}
			}
		});
		tanButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		tanButton.setBounds(105, 6, 48, 48);
		panel.add(tanButton);
		
		JButton clearButton = new JButton("AC");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ansField.setText("");
				num1 = 0;
				num2 = 0;
				addClick = 0;
				subClick = 0;
				multiClick = 0;
				divClick = 0;
				sinClick = 0;
				cosClick = 0;
				tanClick = 0;
				xPowTwoClick = 0;
				xPowThreeClick = 0;
				xPowYClick = 0;
				overXClick = 0;
				exClick = 0;
				factClick = 0;
				eClick = 0;
				piClick = 0;
				tenXClick = 0;
				sqrtXClick = 0;
				logClick = 0;
				randClick = 0;
				clearField = 0;
				}
		});
		clearButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		clearButton.setBounds(154, 6, 96, 48);
		panel.add(clearButton);
		
		JButton plusminusButton = new JButton("+/-");
		plusminusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ansField.getText().equals("") || ansField.getText().equals("-")) {
					ansField.setText("-");
				} else {
					plusMinus = (Double.parseDouble(String.valueOf(ansField.getText())));
					plusMinus*= -1;
					ansField.setText(String.valueOf(plusMinus));
				}
			}
		});
		plusminusButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		plusminusButton.setBounds(253, 6, 48, 48);
		panel.add(plusminusButton);
		
		JButton divButton = new JButton("/");
		divButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText() != null) {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					divClick = 1;
					clearField = 1;
				}
			}
		});
		divButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		divButton.setBounds(303, 6, 48, 48);
		panel.add(divButton);
		
		JButton multiplyButton = new JButton("x");
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText() != null) {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					multiClick = 1;
					clearField = 1;
				}
			}
		});
		multiplyButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		multiplyButton.setBounds(303, 58, 48, 48);
		panel.add(multiplyButton);
		
		JButton nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("9");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "9");
					}
				}
			}
		});
		nineButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		nineButton.setBounds(253, 58, 48, 48);
		panel.add(nineButton);
		
		JButton eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("8");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "8");
					}
				}
			}
		});
		eightButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		eightButton.setBounds(204, 58, 48, 48);
		panel.add(eightButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("7");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "7");
					}
				}
			}
		});
		sevenButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		sevenButton.setBounds(154, 58, 48, 48);
		panel.add(sevenButton);
		
		JButton tenPowerButton = new JButton("10x");
		tenPowerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(String.valueOf(ansField.getText()));
				tenXClick = 1;
				clearField = 1;
			}
		});
		tenPowerButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		tenPowerButton.setBounds(105, 58, 48, 48);
		panel.add(tenPowerButton);
		
		JButton ePowerButton = new JButton("eX");
		ePowerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(String.valueOf(ansField.getText()));
				exClick = 1;
				clearField = 1;
			}
		});
		ePowerButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		ePowerButton.setBounds(55, 58, 48, 48);
		panel.add(ePowerButton);
		
		JButton xSqrdButton = new JButton("x^2");
		xSqrdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(String.valueOf(ansField.getText()));
				xPowTwoClick = 1;
				clearField = 1;
			}
		});
		xSqrdButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		xSqrdButton.setBounds(6, 58, 48, 48);
		panel.add(xSqrdButton);
		
		JButton xCbedButton = new JButton("x^3");
		xCbedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(String.valueOf(ansField.getText()));
				xPowThreeClick = 1;
				clearField = 1;
			}
		});
		xCbedButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		xCbedButton.setBounds(6, 110, 48, 48);
		panel.add(xCbedButton);
		
		JButton factButton = new JButton("x!");
		factButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(String.valueOf(ansField.getText()));
				factClick = 1;
				clearField = 1;
				
			}
		});
		factButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		factButton.setBounds(55, 110, 48, 48);
		panel.add(factButton);
		
		JButton sqrtButton = new JButton("/x");
		sqrtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(String.valueOf(ansField.getText()));
				sqrtXClick = 1;
				clearField = 1;
			}
		});
		sqrtButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		sqrtButton.setBounds(105, 110, 48, 48);
		panel.add(sqrtButton);
		
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("4");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "4");
					}
				}
			}
		});
		fourButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		fourButton.setBounds(154, 110, 48, 48);
		panel.add(fourButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("5");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "5");
					}
				}
			}
		});
		fiveButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		fiveButton.setBounds(204, 110, 48, 48);
		panel.add(fiveButton);
		
		JButton sixButton = new JButton("6");
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("6");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "6");
					}
				}
			}
		});
		sixButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		sixButton.setBounds(253, 110, 48, 48);
		panel.add(sixButton);
		
		JButton minisButton = new JButton("-");
		minisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText() != null) {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					subClick = 1;
					clearField = 1;
				}
			}
		});
		minisButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		minisButton.setBounds(303, 110, 48, 48);
		panel.add(minisButton);
		
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText() != null) {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					addClick = 1;
					clearField = 1;
				}
			}
		});
		plusButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		plusButton.setBounds(303, 162, 48, 48);
		panel.add(plusButton);
		
		JButton threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("3");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "3");
					}
				}
			}
		});
		threeButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		threeButton.setBounds(253, 162, 48, 48);
		panel.add(threeButton);
		
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("2");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "2");
					}
				}
			}
		});
		twoButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		twoButton.setBounds(204, 162, 48, 48);
		panel.add(twoButton);
		
		JButton oneButton = new JButton("1");
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("1");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "1");
					}
				}
			}
		});
		oneButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		oneButton.setBounds(154, 162, 48, 48);
		panel.add(oneButton);
		
		JButton eButton = new JButton("e");
		eButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ansField.setText("2.718281828459045");
			}
		});
		eButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		eButton.setBounds(55, 162, 48, 48);
		panel.add(eButton);
		
		JButton xyButton = new JButton("x^y");
		xyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (xPowYClick == 0) {
					num1 = Double.parseDouble(String.valueOf(ansField.getText()));
					xPowYClick = 1;
				} else if (xPowYClick == 1) {
					num2 = Double.parseDouble(String.valueOf(ansField.getText()));
				}
				clearField = 1;
			}
		});
		xyButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		xyButton.setBounds(6, 162, 48, 48);
		panel.add(xyButton);
		
		JButton oneoverButton = new JButton("1/x");
		oneoverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(String.valueOf(ansField.getText()));
				overXClick = 1;
				clearField = 1;
			}
		});
		oneoverButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		oneoverButton.setBounds(6, 214, 48, 48);
		panel.add(oneoverButton);
		
		JButton piButton = new JButton("pi");
		piButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ansField.setText(Double.toString(Math.PI));
			}
		});
		piButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		piButton.setBounds(55, 214, 48, 48);
		panel.add(piButton);
		
		JButton randButton = new JButton("ra");
		randButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		randButton.setBounds(105, 214, 48, 48);
		panel.add(randButton);
		
		JButton logButton = new JButton("log");
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		logButton.setBounds(105, 162, 48, 48);
		panel.add(logButton);
		
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ansField.getText().length() < 16) {
					if (clearField == 1) {
						ansField.setText("0");
						clearField = 0;
					} else {
						ansField.setText(ansField.getText() + "0");
					}
				}
			}
		});
		zeroButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		zeroButton.setBounds(154, 214, 96, 48);
		panel.add(zeroButton);
		
		JButton decButton = new JButton(".");
		decButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ansField.getText().contains(".")) {
					ansField.setText(ansField.getText());
				} else {
					ansField.setText(ansField.getText() + ".");
				}
			}
		});
		decButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		decButton.setBounds(253, 214, 48, 48);
		panel.add(decButton);
		
		JButton equalButton = new JButton("=");
		equalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num2 = Double.parseDouble(String.valueOf(ansField.getText()));
				ansField.setText(ansField.getText());
				
				if (addClick == 1) {
					ans = num1 + num2;
				}
				if (subClick == 1) {
					ans = num1 - num2;
				}
				if (divClick == 1) {
					ans = num1 / num2; 
				}
				if (multiClick == 1) {
					ans = num1 * num2;
				}
				// sin cos and tan
				if (sinClick == 1) {
					ans = (Math.sin(Math.toRadians(num1)));
				}
				if (cosClick == 1) {
					ans = Math.cos(Math.toRadians(num1));
				}
				if (tanClick == 1) {
					ans = Math.tan(Math.toRadians(num1));
				}
				// x^2, x^3, x^y and 1/x
				if (xPowTwoClick == 1) {
					ans = Math.pow(num1, 2);
				}
				if (xPowThreeClick == 1) {
					ans = Math.pow(num1, 3);
				}
				if (xPowYClick == 1) {
					ans = Math.pow(num1, num2);
				}
				if (overXClick == 1) {
					ans = 1 / num1;
				}
				if (factClick == 1) {
				}
				
				
				
				// ending of the equals class
				ansField.setText(String.valueOf(ans));
				clearField = 1;
				
				num1 = 0;
				num2 = 0;
				addClick = 0;
				subClick = 0;
				multiClick = 0;
				divClick = 0;
				sinClick = 0;
				cosClick = 0;
				tanClick = 0;
				xPowTwoClick = 0;
				xPowThreeClick = 0;
				xPowYClick = 0;
				overXClick = 0;
				exClick = 0;
				factClick = 0;
				eClick = 0;
				piClick = 0;
				tenXClick = 0;
				sqrtXClick = 0;
				logClick = 0;
				randClick = 0;
			}
		});
		equalButton.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		equalButton.setBounds(303, 214, 48, 48);
		panel.add(equalButton);
	}
	
}
