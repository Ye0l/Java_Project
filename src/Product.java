import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private JButton btnDel;
	private JButton btnAdd;
	private DefaultTableModel model, materialModel;
	private JComboBox comboBox;
	private DefaultComboBoxModel<Object> cModel;
	private JTextField tf_pName;
	private JTextField tf_pCost;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnModify;
	private static String selectId, selectMaterial;
	private JComboBox cb_pDiv;
	private JTextField pm_qtt;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

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
		setBounds(100, 100, 682, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 328, 0, 123, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Product List");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Materials");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{300, 100, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		
		cModel = new DefaultComboBoxModel<Object>();
		
		lblNewLabel_5 = new JLabel("Select material");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Quantity");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		comboBox = new JComboBox(cModel);
		comboBox.setEnabled(false);
		ComboAgent agent = new ComboAgent(comboBox);
		comboBox.setEditable(true);
		comboBox.setToolTipText("select material");
		comboBox.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		
		pm_qtt = new JTextField();
		pm_qtt.setEnabled(false);
		GridBagConstraints gbc_pm_qtt = new GridBagConstraints();
		gbc_pm_qtt.insets = new Insets(0, 0, 5, 0);
		gbc_pm_qtt.fill = GridBagConstraints.BOTH;
		gbc_pm_qtt.gridx = 1;
		gbc_pm_qtt.gridy = 2;
		panel.add(pm_qtt, gbc_pm_qtt);
		pm_qtt.setColumns(10);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnAdd = new JButton("Add Material");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pm_qtt.getText().isEmpty()) { // 공백체크
					JOptionPane.showMessageDialog(contentPane, "값을 입력해주세요.");
					return;	
				}
					
				db.dbConnect("product_material");
				try { // 서브쿼리라 진짜 쿼리 쓰기 싫었는데 다른 방법이 안떠올라서 쿼리로 쓴 db중복체크 
					db.query("select", "select material_id from product_material "
							+ "where product_id = " + selectId
							+ " and material_id = "
							+ "(select id from product where name like '" + comboBox.getSelectedItem().toString() + "')");
					while(db.rs.next()) {
						if(!db.rs.getString("material_id").equals(null)) {
							JOptionPane.showMessageDialog(contentPane, "중복된 값입니다.");
							return;
						}
					}
					db.query("insert into", "insert into product_material"
							+ " values(" + selectId
							+ ", "
							+ "(select id from product where name like '" + comboBox.getSelectedItem().toString() + "')"
							+ ", " + pm_qtt.getText() + ")");
				}catch (Exception e1){
					e1.printStackTrace();
				}
				db.dbDis();
				refresh();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		panel_1.add(btnAdd, gbc_btnAdd);
		
		btnDel = new JButton("Delete Material");
		btnDel.setEnabled(false);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.dbConnect("product_material");
				try {
					db.query("DELETE", "delete from product_material"
							+ " where product_id = " + selectId
							+ " and material_id = "
							+ "(select id from product "
							+ " where name like '" + comboBox.getSelectedItem().toString() + "')");
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				db.dbDis();
				refresh();
			}
		});
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.fill = GridBagConstraints.BOTH;
		gbc_btnDel.gridx = 1;
		gbc_btnDel.gridy = 0;
		panel_1.add(btnDel, gbc_btnDel);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);

		scrollPane = new JScrollPane();
		panel.add(scrollPane, gbc_scrollPane);
		String header[] = {"ID","NAME","COST","DIVISION"};
		Object contents[][] = new Object[0][4];
		String mHeader[] = {"ID","NAME","COST","DIVISION", "QUANTITY"};
		Object mContents[][] = new Object[0][5];
		model = new DefaultTableModel(contents, header);
		materialModel = new DefaultTableModel(mContents, mHeader);
		model.setNumRows(0);
		materialModel.setNumRows(0);
		
		refresh();

		materialTable = new JTable(materialModel);
		materialTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = materialTable.getSelectedRow();
				selectMaterial = materialTable.getValueAt(row, 1).toString();
				comboBox.setSelectedItem(selectMaterial);
			}
		});
		scrollPane.setViewportView(materialTable);
		productTable = new JTable(model);
		productTable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int col = productTable.columnAtPoint(e.getPoint());
				String name = productTable.getColumnName(col);
				db.dbConnect("product");
				try {
					model.setNumRows(0);
					db.query("select", "select * from product order by " + name + " asc");
					while(db.rs.next()) {
						String c0, c1, c2, c3;
						c0 = db.rs.getString("id");
						c1 = db.rs.getString("name");
						c2 = db.rs.getString("cost");
						c3 = db.rs.getString("division");
						Object data[] = {c0, c1, c2, c3};
						model.addRow(data);
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				db.dbDis();
			}
		});
		productTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					btnDel.setEnabled(false);
					btnAdd.setEnabled(false);
					int row = productTable.getSelectedRow();
					selectId = productTable.getValueAt(row, 0).toString();
					tf_pName.setText(productTable.getValueAt(row, 1).toString());
					tf_pCost.setText(productTable.getValueAt(row, 2).toString());
//					tf_pDiv.setText(productTable.getValueAt(row, 3).toString());
					cb_pDiv.setSelectedItem(productTable.getValueAt(row, 3));
					if(productTable.getValueAt(row, 3).equals("Product")) {
						btnDel.setEnabled(true);
						btnAdd.setEnabled(true);
						materialModel.setNumRows(0);
						cModel.removeAllElements();
						comboBox.setEnabled(true);
						pm_qtt.setEnabled(true);
						try {
							db.dbConnect("product_material");
							db.query("select", "SELECT p.id, p.name, p.cost, p.division, pm.quantity\r\n" + 
									"FROM product p, product_material pm\r\n" + 
									"WHERE p.id = pm.material_id\r\n" + 
									"AND pm.product_id = " + selectId);
							while(db.rs.next()) {
								Object data[] = {
										db.rs.getString("ID"),
										db.rs.getString("Name"),
										db.rs.getString("Cost"),
										db.rs.getString("Division"),
										db.rs.getString("quantity")
								};
								materialModel.addRow(data);
							}
							db.dbDis();
							cModel.removeAllElements();
							db.dbConnect("product");
							db.query("select", "SELECT Name from product where division like 'Material'");
							while(db.rs.next()) {
								cModel.addElement(db.rs.getString("Name"));
							}
						}catch (Exception e1) {
							e1.printStackTrace();
						}
						db.dbDis();
						comboBox.setSelectedItem("");
					} else {
						cModel.removeAllElements();
						comboBox.setEnabled(false);
						pm_qtt.setEnabled(false);
						materialModel.setNumRows(0);
					}
				} catch (Exception e1) {
					cModel.removeAllElements();
					comboBox.setEnabled(false);
					pm_qtt.setEnabled(false);
				}
			}
		});
		scrollPane_1.setViewportView(productTable);
		
		lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tf_pName = new JTextField();
		GridBagConstraints gbc_tf_pName = new GridBagConstraints();
		gbc_tf_pName.insets = new Insets(0, 0, 5, 5);
		gbc_tf_pName.fill = GridBagConstraints.BOTH;
		gbc_tf_pName.gridx = 1;
		gbc_tf_pName.gridy = 2;
		contentPane.add(tf_pName, gbc_tf_pName);
		tf_pName.setColumns(10);
		
		lblNewLabel_3 = new JLabel("COST");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tf_pCost = new JTextField();
		GridBagConstraints gbc_tf_pCost = new GridBagConstraints();
		gbc_tf_pCost.insets = new Insets(0, 0, 5, 5);
		gbc_tf_pCost.fill = GridBagConstraints.BOTH;
		gbc_tf_pCost.gridx = 1;
		gbc_tf_pCost.gridy = 3;
		contentPane.add(tf_pCost, gbc_tf_pCost);
		tf_pCost.setColumns(10);
		
		lblNewLabel_4 = new JLabel("DIVISION");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.dbConnect("product");
				try {
					db.query("update", "update product "
							+ "set Name = '" + tf_pName.getText()
							+ "', Cost = '" + tf_pCost.getText()
							+ "', Division = '" + cb_pDiv.getSelectedItem()
							+ "' where id = " + selectId);
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				db.dbDis();
				refresh();
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.fill = GridBagConstraints.BOTH;
		gbc_btnModify.gridheight = 3;
		gbc_btnModify.insets = new Insets(0, 0, 0, 5);
		gbc_btnModify.gridx = 2;
		gbc_btnModify.gridy = 2;
		contentPane.add(btnModify, gbc_btnModify);
		
		cb_pDiv = new JComboBox();
		cb_pDiv.setModel(new DefaultComboBoxModel(new String[] {"", "Product", "Goods", "Material"}));
		GridBagConstraints gbc_cb_pDiv = new GridBagConstraints();
		gbc_cb_pDiv.insets = new Insets(0, 0, 0, 5);
		gbc_cb_pDiv.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_pDiv.gridx = 1;
		gbc_cb_pDiv.gridy = 4;
		contentPane.add(cb_pDiv, gbc_cb_pDiv);
	}
	private void refresh() {
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
				for(int i = 0; i <= 3; i++) {
					if(data[i] == null)
						data[i] = "";
				}
				model.addRow(data);
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		try {
			db.dbConnect("product_material");
			db.query("select", "SELECT p.id, p.name, p.cost, p.division, pm.quantity\r\n" + 
					"FROM product p, product_material pm\r\n" + 
					"WHERE p.id = pm.material_id\r\n" + 
					"AND pm.product_id = " + selectId);
			while(db.rs.next()) {
				Object data[] = {
						db.rs.getString("ID"),
						db.rs.getString("Name"),
						db.rs.getString("Cost"),
						db.rs.getString("Division"),
						db.rs.getString("quantity")
				};
				materialModel.addRow(data);
			}
			db.dbDis();
			cModel.removeAllElements();
			db.dbConnect("product");
			db.query("select", "SELECT Name\r\n" + 
					"FROM product\r\n" + 
					"WHERE Division LIKE 'Material'\r\n" + 
					"AND NOT id\r\n" + 
					"IN (\r\n" + 
					"\r\n" + 
					"SELECT material_id\r\n" + 
					"FROM product_material\r\n" + 
					"WHERE product_id = " + selectId + ")");
			while(db.rs.next()) {
				cModel.addElement(db.rs.getString("Name"));
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		db.dbDis();
	}

}
