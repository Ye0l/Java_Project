import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenu;

public class addAcount extends MoveJFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_id;
	private JPasswordField pf;
	private JPasswordField pfcf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAcount frame = new addAcount();
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
	public addAcount() {
		classes.darktheme();
		setTitle("add Acount");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 315);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		menuBar.add(horizontalStrut);
		
		JLabel lblNewLabel_7 = new JLabel("Add Account");
		menuBar.add(lblNewLabel_7);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		menuBar.add(toolBar);
		
		JButton btnNewButton_2 = new JButton("close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		toolBar.add(btnNewButton_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{50, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.WEST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		contentPane.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Create new account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		panel_4.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{120, 11, 0};
		gbl_panel_1.rowHeights = new int[]{21, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tf_id = new JTextField();
		GridBagConstraints gbc_tf_id = new GridBagConstraints();
		gbc_tf_id.fill = GridBagConstraints.BOTH;
		gbc_tf_id.gridx = 1;
		gbc_tf_id.gridy = 0;
		panel_1.add(tf_id, gbc_tf_id);
		tf_id.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{120, 6, 0};
		gbl_panel_2.rowHeights = new int[]{21, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		pf = new JPasswordField();
		GridBagConstraints gbc_pf = new GridBagConstraints();
		gbc_pf.fill = GridBagConstraints.BOTH;
		gbc_pf.gridx = 1;
		gbc_pf.gridy = 0;
		panel_2.add(pf, gbc_pf);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 3;
		contentPane.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{120, 6, 0};
		gbl_panel_5.rowHeights = new int[]{21, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm password");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_5.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		pfcf = new JPasswordField();
		GridBagConstraints gbc_pfcf = new GridBagConstraints();
		gbc_pfcf.fill = GridBagConstraints.BOTH;
		gbc_pfcf.gridx = 1;
		gbc_pfcf.gridy = 0;
		panel_5.add(pfcf, gbc_pfcf);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{120, 116, 0};
		gbl_panel.rowHeights = new int[]{21, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tf_name = new JTextField();
		GridBagConstraints gbc_tf_name = new GridBagConstraints();
		gbc_tf_name.fill = GridBagConstraints.BOTH;
		gbc_tf_name.gridx = 1;
		gbc_tf_name.gridy = 0;
		panel.add(tf_name, gbc_tf_name);
		tf_name.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 5;
		contentPane.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{120, 59, 0, 0};
		gbl_panel_6.rowHeights = new int[]{15, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Authorization");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_6.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JSpinner spn_auth = new JSpinner();
		spn_auth.setModel(new SpinnerNumberModel(9, 1, 9, -1));
		GridBagConstraints gbc_spn_auth = new GridBagConstraints();
		gbc_spn_auth.insets = new Insets(0, 0, 0, 5);
		gbc_spn_auth.fill = GridBagConstraints.HORIZONTAL;
		gbc_spn_auth.gridx = 1;
		gbc_spn_auth.gridy = 0;
		panel_6.add(spn_auth, gbc_spn_auth);
		
		JLabel lblNewLabel_6 = new JLabel("* (low)9 ~ 1(high)\r\n 0: admin");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 0;
		panel_6.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 6;
		contentPane.add(panel_3, gbc_panel_3);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tf_id.getText().length() < 4) {
					JOptionPane.showMessageDialog(contentPane, "아이디는 4자 이상으로 입력해주세요.");
					return;
				}
				if(tf_name.getText().length() < 2) {
					JOptionPane.showMessageDialog(contentPane, "이름을 입력해주세요.");
					return;
				}
				if(pf.getPassword().length < 4) {
					JOptionPane.showMessageDialog(contentPane, "비밀번호는 4자 이상으로 입력해주세요.");
					return;
				}
				if(!Arrays.equals(pf.getPassword(), pfcf.getPassword())) {
					JOptionPane.showMessageDialog(contentPane, "Password Incorrect");
				} else {
					db.dbConnect("accounts");
					try {
						 String pw = "";
						char[] secret_pw = pf.getPassword();
						     for(char cha : secret_pw){         
						         Character.toString(cha);
						         pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";   
						     }
						db.query("insert", "insert into account values('" + tf_id.getText() + "', '" + pw + "', '" + tf_name.getText()
						+ "', '" + spn_auth.getValue().toString() + "')");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "Create complete.");
					db.dbDis();
					dispose();
				}
			}
		});
		panel_3.add(btnNewButton);
	}

}
