import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class RCSH extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JLabel alert;
	private JTextField quantity;
	private JButton btnNewButton;
	private DefaultTableModel model;
	private JComboBox comboBox, comboBox_1;
	private String db_name, db_date, db_qtt, db_rcsh, selectItem;
	private SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	private Calendar time = Calendar.getInstance();
	private List<Object> Array;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RCSH frame = new RCSH();
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
	public RCSH() {
		setTitle("\uC785\uCD9C\uACE0 \uB4F1\uB85D");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{20, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		String header[] = {"NAME", "DATE", "QUANTITY", "RCSH"};
		Object contents[][] = new Object[0][4];

		model = new DefaultTableModel(contents, header);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 200, 80, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("\uBB3C\uD488 \uC785\uB825");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC218\uB7C9");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD6C\uBD84");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		arrayrefresh();
		
		comboBox = new JComboBox(Array.toArray());
		ComboAgent agent = new ComboAgent(comboBox);
		comboBox.setEditable(true);
		comboBox.setSelectedIndex(-1);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		quantity = new JTextField();
		quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					addRCSH();
				}
			}
		});
		GridBagConstraints gbc_quantity = new GridBagConstraints();
		gbc_quantity.insets = new Insets(0, 0, 5, 5);
		gbc_quantity.fill = GridBagConstraints.BOTH;
		gbc_quantity.gridx = 1;
		gbc_quantity.gridy = 1;
		panel.add(quantity, gbc_quantity);
		quantity.setColumns(10);
		
		String com2[] = {"입고","출고","판매"};
		
		comboBox_1 = new JComboBox(com2);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 1;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		btnNewButton = new JButton("\u2BC6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRCSH();
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		table_1 = new JTable(model);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selectItem = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 100, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshlist();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.dbConnect("warehousing");
				try { // 쿼리문 실화냐고 가독성을 위해 최대한 노력해본다
					db.query("delete","delete from `db_project`.`warehousing`"
							+ "where `Name` = '" + selectItem + "'");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				db.dbDis();
				refreshlist();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		alert = new JLabel("");
		GridBagConstraints gbc_alert = new GridBagConstraints();
		gbc_alert.gridx = 0;
		gbc_alert.gridy = 3;
		contentPane.add(alert, gbc_alert);
		refreshlist();
	}
	class ComboAgent extends KeyAdapter {
		JTextField editor;
		JComboBox combo;
		
		public ComboAgent(JComboBox box)
		{
            combo = box;
            editor = (JTextField)combo.getEditor().getEditorComponent();
            editor.addKeyListener(this);
        }
        public void keyReleased(KeyEvent e)
        {
            char ch = e.getKeyChar();
           
            if(ch == KeyEvent.CHAR_UNDEFINED || Character.isISOControl(ch))
                return;
           
            int pos = editor.getCaretPosition();
            String str = editor.getText();
           
            if(str.length() == 0)
                return;
           
            for(int k=0; k<combo.getItemCount(); k++)
            {
                String iteml = combo.getItemAt(k).toString().toLowerCase();
                String item = combo.getItemAt(k).toString();
                // 조건 비교.. 입력한 문자열이 리스트에 있는 아이템의 첫머리로 일치하는지..
                if( item.startsWith(str) || iteml.startsWith(str) ||
                    item.startsWith(str.toLowerCase()) ||
                    iteml.startsWith(str.toLowerCase()) )
                {
                    // 일치한다면 field에 매치된 아이템을 셋팅하고
                    // 자동으로 완성된 부분을 선택표시로 하여 강조한다.
                    editor.setText(item);   
                    editor.setCaretPosition(item.length());
                    editor.moveCaretPosition(pos);   
                    break;
                }
            }
        }
	}
	public void refreshlist() { // 대충 테이블 새로고침 메소드
		model.setNumRows(0);
		db.dbConnect("warehousing");
		try {
			while(db.rs.next()) {
				db_name = db.rs.getString("Name");
				db_date = db.rs.getString("Date");
				db_qtt = db.rs.getString("Quantity");
				db_rcsh = db.rs.getString("RCSH");
				
				Object data[] = {db_name, db_date, db_qtt, db_rcsh};
				model.addRow(data);
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		db.dbDis();
	}
	private void addRCSH() {
		if(quantity.getText().isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "값을 입력해주세요.");
			return;	
		}
		try {// if is number
		    Integer.parseInt(quantity.getText());
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(contentPane, "숫자를 입력해주세요.");
		    return;
		}
		db.dbConnect("warehousing");
		try {
			db.query("insert into", "INSERT INTO `db_project`.`warehousing` ("
					+ "`ID` ,`Name` ,`Date` ,`Quantity` ,`RCSH`)"
					+ "VALUES (NULL , '"
					+ comboBox.getSelectedItem() + "', '"
					+ format1.format(time.getTime()) + "', '"
					+ quantity.getText() + "', '"
					+ comboBox_1.getSelectedItem() + "'" + 
					");");
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		db.dbDis();
		int check = 0;
		for(Object obj : Array) {
			if(comboBox.getSelectedItem().equals(obj)) {
				check = 1;
				break;
			}
		}
		if(check == 0) {
			db.dbConnect("product");
			try {
				db.query("inset into", "insert into `product` ("
						+ "`Name`)"
						+ "values ('"
						+ comboBox.getSelectedItem() + "');");
			} catch (Exception e) {
				e.printStackTrace();
			}
			db.dbDis();
		}
		JOptionPane.showMessageDialog(null, "등록되지 않은 상품이 등록되었습니다. 제품 관리에서 상세 정보를 수정하세요.");
		arrayrefresh();
		refreshlist();
		comboBox.setSelectedIndex(-1);
		quantity.setText("");
	}
	private void arrayrefresh() {
		Array = new ArrayList<Object>();
		
		
		db.dbConnect("product");
		try {
			while(db.rs.next()) {
				Array.add(db.rs.getString("Name"));
			}
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		db.dbDis();
	}
}