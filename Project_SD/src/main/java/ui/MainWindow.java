package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import daw.Workstation;


public class MainWindow {
	
	private JFrame frame;
	JPanel mainPanel = new JPanel();
	Workstation station = new Workstation();
	
	public MainWindow() {
		initUI();
	}
	
	private void initUI() {
		frame = new JFrame("Digital Audio Workstation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		
		JPanel trackPanel = new JPanel();
		trackPanel.setLayout(new BoxLayout(trackPanel, BoxLayout.Y_AXIS));
		
		JButton buildTracks = new JButton("Build tracks");
		buildTracks.addActionListener(new Clicker("build tracks"));
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
	}
	
	private class Clicker implements ActionListener {
		private String action;
		
		public Clicker(String action) {
			this.action = action;
		}
		public void actionPerformed(ActionEvent arg0) {
			if(action.equals("build tracks")) {
			}
		}
	}
	
	public static void main( String[] args ) {
		MainWindow window = new MainWindow();
	}
}
