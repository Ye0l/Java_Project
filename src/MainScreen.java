import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainScreen extends MoveJFrame {
	static String loginUser = "admin";
	static String loginID = "";

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		classes.darktheme();
		setTitle("InventoryManagement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uAD00\uB9AC");
		menuBar.add(mnNewMenu);
		
		JMenuItem mitem_AccountSet = new JMenuItem("\uC0AC\uC6A9\uC790 \uAD8C\uD55C \uC124\uC815");
		mitem_AccountSet.setEnabled(false);
		mitem_AccountSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("계정 관리", null, new AccountSet().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu.add(mitem_AccountSet);
		
		JMenuItem mitem_logout = new JMenuItem("\uB85C\uADF8\uC544\uC6C3");
		mitem_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그아웃합니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					return;
				} else if(result == JOptionPane.YES_OPTION) {
					loginUser = "";
					new loginform().setVisible(true);
					dispose();
				} else {
					return;
				}
			}
		});
		
		JMenuItem mitem_MenuAuth = new JMenuItem("\uBA54\uB274 \uAD8C\uD55C \uAD00\uB9AC");
		mitem_MenuAuth.setEnabled(false);
		mitem_MenuAuth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("메뉴 권한 관리", null, new MenuAuth().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu.add(mitem_MenuAuth);
		mnNewMenu.add(mitem_logout);
		
		JMenu mnNewMenu_1 = new JMenu("\uC7AC\uACE0 \uAD00\uB9AC");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mitem_RCSH = new JMenuItem("\uC785\uCD9C\uACE0 \uB4F1\uB85D");
		mitem_RCSH.setEnabled(false);
		mitem_RCSH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("입출고 등록", null, new RCSH().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu_1.add(mitem_RCSH);
		
		JMenuItem mitem_Detail = new JMenuItem("\uB0B4\uC5ED \uC870\uD68C");
		mitem_Detail.setEnabled(false);
		mitem_Detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("내역 조회", null, new Detail().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu_1.add(mitem_Detail);
		
		JMenu mnNewMenu_2 = new JMenu("\uC81C\uD488 \uAD00\uB9AC");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mitem_Product = new JMenuItem("\uC81C\uD488 \uAD00\uB9AC");
		mitem_Product.setEnabled(false);
		mitem_Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("제품 관리", null, new Product().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu_2.add(mitem_Product);
		
		JMenuItem mitem_Preset = new JMenuItem("\uD504\uB9AC\uC14B");
		mitem_Preset.setEnabled(false);
		mitem_Preset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("프리셋", null, new preset().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu_2.add(mitem_Preset);
		
		JMenu mnNewMenu_3 = new JMenu("\uD1B5\uACC4");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mitem_Analysis = new JMenuItem("\uB9E4\uCD9C \uC870\uD68C");
		mitem_Analysis.setEnabled(false);
		mitem_Analysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("매출 조회", null, new sales_inquiry().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu_3.add(mitem_Analysis);
		
		JMenuItem mitem_sales_inquiry = new JMenuItem("\uC7AC\uACE0 \uBD84\uC11D");
		mitem_sales_inquiry.setEnabled(false);
		mitem_sales_inquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.getTabCount() > 1)
					tabbedPane.removeTabAt(1);
				tabbedPane.addTab("재고 분석", null, new Analysis().getContentPane(), null);
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnNewMenu_3.add(mitem_sales_inquiry);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		menuBar.add(horizontalStrut);
		
		JLabel lblNewLabel_3 = new JLabel("Inventory Management");
		menuBar.add(lblNewLabel_3);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		menuBar.add(toolBar);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		toolBar.add(btnNewButton);
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 20, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		Panel panel_1 = new Panel();
		tabbedPane.addTab("Main", panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uD14C\uC2A4\uD2B8 \uBC84\uC804\uC785\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\uBA87\uAC00\uC9C0 \uAE30\uB2A5\uC774 \uC81C\uD55C\uB418\uC5B4\uC788\uAC70\uB098 \uBD88\uC548\uC815\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{575, 0, 0, 20, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lb_username = new JLabel(loginUser);
		lb_username.setForeground(SystemColor.textHighlight);
		GridBagConstraints gbc_lb_username = new GridBagConstraints();
		gbc_lb_username.insets = new Insets(0, 0, 0, 5);
		gbc_lb_username.gridx = 2;
		gbc_lb_username.gridy = 0;
		panel.add(lb_username, gbc_lb_username);
		
		db.dbConnect("account");
		try {
			db.query("select", "select authorization from account where id like '" + loginID + "'");
			int auth = 9;
			if(db.rs.next()) {
				auth = Integer.parseInt(db.rs.getString("authorization"));
				System.out.println(db.rs.getString("authorization"));
			}
			db.dbDis();
			db.dbConnect("menuauth");
			while(db.rs.next()) {
				if(Integer.parseInt(db.rs.getString("auth")) >= auth) {
					switch (db.rs.getString("menuid")) {
					case "1":
						mitem_AccountSet.setEnabled(true);
						break;
					case "2":
						mitem_MenuAuth.setEnabled(true);
						break;
					case "3":
						mitem_RCSH.setEnabled(true);
						break;
					case "4":
						mitem_Detail.setEnabled(true);
						break;
					case "5":
						mitem_Product.setEnabled(true);
						break;
					case "6":
						mitem_Preset.setEnabled(true);
						break;
					case "7":
						mitem_Analysis.setEnabled(true);
						break;
					case "8":
						mitem_sales_inquiry.setEnabled(true);
						break;

					default:
						break;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		db.dbDis();
		
	}
}
