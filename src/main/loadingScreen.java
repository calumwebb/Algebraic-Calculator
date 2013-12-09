package main;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class loadingScreen extends JFrame {

	private JPanel Panel;
	public static JProgressBar progressBar = new JProgressBar();
	static loadingScreen screen = new loadingScreen();
	public static void main(String[] args) {
		init();
	}

	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					screen.setLocationRelativeTo(null);
					screen.setUndecorated(true);
					screen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void forceShutdown() {
		screen.setVisible(false);
	}
	
	public loadingScreen() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(loadingScreen.class.getResource("/res/loading.png")));
		Logo.setBounds(12, 6, 438, 356);
		Panel.add(Logo);
		
		progressBar.setToolTipText("Loading..");
		progressBar.setBounds(6, 374, 438, 20);
		progressBar.setStringPainted(true);
		Panel.add(progressBar);
		
	}
	
	public static void progFake() {
		Random random = new Random();
        int progress = 0;
        progressBar.setValue(0);
        try {
            Thread.sleep(10 + random.nextInt(350));
        } catch (InterruptedException ignore) {}
        int counter = 0;
        while (progress < 100) {
            try {
                Thread.sleep(random.nextInt(175));
            } catch (InterruptedException ignore) {}
            progress += random.nextInt(10);
            progressBar.setValue(Math.min(progress, 100));
            
            if (counter < 19) {
            	progressBar.setString( Progress(counter));	
            	counter++;
            }
        }
	}
	private static String Progress(int counter) {
		String c = "Finalising...";
			switch(counter) {
			case 1: c = "Loading Screen";
				break;
			case 2: c = "Loading Backend Package";
				break;
			case 3: c = "Loading Algoritms to Backend";
				break;
			case 4: c = "Loading Trignometric Functions to Backend";
				break;
			case 5: c = "Loading Main Settings";
				break;
			case 6: c = "Loading Main Functions";
				break;
			case 7: c = "Loading the Format";
				break;
			case 8: c = "Loading Pi.java file";
				break;
			case 9: c = "Loading QuadraticEquation.java file";
				break;
			case 10: c = "Loading Sort.java file";
				break;
			case 11: c = "Loading Main Package";
				break;
			case 12: c = "Loading MainScreen.java file";
				break;
			case 13: c = "Loading Console Class";
				break;
			case 14: c = "Loading Resources Package";
				break;
			case 15: c = "Loading All Resources inside Package";
				break;
			case 16: c = "Painting to Buffer";
				break;
			case 17: c = "Loading Main Screen on Screen";
				break;
			case 18: c = "Finished Loading";
				break;
			default: break;
			}
		return c;
	}
}
