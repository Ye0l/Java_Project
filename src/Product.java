import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Product extends JFrame {

	private JPanel contentPane;
	private JTable materialTable;
	private JTable productTable;
	private JScrollPane scrollPane_1, scrollPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private DefaultTableModel model, materialModel;
	private JComboBox comboBox;
	private List<Object> Array;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
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
	public Product() {
		setTitle("\uC81C\uD488 \uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{328, 123, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Product List");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Materials");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{300, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		
		arrayrefresh();
		
		comboBox = new JComboBox(Array.toArray());
		comboBox.setEnabled(false);
		ComboAgent agent = new ComboAgent(comboBox);
		comboBox.setEditable(true);
		comboBox.setToolTipText("select material name");
		comboBox.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnNewButton_2 = new JButton("Add(+)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_1 = new JButton("Sub(-)");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);

		scrollPane = new JScrollPane();
		panel.add(scrollPane, gbc_scrollPane);
		String header[] = {"ID","NAME","COST","DIVISION"};
		Object contents[][] = new Object[0][4];
		String mHeader[] = {"ID","NAME","COST","DIVISION"};
		Object mContents[][] = new Object[0][4];
		model = new DefaultTableModel(contents, header);
		materialModel = new DefaultTableModel(mContents, mHeader);
		model.setNumRows(0);
		materialModel.setNumRows(0);
		
		db.dbConnect("product");
		try {
			while(db.rs.next()) {
				Object data[] = {
						db.rs.getString("ID"),
						db.rs.getString("Name"),
						db.rs.getString("Cost"),
						db.rs.getString("Division")
				};
				model.addRow(data);
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		db.dbDis();

		materialTable = new JTable(materialModel);
		scrollPane.setViewportView(materialTable);
		productTable = new JTable(model);
		productTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					int row = productTable.getSelectedRow();
					if(productTable.getValueAt(row, 3).equals("Product")) {
						comboBox.setEnabled(true);
						String id = productTable.getValueAt(row, 0).toString();
						db.dbConnect("product_materials");
						db.query("select", "SELECT p.id, p.name, p.cost, p.division, pm.quantity\r\n" + 
								"FROM product p, product_material pm\r\n" + 
								"WHERE p.id = pm.material_id\r\n" + 
								"AND pm.product_id =1");
						try {
							while(db.rs.next()) {
								Object data[] = {
										db.rs.getString("ID"),
										db.rs.getString("Name"),
										db.rs.getString("Cost"),
										db.rs.getString("Division")
								};
								materialModel.addRow(data);
							}
						}catch (Exception e1) {
							e1.printStackTrace();
						}
						db.dbDis();
					} else {
						comboBox.setEnabled(false);
						materialModel.setNumRows(0);
						System.out.println("material테이블 초기화");
					}
				} catch (Exception e1) {
					comboBox.setEnabled(false);
					System.out.println("error");
				}
			}
		});
		scrollPane_1.setViewportView(productTable);
	}
	private void arrayrefresh() {
		Array = new ArrayList<Object>();
		
		
		db.dbConnect("product");
		try {
			db.query("select", "SELECT Name\r\n" + 
					"FROM product\r\n" + 
					"WHERE Division LIKE 'Material'\r\n" + 
					"AND NOT id\r\n" + 
					"IN (\r\n" + 
					"\r\n" + 
					"SELECT material_id\r\n" + 
					"FROM product_material\r\n" + 
					"WHERE product_id =1\r\n" + 
					")");
			while(db.rs.next()) {
				Array.add(db.rs.getString("Name"));
			}
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		db.dbDis();
	}

}
