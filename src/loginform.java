import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class loginform extends MoveJFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JPasswordField pf_pw;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public loginform() {
		classes.darktheme();
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,365, 480);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JToolBar toolBar = new JToolBar();
		menuBar.add(toolBar);
		toolBar.setFloatable(false);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		toolBar.add(horizontalStrut);
		
		JLabel lblNewLabel_2 = new JLabel("InventoryManagementProject v0.50");
		toolBar.add(lblNewLabel_2);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		toolBar.add(btnNewButton_1);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{61, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 49, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Login");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Californian FB", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		tf_id = new JTextField();
		tf_id.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_tf_id = new GridBagConstraints();
		gbc_tf_id.fill = GridBagConstraints.BOTH;
		gbc_tf_id.insets = new Insets(0, 0, 5, 5);
		gbc_tf_id.gridx = 1;
		gbc_tf_id.gridy = 3;
		panel.add(tf_id, gbc_tf_id);
		tf_id.setToolTipText("");
		tf_id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 4;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Bell MT", Font.PLAIN, 15));
		
		pf_pw = new JPasswordField();
		pf_pw.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pf_pw = new GridBagConstraints();
		gbc_pf_pw.fill = GridBagConstraints.BOTH;
		gbc_pf_pw.insets = new Insets(0, 0, 5, 5);
		gbc_pf_pw.gridx = 1;
		gbc_pf_pw.gridy = 5;
		panel.add(pf_pw, gbc_pf_pw);
		
		JButton btnNewButton = new JButton("Login"); // 안녕 난 로그인버튼이야
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { // 버튼이 눌림
			public void actionPerformed(ActionEvent e) {
				db.dbConnect("account"); // db랑 연결함
//				여기서부터 passwordField내용물을 String으로 만드는 과정
				String pw = "";
				char[] secret_pw = pf_pw.getPassword();
				     for(char cha : secret_pw){         
				    	 Character.toString(cha);
				         pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";   
				     }
//				passwordField.getPassword(); -> String pw 완성
				try { // ㄱㄱ
					while(db.rs.next()) { // 대충 반복문 시작
						if(tf_id.getText().equals(db.rs.getString("id"))) {
//						id textField랑 연결한 db resultSet의 id열 항목이 같습니까?
							if(pw.equals(db.rs.getString("password"))) {
//							그럼 passwordField내용물이랑 연결한 db resultSet의 pw열 항목이 같습니까?
								MainScreen.loginUser = db.rs.getString("name");
								new MainScreen().setVisible(true); // 다음 화면 ㄱㄱ
								dispose(); // 로그인했으니 로그인창은 끄고 가야지
								return; // 코드 종료 이거없으면 밑에 id/pw오류 메세지박스 뜸
							}
						}
					} // 대충 반복문 끝
					JOptionPane.showMessageDialog(contentPane, "id 혹은 password 오류입니다.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				db.dbDis(); // db 연결해제 잊지말기
			}
		});
	}
}
