package ie.gmit.proskills.Menu;

import ie.gmit.proskills.Processes.StoreSearch;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Color;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7318028064219521737L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfStore_Seach;

	/**
	 * Launch the application.
	 */
	public static void main(int x, int y) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu(x, y);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param y
	 * @param x
	 */
	public MainMenu(int x, int y) {
		
		// Frame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 660, 500);
		setTitle("StoreCompare - Main Menu");
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Table settings
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		String header[] = new String[] { "Item Name", "Price", "Postage", "Total", "Store" };
		dtm.setColumnIdentifiers(header);
		table = new JTable();
		table.setModel(dtm);

		// Panel settings
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 624, 325);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		// Text label settings
		JLabel lblStore_Search = new JLabel("Store Search:");
		lblStore_Search.setForeground(Color.LIGHT_GRAY);
		lblStore_Search.setBounds(10, 56, 125, 14);
		contentPane.add(lblStore_Search);

		// Textfield settings for user input
		tfStore_Seach = new JTextField();
		tfStore_Seach.setBounds(10, 71, 125, 20);
		contentPane.add(tfStore_Seach);
		tfStore_Seach.setColumns(10);

		// Search button setup and action listener
		JButton btnStore_Search = new JButton("Search");
		btnStore_Search.setBounds(10, 92, 125, 23);
		contentPane.add(btnStore_Search);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(545, 92, 89, 23);
		contentPane.add(exitButton);
		btnStore_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dtm.setRowCount(0);

				String itemSearch = tfStore_Seach.getText();

				try {
					StoreSearch.main(itemSearch, dtm);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		

	}
}