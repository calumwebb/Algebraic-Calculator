package main;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import backend.Pi;
import backend.QuadraticEquation;
import backend.Sort;
import backend.TrigonometricFunctions;

import javax.swing.JRadioButton;

@SuppressWarnings("serial")

public class mainScreen extends JFrame {
	
	private JPanel cards;
	private JTextField PiEnterField;
	private JTextField quad3TextField;
	private JTextField quad2TextField;
	private JTextField quad1TextField;
	
	// console variables
	static String newLine = "\n";
	static String info = "[Information] ";
	static String a = ": ";
	static String error = "[error] " + time() + ": ";
	static String function = "[Function] ";
	
	// calculator variables
	
	// pi variables
	Pi pi = new Pi();
	int PiNth;
	BigDecimal Pi;
	BigDecimal PiTemp;
	
	// main Screen variables
	static mainScreen frame = new mainScreen();
	
	// quadratic variables
	QuadraticEquation quad = new QuadraticEquation();
	Double qa, qb, qc;
	String quadRoot2, quadRoot1;
	
	// Sorting variables
	Sort sort = new Sort();
	String sortString;
	int[] numbers;
	private JTextField txtEnterSine;
	private JTextField txtEnterCosine;
	private JTextField txtEnterTan;
	
	// Trig variables
	TrigonometricFunctions trig = new TrigonometricFunctions();
	String textfield;
	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		long elapsedTime;
		setOut();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					loadingScreen.init();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setUndecorated(false);
					frame.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		loadingScreen.progFake();
		loadingScreen.forceShutdown();
		frame.setVisible(true);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(info + time() + a + "Algebraic Calculator has been successfully loaded!");
		System.out.println(info + time() + a + elapsedTime + " milliseconds to load the application");
	}
	
	
	
	public mainScreen() {
		

		setTitle("Algebriac Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(info + time() + a + "application closed");
				System.exit(0);
			}
		});
		mnFile.add(mntmClose);
		
		JMenu mnFunctions = new JMenu("Navigation");
		menuBar.add(mnFunctions);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
	            cl.show(cards, "SPLASHSCREEN");
	            System.out.println(info + time() + a + "Home Panel loaded");
			}
		});
		mnFunctions.add(mntmHome);
		
		JSeparator separator = new JSeparator();
		mnFunctions.add(separator);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculatorScreen.init();
				System.out.println(info + time() + a + "Calculator Window loaded");
			}
		});
		mnFunctions.add(mntmCalculator);
		
		JSeparator separator_4 = new JSeparator();
		mnFunctions.add(separator_4);
		
		JMenu mnNthDigit = new JMenu("Nth Digit");
		mnFunctions.add(mnNthDigit);
		
		JMenuItem mntmPiNthDigit = new JMenuItem("Pi to Nth Digit");
		mnNthDigit.add(mntmPiNthDigit);
		
		JMenuItem mntmEToNth = new JMenuItem("e to Nth Digit");
		mnNthDigit.add(mntmEToNth);
		mntmEToNth.setEnabled(false);
		mntmPiNthDigit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (cards.getLayout());
	            cl.show(cards, "PiPanel");
	            System.out.println(info + time() + a + "Pi Panel loaded");
			}
		});
		
		JMenu mnSolvers = new JMenu("Solvers");
		mnFunctions.add(mnSolvers);
		
		JMenuItem mntmQuadratic = new JMenuItem("Quadratic Equations");
		mnSolvers.add(mntmQuadratic);
		
		JMenuItem mntmCubicEquations = new JMenuItem("Cubic Equations");
		mnSolvers.add(mntmCubicEquations);
		mntmQuadratic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (cards.getLayout());
	            cl.show(cards, "QuadraticPanel");
	            System.out.println(info + time() + a + "Quadratic Equation Panel loaded");
			}
		});
		
		JMenu mnExtras = new JMenu("Extras");
		mnFunctions.add(mnExtras);
		
		JMenuItem mntmSorting = new JMenuItem("Sorting");
		mnExtras.add(mntmSorting);
		
		JMenuItem mntmBinaryConverter = new JMenuItem("Binary Converter");
		mnExtras.add(mntmBinaryConverter);
		mntmBinaryConverter.setEnabled(false);
		
		JMenuItem mntmTrigonometry = new JMenuItem("Trigonometry");
		mnExtras.add(mntmTrigonometry);
		mntmTrigonometry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (cards.getLayout());
	            cl.show(cards, "TrigPanel");
	            System.out.println(info + time() + a + "Trigonometry Panel loaded");
			}
		});
		mntmSorting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (cards.getLayout());
	            cl.show(cards, "SortingPanel");
	            System.out.println(info + time() + a + "Sorting Panel loaded");
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnFunctions.add(separator_1);
		
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mntmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
	            cl.show(cards, "Info");
	            System.out.println(info + time() + a + "Information Panel loaded");
			}
		});
		mnHelp.add(mntmInfo);
		
		cards = new JPanel();
		cards.setBorder(null);
		setContentPane(cards);
		cards.setLayout(new CardLayout(0, 0));
		
		JPanel SPLASHSCREEN = new JPanel();
		cards.add(SPLASHSCREEN, "SPLASHSCREEN");
		SPLASHSCREEN.setLayout(null);
		
		JPanel Info = new JPanel();
		cards.add(Info, "Info");
		Info.setLayout(null);
				
		JLabel Information = new JLabel("");
		Information.setEnabled(false);
		Information.setToolTipText("");
		Information.setIcon(new ImageIcon(mainScreen.class.getResource("/res/info.png")));
		Information.setBounds(6, 6, 888, 516);
		Info.add(Information);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(mainScreen.class.getResource("/res/splashscreen1.png")));
		Logo.setBounds(6, 38, 889, 462);
		SPLASHSCREEN.add(Logo);
		
		
		JPanel PiPanel = new JPanel();
		cards.add(PiPanel, "PiPanel");
		PiPanel.setLayout(null);
		final JScrollPane PiScrollPane = new JScrollPane();
		PiScrollPane.setBounds(6, 137, 888, 365);
		PiPanel.add(PiScrollPane);
		
		JButton btnGeneratePi = new JButton("GENERATE");
		btnGeneratePi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long start;
				long finish;
				start = System.currentTimeMillis();
				
				PiNth = Integer.parseInt(PiEnterField.getText());
				final JTextArea PiTextArea = new JTextArea();
				PiTextArea.setFont(new Font("Myriad Pro", Font.PLAIN, 13));
				PiTextArea.setText(pi.piAlg(PiNth));
				PiTextArea.setLineWrap(true);
				PiScrollPane.setViewportView(PiTextArea);
				finish = (System.currentTimeMillis() - start);
				System.out.println(function + time() + a + PiNth + " digits of Pi were calculated in " + finish + " milliseconds");
			}
		});
		

		btnGeneratePi.setBounds(735, 82, 117, 43);
		PiPanel.add(btnGeneratePi);
		
		PiEnterField = new JTextField();
		PiEnterField.setHorizontalAlignment(SwingConstants.CENTER);
		PiEnterField.setFont(new Font("Myriad Pro", Font.PLAIN, 31));
		PiEnterField.setBounds(408, 84, 300, 41);
		PiPanel.add(PiEnterField);
		PiEnterField.setColumns(10);
		
		
		JLabel PiTitle = new JLabel("");
		PiTitle.setIcon(new ImageIcon(mainScreen.class.getResource("/res/piTitleBar.png")));
		PiTitle.setBounds(6, 6, 888, 287);
		PiPanel.add(PiTitle);
		
		JPanel QuadraticPanel = new JPanel();
		cards.add(QuadraticPanel, "QuadraticPanel");
		QuadraticPanel.setLayout(null);
		
		quad3TextField = new JTextField();
		quad3TextField.setHorizontalAlignment(SwingConstants.RIGHT);
		quad3TextField.setFont(new Font("Myriad Pro", Font.PLAIN, 50));
		quad3TextField.setBounds(641, 163, 143, 69);
		QuadraticPanel.add(quad3TextField);
		quad3TextField.setColumns(10);
		
		quad2TextField = new JTextField();
		quad2TextField.setHorizontalAlignment(SwingConstants.RIGHT);
		quad2TextField.setFont(new Font("Myriad Pro", Font.PLAIN, 50));
		quad2TextField.setColumns(10);
		quad2TextField.setBounds(386, 163, 143, 69);
		QuadraticPanel.add(quad2TextField);
		
		quad1TextField = new JTextField();
		quad1TextField.setHorizontalAlignment(SwingConstants.RIGHT);
		quad1TextField.setFont(new Font("Myriad Pro", Font.PLAIN, 50));
		quad1TextField.setColumns(10);
		quad1TextField.setBounds(118, 163, 143, 69);
		QuadraticPanel.add(quad1TextField);
		
	
		
		final JTextPane SortingscrollPane = new JTextPane();
		SortingscrollPane.setBounds(153, 294, 597, 219);
		QuadraticPanel.add(SortingscrollPane);
		SortingscrollPane.setText("\n");
		SortingscrollPane.setEditable(false);
		SortingscrollPane.setFont(new Font("Myriad Pro", Font.PLAIN, 19));
		JButton btnNewButton = new JButton("Solve");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					qc = Double.parseDouble(quad3TextField.getText());
					qb = Double.parseDouble(quad2TextField.getText());
					qa = Double.parseDouble(quad1TextField.getText());
					
					String equation = qa.intValue() + "x^2+" + qb.intValue() + "x+" + qc.intValue();
					quadRoot1 = QuadraticEquation.QuadPlus(qa, qb, qc);
					quadRoot2 = QuadraticEquation.QuadNeg(qa, qb, qc);
					
					if (quadRoot1 == "There are no real roots") {
						SortingscrollPane.setText("There are no real roots for the equation: " + equation );
						System.out.println(function + time() + a + equation + " can not be solved, as there are no real roots in this equation");
					} else { 
						double discr = qb*qb - 4*qa*qc; 
						double sumRoot = -qb/qa;
						double proRoot = qc/qa;
					SortingscrollPane.setText("Roots: " + quadRoot1 + quadRoot2 + "\nDiscriminant: " + discr + "\nSum of Roots: " + sumRoot + "\nProduct of Roots: " + proRoot);
					System.out.println(function + time() + a + equation + " was solved with the roots " + quadRoot1 + quadRoot2);
				}
			}
		});
		btnNewButton.setBounds(128, 253, 645, 29);
		QuadraticPanel.add(btnNewButton);
		
		JLabel QuadEquationTitle = new JLabel("");
		QuadEquationTitle.setFont(new Font("Myriad Pro", Font.PLAIN, 16));
		QuadEquationTitle.setHorizontalAlignment(SwingConstants.CENTER);
		QuadEquationTitle.setIcon(new ImageIcon(mainScreen.class.getResource("/res/QuadEquation1.png")));
		QuadEquationTitle.setBounds(0, 0, 900, 550);
		QuadraticPanel.add(QuadEquationTitle);
		
		JPanel SortingPanel = new JPanel();
		cards.add(SortingPanel, "SortingPanel");
		SortingPanel.setLayout(null);
		
		JComboBox SortComboBox = new JComboBox();
		SortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Bubble Sort"}));
		SortComboBox.setBounds(98, 165, 216, 27);
		SortingPanel.add(SortComboBox);
		
		final JComboBox OrderComboBox = new JComboBox();
		OrderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Ascending", "Descending"}));
		OrderComboBox.setBounds(605, 165, 216, 27);
		SortingPanel.add(OrderComboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 247, 888, 303);
		SortingPanel.add(scrollPane);
		
		final JTextArea SortInputTextArea = new JTextArea();
		SortInputTextArea.setLineWrap(true);
		SortInputTextArea.setWrapStyleWord(true);
		scrollPane.setViewportView(SortInputTextArea);
		cards.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{SPLASHSCREEN, Info, Information, Logo, PiPanel}));
		
		JButton SortButton = new JButton("Sort List");
		SortButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		SortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String order = OrderComboBox.getSelectedItem().toString();
				sortString = SortInputTextArea.getText();
				if (order == "Ascending") {
					numbers = Sort.BubbleSortA(sortString);
						SortInputTextArea.getText();
						SortInputTextArea.setText("");
					for (int i = 0; i < numbers.length; i++ ) {
						SortInputTextArea.append(Integer.toString(numbers[i]) + " ");
					}
					System.out.println(function + time() + a +  "Sorted " + numbers.length + " numbers using bubble sort in ascending order");
				} else {
					numbers = Sort.BubbleSortD(sortString);
					SortInputTextArea.getText();
					SortInputTextArea.setText("");
				for (int i = 0; i < numbers.length; i++ ) {
					SortInputTextArea.append(Integer.toString(numbers[i]) + " ");
				}
				System.out.println(function + time() + a +  "Sorted " + numbers.length + " numbers using bubble sort in descending order");
				}
			}
		});
		SortButton.setBounds(673, 6, 189, 40);
		SortingPanel.add(SortButton);
		
		JButton btnRandomNumbers = new JButton("Random Numbers");
		btnRandomNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				SortInputTextArea.setText("");
				int randomNumbers = (int) (Math.random() * 1000);
				for (int i = 0; i < randomNumbers; i ++) {
					int random = (int) (Math.random() * 100000);
					SortInputTextArea.append(random + " ");	
				}
				System.out.println(function + time() + a + randomNumbers + " random numbers where generated to sort");
			}
		});
		btnRandomNumbers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRandomNumbers.setBounds(673, 52, 189, 21);
		SortingPanel.add(btnRandomNumbers);
		
		JLabel SortingTitle = new JLabel("");
		SortingTitle.setIcon(new ImageIcon(mainScreen.class.getResource("/res/SortingTitleHeader.png")));
		SortingTitle.setBounds(6, 6, 888, 243);
		SortingPanel.add(SortingTitle);
		
		JPanel ConsolePanel = new JPanel();
		cards.add(ConsolePanel, "ConsolePanel");
		ConsolePanel.setLayout(null);

		JScrollPane ConsoleScrollPane = new JScrollPane();
		ConsoleScrollPane.setBounds(6, 6, 888, 544);
		ConsolePanel.add(ConsoleScrollPane);
		
		final JTextArea ConsoleTextArea = new JTextArea();
		ConsoleTextArea.setEditable(false);
		ConsoleTextArea.setLineWrap(true);
		ConsoleTextArea.setFont(new Font("Myriad Pro", Font.PLAIN, 21));
		ConsoleScrollPane.setViewportView(ConsoleTextArea);
		
		JPanel TrigPanel = new JPanel();
		cards.add(TrigPanel, "TrigPanel");
		TrigPanel.setLayout(null);
		
		
		txtEnterSine = new JTextField();
		txtEnterSine.setToolTipText("Enter Angle, in radians or degrees");
		txtEnterSine.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		txtEnterSine.setBounds(43, 167, 513, 55);
		TrigPanel.add(txtEnterSine);
		txtEnterSine.setColumns(10);
		
		txtEnterCosine = new JTextField();
		txtEnterCosine.setToolTipText("Enter Angle, in radians or degrees");
		txtEnterCosine.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		txtEnterCosine.setColumns(10);
		txtEnterCosine.setBounds(43, 314, 513, 55);
		TrigPanel.add(txtEnterCosine);
		
		txtEnterTan = new JTextField();
		txtEnterTan.setToolTipText("Enter Angle, in radians or degrees");
		txtEnterTan.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		txtEnterTan.setColumns(10);
		txtEnterTan.setBounds(43, 463, 513, 55);
		TrigPanel.add(txtEnterTan);
		
		final JComboBox ChoiceTrigBox = new JComboBox();
		ChoiceTrigBox.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ChoiceTrigBox.setModel(new DefaultComboBoxModel(new String[] {"Degrees", "Radians"}));
		ChoiceTrigBox.setBounds(636, 27, 161, 75);
		TrigPanel.add(ChoiceTrigBox);
			
		final JRadioButton rdbtnInverse = new JRadioButton("Inverse");
		rdbtnInverse.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		rdbtnInverse.setBounds(804, 51, 141, 23);
		TrigPanel.add(rdbtnInverse);
		
		JButton btnCalculateSin = new JButton("Calculate");
		btnCalculateSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String angleTxt;
				Double angle;
				
				angleTxt = txtEnterSine.getText();
				angle = Double.parseDouble(angleTxt);
				
				String choice = ChoiceTrigBox.getSelectedItem().toString();
				if (rdbtnInverse.isSelected()){
					if (choice == "Radians") {
						txtEnterSine.setText(TrigonometricFunctions.aSineRad(angle));
						System.out.println(function + time() + a + "Sin-1(" + angle + ") in Radians was calculated to be " + TrigonometricFunctions.aSineRad(angle));
					} else {
						txtEnterSine.setText(TrigonometricFunctions.aSineDeg(angle));
						System.out.println(function + time() + a + "Sin-1(" + angle + ") in Degrees was calculated to be " + TrigonometricFunctions.aSineRad(angle));
					}
				} else {
					if (choice == "Radians") {
						txtEnterSine.setText(TrigonometricFunctions.SineRad(angle));
						System.out.println(function + time() + a + "Sin(" + angle + ") in Radians was calculated to be " + TrigonometricFunctions.SineRad(angle));
					} else {
						txtEnterSine.setText(TrigonometricFunctions.SineDeg(angle));
						System.out.println(function + time() + a + "Sin(" + angle + ") in Degrees was calculated to be " + TrigonometricFunctions.SineRad(angle));
					}
				}
			}
		});
		btnCalculateSin.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnCalculateSin.setBounds(563, 167, 182, 55);
		TrigPanel.add(btnCalculateSin);
		
		JButton btnCalculateCosine = new JButton("Calculate");
		btnCalculateCosine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String angleTxt;
				Double angle;
				
				angleTxt = txtEnterCosine.getText();
				angle = Double.parseDouble(angleTxt);
				
				String choice = ChoiceTrigBox.getSelectedItem().toString();
				if (rdbtnInverse.isSelected()){
					if (choice == "Radians") {
						txtEnterCosine.setText(TrigonometricFunctions.aCosineRad(angle));
						System.out.println(function + time() + a + "Cos-1(" + angle + ") in Radians was calculated to be " + TrigonometricFunctions.aCosineRad(angle));
					} else {
						txtEnterCosine.setText(TrigonometricFunctions.aCosineDeg(angle));
						System.out.println(function + time() + a + "Cos-1(" + angle + ") in Degrees was calculated to be " + TrigonometricFunctions.aCosineRad(angle));
					}
				} else {
					if (choice == "Radians") {
						txtEnterCosine.setText(TrigonometricFunctions.CosineRad(angle));
						System.out.println(function + time() + a + "Cos(" + angle + ") in Radians was calculated to be " + TrigonometricFunctions.CosineRad(angle));
					} else {
						txtEnterCosine.setText(TrigonometricFunctions.CosineDeg(angle));
						System.out.println(function + time() + a + "Cos(" + angle + ") in Degrees was calculated to be " + TrigonometricFunctions.CosineRad(angle));
					}
				}
			}
		});
		btnCalculateCosine.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnCalculateCosine.setBounds(563, 314, 182, 55);
		TrigPanel.add(btnCalculateCosine);
		
		JButton btnCalculateTan = new JButton("Calculate");
		btnCalculateTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String angleTxt;
				Double angle;
				
				angleTxt = txtEnterTan.getText();
				angle = Double.parseDouble(angleTxt);
				
				String choice = ChoiceTrigBox.getSelectedItem().toString();
				if (rdbtnInverse.isSelected()){
					if (choice == "Radians") {
						txtEnterTan.setText(TrigonometricFunctions.aTanRad(angle));
						System.out.println(function + time() + a + "Tan-1(" + angle + ") in Radians was calculated to be " + TrigonometricFunctions.aTanRad(angle));
					} else {
						txtEnterTan.setText(TrigonometricFunctions.aTanDeg(angle));
						System.out.println(function + time() + a + "Tan-1(" + angle + ") in Degrees was calculated to be " + TrigonometricFunctions.aTanRad(angle));
					}
				} else {
					if (choice == "Radians") {
						txtEnterTan.setText(TrigonometricFunctions.TanRad(angle));
						System.out.println(function + time() + a + "Tan(" + angle + ") in Radians was calculated to be " + TrigonometricFunctions.TanRad(angle));
					} else {
						txtEnterTan.setText(TrigonometricFunctions.TanDeg(angle));
						System.out.println(function + time() + a + "Tan(" + angle + ") in Degrees was calculated to be " + TrigonometricFunctions.TanRad(angle));
					}
				}
			}
		});
		btnCalculateTan.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnCalculateTan.setBounds(563, 463, 182, 55);
		TrigPanel.add(btnCalculateTan);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(32, 253, 711, 12);
		TrigPanel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(20, 396, 711, 12);
		TrigPanel.add(separator_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(mainScreen.class.getResource("/res/DegorRad.png")));
		lblNewLabel.setBounds(595, 16, 262, 36);
		TrigPanel.add(lblNewLabel);
		
		JLabel TrigBackground = new JLabel("");
		TrigBackground.setIcon(new ImageIcon(mainScreen.class.getResource("/res/TriggTitle.png")));
		TrigBackground.setBounds(6, 6, 888, 544);
		TrigPanel.add(TrigBackground);
		
		JMenuItem mntmConsole = new JMenuItem("Console");
		mntmConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
                {
                    FileReader reader = new FileReader( "src/res/console.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    ConsoleTextArea.read( br, null );
                    br.close();
                    ConsoleTextArea.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
				
				CardLayout cl = (CardLayout) (cards.getLayout());
	            cl.show(cards, "ConsolePanel");
	            System.out.println(info + time() + a + "Console Panel loaded");
			}
		});
		mnFunctions.add(mntmConsole);
	}
	

	public static void setOut() throws FileNotFoundException {
		File file = new File("src/res/console.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
	}
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }
	public static String time() {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	return sdf.format(cal.getTime());
	}
	

}



