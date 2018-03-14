package ie.gmit.proskills.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandingPage extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage frame = new LandingPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LandingPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.DARK_GRAY);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 544, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to StoreCompare");
		welcomeLabel.setBounds(66, 21, 410, 53);
		welcomeLabel.setForeground(Color.LIGHT_GRAY);
		welcomeLabel.setBackground(Color.BLACK);
		welcomeLabel.setFont(new Font("Papyrus", Font.PLAIN, 33));
		panel.add(welcomeLabel);
		
		JLabel imageLabel = new JLabel("");					
		Image img = new ImageIcon(this.getClass().getResource("/barcode.png")).getImage();
		imageLabel.setIcon(new ImageIcon(img));
		imageLabel.setBounds(207, 85, 128, 165);
		panel.add(imageLabel);
		
		JLabel imageLabel2 = new JLabel("");//Icon made by Pixel Perfect from "https://www.flaticon.com/" 
		//is licensed by "http://creativecommons.org/licenses/by/3.0/"
		Image img2 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		imageLabel2.setIcon(new ImageIcon(img2));
		imageLabel2.setBounds(110, 279, 46, 46);
		panel.add(imageLabel2);
		
		JLabel imageLabel3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/id-card.png")).getImage();
		imageLabel3.setIcon(new ImageIcon(img3));
		imageLabel3.setBounds(391, 279, 32, 40);
		panel.add(imageLabel3);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setBackground(Color.LIGHT_GRAY);
		buttonLogin.setBounds(66, 330, 140, 40);
		panel.add(buttonLogin);
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginMenu.main(null);
				CloseFrame();
			}
		});
		
		JButton buttonReg = new JButton("Register");
		buttonReg.setBackground(Color.LIGHT_GRAY);
		buttonReg.setBounds(336, 330, 140, 40);
		panel.add(buttonReg);
		
	}

	public void CloseFrame(){
	    super.dispose();
	}
}