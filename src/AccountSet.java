import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarkLaf;

public class AccountSet extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JTable table;
	private JScrollPane scrollPane;
	String db_id, db_name, db_auth;
	static int selectLine;
	static String selectID;
	DefaultTableModel model;
	private JButton btnNewButton_3;
	private JTextField sel_id;
	private JTextField sel_name;
	private JSpinner sel_auth;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel result;
	private JButton btnNewButton_4;
	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSet frame = new AccountSet();
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
	public AccountSet() {
		setTitle("\uACC4\uC815 \uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		Object contents[][] = new Object[0][3];
		String header[] = {"ACCOUNT", "USERNAME", "AUTHORITY"};
		model = new DefaultTableModel(contents, header);
		
		mainPanel = new JPanel();
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 0;
		gbc_mainPanel.gridy = 0;
		contentPane.add(mainPanel, gbc_mainPanel);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{52, 0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0};
		gbl_mainPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		mainPanel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable(model); // 테이블을 만듭니다.
		table.addMouseListener(new MouseAdapter() {
			@Override
//			Table요소를 눌렀을때 [테이블 -> 하단 텍스트필드]로 누른 행의 데이터를 옮겨주는 과정
			public void mousePressed(MouseEvent e) { // 테이블을 마우스로 누질렀어요
				selectLine = table.getSelectedRow(); // 믿음과 신뢰의 static
				selectID = table.getValueAt(selectLine, 0).toString(); // 밑에서 또 쓰는데 table.getValueAt(selec~.... 쓰기 싫어서 static
				sel_id.setText(selectID); // String이니까 그냥 넣어
				sel_name.setText(table.getValueAt(selectLine, 1).toString()); // String이니까 그냥 넣어22
				sel_auth.setValue(Integer.valueOf((String)(table.getValueAt(selectLine, 2)))); // 이새낀 대체 뭐ㅓ가 문제야
			}
		});
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 4;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		mainPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountlist();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		btnNewButton_4 = new JButton("Delete acc");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.dbConnect("account");
				try { // 쿼리문 실화냐고 가독성을 위해 최대한 노력해본다
					db.query("delete","delete from `db_project`.`account`"
							+ "where `account`.`id` = '" + selectID + "'");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				db.dbDis();
				sel_id.setText("");
				sel_name.setText("");
				sel_auth.setValue(0);
				accountlist();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 0;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		btnNewButton_2 = new JButton("Add acc");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new addAcount().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 0;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		lblNewLabel_2 = new JLabel("==== Selected Data ====");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		mainPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		mainPanel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		sel_id = new JTextField();
		GridBagConstraints gbc_sel_id = new GridBagConstraints();
		gbc_sel_id.gridwidth = 2;
		gbc_sel_id.fill = GridBagConstraints.BOTH;
		gbc_sel_id.insets = new Insets(0, 0, 5, 5);
		gbc_sel_id.gridx = 1;
		gbc_sel_id.gridy = 3;
		mainPanel.add(sel_id, gbc_sel_id);
		sel_id.setColumns(10);
		
		btnNewButton = new JButton("Modified");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 3;
		mainPanel.add(btnNewButton, gbc_btnNewButton);
		
		lblNewLabel_1 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		mainPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		sel_name = new JTextField();
		GridBagConstraints gbc_sel_name = new GridBagConstraints();
		gbc_sel_name.gridwidth = 2;
		gbc_sel_name.fill = GridBagConstraints.BOTH;
		gbc_sel_name.insets = new Insets(0, 0, 5, 5);
		gbc_sel_name.gridx = 1;
		gbc_sel_name.gridy = 4;
		mainPanel.add(sel_name, gbc_sel_name);
		sel_name.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Authority");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		mainPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		sel_auth = new JSpinner();
		GridBagConstraints gbc_sel_auth = new GridBagConstraints();
		gbc_sel_auth.fill = GridBagConstraints.BOTH;
		gbc_sel_auth.insets = new Insets(0, 0, 0, 5);
		gbc_sel_auth.gridx = 1;
		gbc_sel_auth.gridy = 5;
		mainPanel.add(sel_auth, gbc_sel_auth);
		sel_auth.setModel(new SpinnerNumberModel(0, 0, 9, -1));
		
		lblNewLabel_4 = new JLabel("* (low)9 ~ 1(high)\r\n 0: admin");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 5;
		mainPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.dbConnect("account");
				try { // 쿼리문 실화냐고 가독성을 위해 최대한 노력해본다
					db.query("update", "update `db_project`.`account`"
							+ "set `id` = '" + sel_id.getText() + "'," // 아이디는 sel_id 텍스트필드에서 들고와요
							+ "`name` = '" + sel_name.getText() + "'," // 이름도 sel_name 텍스트필드에서 들고와요
							+ "`authorization` = '" + sel_auth.getValue().toString() + "'" // 내가왜 권한에 스피너를 썼을까
							+ "where `account`.`id` = '" + selectID + "';"); // 텍스트필드에 수정한다고 바꾼 id를 쿼리문에 다이렉트로 때려박으면 오류없는 오류가생김..
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				db.dbDis();
				accountlist();
				selectID = table.getValueAt(selectLine, 0).toString();
			}
		});
		
		result = new JLabel("");
		result.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_result = new GridBagConstraints();
		gbc_result.fill = GridBagConstraints.BOTH;
		gbc_result.gridx = 0;
		gbc_result.gridy = 1;
		contentPane.add(result, gbc_result);
		
		accountlist();
		
	}
	public void accountlist() { // 대충 테이블 새로고침 메소드
		model.setNumRows(0);
		db.dbConnect("account");
		try {
			while(db.rs.next()) {
				db_id = db.rs.getString("id");
				db_name = db.rs.getString("name");
				db_auth = db.rs.getString("authorization");
				
				Object data[] = {db_id, db_name, db_auth};
				model.addRow(data);
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		db.dbDis();
	}

}
