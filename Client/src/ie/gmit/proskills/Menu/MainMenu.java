package ie.gmit.proskills.Menu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import ie.gmit.proskills.Processes.StoreSearch;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 660, 500);
		setTitle("StoreCompare - Main Menu");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultTableModel dtm = new DefaultTableModel(0, 0);

		// add header of the table
		String header[] = new String[] { "Item Name", "Price", "Postage", "Total", "Store" };

		// add header in table model
		dtm.setColumnIdentifiers(header);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 624, 325);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		// set model into the table object
		table.setModel(dtm);

		JLabel lblStore_Search = new JLabel("Store Search:");
		lblStore_Search.setBounds(10, 56, 125, 14);
		contentPane.add(lblStore_Search);

		tfStore_Seach = new JTextField();
		tfStore_Seach.setBounds(10, 71, 125, 20);
		contentPane.add(tfStore_Seach);
		tfStore_Seach.setColumns(10);

		JButton btnStore_Search = new JButton("Search");
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
		btnStore_Search.setBounds(10, 92, 125, 23);
		contentPane.add(btnStore_Search);

	}
}