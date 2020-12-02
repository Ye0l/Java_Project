import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Detail extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton;
	private JTextField textField;
	private JComboBox comboBox;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detail frame = new Detail();
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
	public Detail() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\uC785\uCD9C\uACE0 \uB0B4\uC5ED");
		setBounds(100, 100, 682, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{140, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btnNewButton.getActionListeners();
				if(arg0.getKeyCode() == 10) 
					search();
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		String header[] = {"NAME", "DATE", "QUANTITY", "RCSH"};
		
		comboBox = new JComboBox(header);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		panel.add(comboBox, gbc_comboBox);

		Object contents[][] = new Object[0][4];
		model = new DefaultTableModel(contents, header);

		db.dbConnect("warehousing");
		try {
			String name, date, qtt, rcsh;
			while(db.rs.next()) {
				name = db.rs.getString("Name");
				date = db.rs.getString("Date");
				qtt = db.rs.getString("Quantity");
				rcsh = db.rs.getString("RCSH");
				Object data[] = {name, date, qtt, rcsh};
				model.addRow(data);
			}
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		db.dbDis();
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}
	
	private void search() {
		model.setNumRows(0);
		db.dbConnect("warehousing");
		try {
			String name, date, qtt, rcsh;
			String search = "";
			switch (comboBox.getSelectedItem().toString()) {
			case "NAME":
				search = "Name";
				break;
			case "DATE":
				search = "Date";
				break;
			case "QUANTITY":
				search = "Quantity";
				break;
			case "RCSH":
				search = "Rcsh";
				break;
			}
			db.query("select", "select * from `warehousing` where `"
					+ search + "` like '%"
					+ textField.getText() + "%'");
			System.out.println("select * from `warehousing` where `"
					+ search + "` like '%"
					+ textField.getText() + "%'");
			while(db.rs.next()) {
				name = db.rs.getString("Name");
				date = db.rs.getString("Date");
				qtt = db.rs.getString("Quantity");
				rcsh = db.rs.getString("RCSH");
				Object data[] = {name, date, qtt, rcsh};
				model.addRow(data);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		db.dbDis();
	}

}